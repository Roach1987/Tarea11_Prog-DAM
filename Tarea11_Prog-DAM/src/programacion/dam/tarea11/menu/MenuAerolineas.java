package programacion.dam.tarea11.menu;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import programacion.dam.tarea11.beans.Vuelo;
import programacion.dam.tarea11.dao.VueloDAO;
import programacion.dam.tarea11.ventanas.VentanaPrincipal;

/**
 *
 * @author Roach
 */
public class MenuAerolineas {
    
    public static void main(String[] args){

//        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
//        ventanaPrincipal.setVisible(true);

        List<Vuelo> lista = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaSalidaString = "15/09/2014 10:00:00";
            String fechaLlegadaString = "16/09/2014 17:15:00";
            String fechaEscalaString = "15/09/2014 21:15:00";
//
            java.util.Date fechaSalida = dateFormat.parse(fechaSalidaString);
            java.util.Date fechaLlegada = dateFormat.parse(fechaLlegadaString);
            java.util.Date fechaEscala = dateFormat.parse(fechaEscalaString);
            Timestamp timestamp = new Timestamp(fechaSalida.getTime());
//
            Vuelo vuelo = new Vuelo("2","1", 25, "Madrid", "Lisboa", fechaSalida, fechaLlegada, fechaEscala);
            boolean bool = VueloDAO.crearVuelo(vuelo);
              lista = VueloDAO.buscarVuelosPorParametros("Madrid", "Lisboa", fechaSalida);
        } catch (ParseException ex) {
            
        } 
   }
}
