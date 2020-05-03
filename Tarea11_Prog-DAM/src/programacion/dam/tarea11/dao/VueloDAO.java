package programacion.dam.tarea11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import programacion.dam.tarea11.beans.Vuelo;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class VueloDAO {
    
    /**
     * Método para un nuevo registro de vuelo en la BDD
     * @param vuelo
     * @return boolean
     */
    public static boolean crearVuelo(Vuelo vuelo){
        // Create
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try{
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo vuelo.
            String query = " INSERT INTO vuelo (codigo, codigo_avion, numero_plazas_disponibles, aeropuerto_origen, "
                    .concat("aeropuerto_destino, fecha_salida, fecha_llegada, fecha_escala)")
               .concat(" VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, vuelo.getCodigo());
            declaracion.setString (2, vuelo.getCodigoAvion());
            declaracion.setInt (3, vuelo.getNumeroPlazasDisponibles());
            declaracion.setString(4, vuelo.getAeropuertoOrigen());
            declaracion.setString(5, vuelo.getAeropuertoDestino());
            Timestamp fechaSalida = Util.convertirFechas(vuelo.getFechaSalida());
            declaracion.setTimestamp(6, fechaSalida, Calendar.getInstance());
            Timestamp fechaLlegada = Util.convertirFechas(vuelo.getFechaLlegada());
            declaracion.setTimestamp(7, fechaLlegada, Calendar.getInstance());
            
            // Si existe fecha de escala la introducimos en la BDD, si no enviamos un null.
            if(null != vuelo.getFechaEscala()){
                Timestamp fechaEscala = Util.convertirFechas(vuelo.getFechaEscala());
                declaracion.setTimestamp(8, fechaEscala, Calendar.getInstance());
            }else{
                declaracion.setDate(8, null);
            }
            
            // ejecutamos la declaración preparada
            int lineaAlterada = declaracion.executeUpdate();
            declaracion.close();
            respuesta = lineaAlterada > 0;         
        }catch(SQLException ex){
            Util.mostrarMensaje(null, "Error al insertar el registro del nuevo vuelo", Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return respuesta;
    }
    
    /**
     * Método para borrar un vuelo de la BDD.
     * @param codigo
     * @return boolean
     */
    public static boolean borrarVuelo(String codigo){
        // Delete
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "DELETE FROM vuelo WHERE codigo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaración preparada
            int lineasAlteradas = declaracion.executeUpdate();
            respuesta = lineasAlteradas > 0;
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro del vuelo con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return respuesta;
    }
    
        /**
     * Método para borrar un vuelo de la BDD.
     * @param codigoAvion
     * @param aeropuestoSalida
     * @param fechaSalida
     * @return boolean
     */
        public static int borrarVueloPorParametros(String codigoAvion, String aeropuestoSalida, Date fechaSalida){
        // Delete
        int respuesta = 0;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "DELETE FROM vuelo WHERE codigo_avion = ? AND aeropuerto_origen = ? AND fecha_salida = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigoAvion);
            declaracion.setString (2, aeropuestoSalida);
            Timestamp fechaSalidaBusqueda = Util.convertirFechas(fechaSalida);
            declaracion.setTimestamp(3, fechaSalidaBusqueda, Calendar.getInstance());
            
            // ejecutamos la declaración preparada
            int lineasAlteradas = declaracion.executeUpdate();
            respuesta = lineasAlteradas;
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro del vuelo con parametros ".concat(codigoAvion)
                    .concat(" - ").concat(aeropuestoSalida).concat(" - ").concat(fechaSalida.toString()),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return respuesta;
    }
    
    /**
     * Método para actualizar un vuelo de la BDD.
     * @param codigo
     * @param numeroPlazas
     * @return boolean
     */
    public static boolean actualizarVuelo(String codigo, int numeroPlazas){
        // Update
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "UPDATE vuelo SET numero_plazas_disponibles = ? WHERE codigo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setInt (1, numeroPlazas);
            declaracion.setString (2, codigo);
            
            // ejecutamos la declaración preparada
            int lineasAlteradas = declaracion.executeUpdate();
            respuesta = lineasAlteradas > 0;
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro del vuelo con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return respuesta;
    }
    
    /**
     * Método para recuperar todos los vuelos de la BDD
     * @return List
     */
    public static List<Vuelo> recuperarVuelos(){
        // Read
        List<Vuelo> listaVuelos = new ArrayList();
        Connection conexion = null;
        Statement declaracion = null;
        ResultSet consulta = null;
        try {
            conexion = Util.establecerConexion();
            declaracion = conexion.createStatement();
            
            // Creamos la query para consultar la tabla avion
            String query = "SELECT codigo, codigo_avion, numero_plazas_disponibles, aeropuerto_origen, "
                    .concat("aeropuerto_destino, fecha_salida, fecha_llegada, fecha_escala FROM vuelo");

            consulta = declaracion.executeQuery(query);
            
            while(consulta.next()){
                // Recogemos las fechas obtenendolas con el getString para obtener
                // tambien las horas
                Date fechaSalida = Timestamp.valueOf(consulta.getString(6));
                Date fechaLlegada = Timestamp.valueOf(consulta.getString(7));
                Date fechaEscala = (null != consulta.getString(8)) ? 
                        Timestamp.valueOf(consulta.getString(8)) : null;

                Vuelo vuelo = new Vuelo(consulta.getString(1), consulta.getString(2), consulta.getInt(3), 
                                            consulta.getString(4), consulta.getString(5), fechaSalida,
                                            fechaLlegada, fechaEscala);
                listaVuelos.add(vuelo);
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar los registros de la tabla avion.",
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }   
        return listaVuelos;
    }
    
    /**
     * Método que busca en la tabla vuelo por el codigo llegado por parametro
     * @param codigo
     * @return Avion
     */
    public static Vuelo buscarVueloPorCodigo(String codigo){
        // Search
        Vuelo vuelo = null;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        ResultSet consulta = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "SELECT codigo, codigo_avion, numero_plazas_disponibles, aeropuerto_origen, "
                    .concat("aeropuerto_destino, fecha_salida, fecha_llegada, fecha_escala FROM vuelo ")
                    .concat("WHERE codigo = ?");
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaración preparada
            consulta = declaracion.executeQuery();
            
            if(consulta.next()){
                vuelo = new Vuelo(consulta.getString(1), consulta.getString(2), consulta.getInt(3), 
                                        consulta.getString(4), consulta.getString(5), consulta.getDate(6),
                                        consulta.getDate(7), consulta.getDate(8));
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar el registro del vuelo con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return vuelo;
    }
    
        /**
     * Método que busca en la tabla vuelo por el codigo de avión llegado por parametro
     * devuelve true si existe por lo menos un vuelo asociado al avion.
     * @param codigoAvion
     * @return boolean
     */
    public static boolean buscarVueloPorCodigoAvion(String codigoAvion){
        // Search
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        ResultSet consulta = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "SELECT codigo FROM vuelo "
                    .concat("WHERE codigo_avion = ?");
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigoAvion);
            
            // ejecutamos la declaración preparada
            consulta = declaracion.executeQuery();
            
            respuesta = consulta.next();
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar el registro de los vuelos del avion con codigo ".
                    concat(codigoAvion), Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return respuesta;
    }
    
    /**
     * Método que busca en la tabla vuelo por los parametros llegados y devuelve la lista coincidente
     * @param aeropuertoOrigen
     * @param aeropuertoDestino
     * @param fechaSalida
     * @return List
     */
    public static List<Vuelo> buscarVuelosPorParametros(String aeropuertoOrigen, String aeropuertoDestino,
            Date fechaSalida){
        // Search
        List<Vuelo> listaVuelos = new ArrayList();
        Connection conexion = null;
        PreparedStatement declaracion = null;
        ResultSet consulta = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "SELECT codigo, codigo_avion, numero_plazas_disponibles, aeropuerto_origen, "
                    .concat("aeropuerto_destino, fecha_salida, fecha_llegada, fecha_escala FROM vuelo ")
                    .concat("WHERE aeropuerto_origen = ? AND ")
                    .concat("aeropuerto_destino = ? ")
                    .concat("AND fecha_salida = ?");
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, aeropuertoOrigen);
            declaracion.setString (2, aeropuertoDestino);
            Timestamp fechaSalidaBusqueda = Util.convertirFechas(fechaSalida);
            declaracion.setTimestamp(3, fechaSalidaBusqueda, Calendar.getInstance());

            // ejecutamos la declaración preparada
            consulta = declaracion.executeQuery();
            while(consulta.next()){
                
                Vuelo vuelo = new Vuelo(
                        consulta.getString(1), 
                        consulta.getString(2), 
                        consulta.getInt(3), 
                        consulta.getString(4), 
                        consulta.getString(5), 
                        Timestamp.valueOf(consulta.getString(6)),
                        Timestamp.valueOf(consulta.getString(7)), 
                        (null != consulta.getString(8)) ? 
                            Timestamp.valueOf(consulta.getString(8)) : null
                );
                listaVuelos.add(vuelo);
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            Util.mostrarMensaje(null, "Error al recuperar el registro del avión con parametros "
                    .concat(aeropuertoOrigen).concat(" - ").concat(aeropuertoDestino).concat(" - ")
                    .concat(fechaSalida.toString()),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return listaVuelos;
    }
}