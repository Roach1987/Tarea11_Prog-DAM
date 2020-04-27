package programacion.dam.tarea11.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import programacion.dam.tarea11.beans.Avion;
import programacion.dam.tarea11.beans.Vuelo;
import programacion.dam.tarea11.dao.AvionDAO;
import programacion.dam.tarea11.dao.VueloDAO;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class MenuAerolineas {
    
    public static void main(String[] args) {
//        List<Vuelo> lista = null;
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
//            String fechaSalidaString = "15/09/2014 13:15:00";
////            String fechaLlegadaString = "16/09/2014 17:15:00";
////            String fechaEscalaString = "15/09/2014 21:15:00";
////
//            java.util.Date fechaSalida = dateFormat.parse(fechaSalidaString);
////            java.util.Date fechaLlegada = dateFormat.parse(fechaLlegadaString);
////            java.util.Date fechaEscala = dateFormat.parse(fechaEscalaString);
////
////            Vuelo vuelo = new Vuelo("1","1", 25, "Madrid", "Bogota", fechaSalida, fechaLlegada, fechaEscala);
////            boolean bool = VueloDAO.crearVuelo(vuelo);
//              lista = VueloDAO.buscarVuelosPorParametros("Madrid", "Bogota", fechaSalida);
//        } catch (ParseException ex) {
//            
//        }
        boolean bool = VueloDAO.actualizarVuelo("1", 24);
        
    }
}
