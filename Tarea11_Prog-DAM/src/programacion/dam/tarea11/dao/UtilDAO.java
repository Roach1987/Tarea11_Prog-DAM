package programacion.dam.tarea11.dao;

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
     * M�todo que comprueba que un avi�n no tenga vuelos, si no los tiene
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
                mensaje = "Avi�n con codigo ".concat(codigo).concat(" borrado correctamente.");
            }else{
                mensaje = "No existe un avi�n con codigo ".concat(codigo);
            }
        }
        return mensaje;
    }
    
    /**
     * M�todo que transforma los datos del formulario de busqueda de vuelo
     * y los transforma para realizar la query necesaria.
     * @param origen
     * @param destino
     * @param fechaSalida
     * @return List
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
                listaArray.add(vuelo.toString());
            }
        }
        return listaArray;
    }
    
    /**
     * M�todo de paso para crear un nuevo vuelo.
     * @param codigoVuelo
     * @param codigoAvion
     * @param origen
     * @param destino
     * @param fechaSalidaString
     * @param fechaLlegadaString
     * @param fechaEscalaString
     * @return String
     */
    public static String crearNuevoVuelo (String codigoVuelo, String codigoAvion, String origen,
            String destino, String fechaSalidaString, String fechaLlegadaString, String fechaEscalaString){
    
        String respuesta = "";
        
        // Consultamos el numero de plazas que tiene el avi�n.
        int numeroPlazas = AvionDAO.buscarPlazasAvionPorCodigo(codigoAvion);
        
        if(numeroPlazas == 0){
            respuesta = "El avi�n no existe";
        }else{
            Date fechaSalida = Util.crearFecha(fechaSalidaString);
            Date fechaLlegada = Util.crearFecha(fechaLlegadaString);
            Date fechaEscala = (null != fechaEscalaString) ? Util.crearFecha(fechaEscalaString)
                    : null;
            Vuelo vuelo = new Vuelo(codigoVuelo, codigoAvion, numeroPlazas, origen, destino, 
                                    fechaSalida, fechaLlegada, fechaEscala);
            boolean vueloCreado = VueloDAO.crearVuelo(vuelo);
            respuesta = (vueloCreado) ? Util.OK : "Error al crear el vuelo.";
        }
        return respuesta;
    }
}