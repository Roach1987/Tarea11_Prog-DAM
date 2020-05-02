package programacion.dam.tarea11.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import programacion.dam.tarea11.beans.Vuelo;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class UtilDAO {
    
    /**
     * Método que comprueba que un avión no tenga vuelos, si no los tiene
     * borra el registro del avion si existe
     * @param codigo
     * @return String
     */
    public static String borrarAvion(String codigo){
        String mensaje = "";
        if(VueloDAO.buscarVueloPorCodigoAvion(codigo)){
            mensaje = "El Avion tiene vuelos en curso";
        }else{
            boolean avionBorrado = AvionDAO.borrarAvion(codigo);
                
            if(avionBorrado){
                mensaje = "Avión con codigo ".concat(codigo).concat(" borrado correctamente.");
            }else{
                mensaje = "No existe un avión con codigo ".concat(codigo);
            }
        }
        return mensaje;
    }
    
    /**
     * Método que transforma los datos del formulario de busqueda de vuelo
     * y los transforma para realizar la query necesaria.
     * @param origen
     * @param destino
     * @param fechaSalida
     * @return String []
     */
    public static List<String> buscarVuelo(String origen, String destino, String fechaSalida){
        List<Vuelo> lista = null;
        List<String> listaArray = null;
        boolean validarFecha = Util.validarFecha(fechaSalida);
        
        // Si la fecha es valida se transforma y se hace la query con los datos recibidos.
        if(validarFecha){
            Date fechaSalidaValida = Util.crearFecha(fechaSalida);
            lista = VueloDAO.buscarVuelosPorParametros(origen, destino, fechaSalidaValida);
        }
        
        // Si se recuperan datos de la BDD se escriben en la lista de respuesta
        if(null != lista && !lista.isEmpty()){
            listaArray = new ArrayList();
            String inicio = "Datos de vuelos recuperados".concat("\n");
            listaArray.add(inicio);
            for(Vuelo vuelo : lista){
                String numeroPlazas = String.valueOf(vuelo.getNumeroPlazasDisponibles());
                String fechaEscala = (null != vuelo.getFechaEscala()) ? vuelo.getFechaEscala().toString()
                        : "Sin fecha de escala.";
                String aux = "Codigo Vuelo: ".concat(vuelo.getCodigo()).concat("\n")
                        .concat("Codigo Avion: ").concat(vuelo.getCodigoAvion()).concat("\n")
                        .concat("Plazas disponibles: ").concat(numeroPlazas).concat("\n")
                        .concat("Aeropuerto Origen: ").concat(vuelo.getAeropuertoOrigen()).concat("\n")
                        .concat("Aeropuerto Destino: ").concat(vuelo.getAeropuertoDestino()).concat("\n")
                        .concat("Fecha Salida: ").concat(vuelo.getFechaSalida().toString()).concat("\n")
                        .concat("Fecha Llegada: ").concat(vuelo.getFechaLlegada().toString()).concat("\n")
                        .concat(fechaEscala);
                listaArray.add(aux);
            }
        }
        return listaArray;
    }
}
