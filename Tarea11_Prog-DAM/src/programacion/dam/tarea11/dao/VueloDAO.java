package programacion.dam.tarea11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import programacion.dam.tarea11.beans.Vuelo;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class VueloDAO {
    
    /**
     * M�todo para un nuevo registro de vuelo en la BDD
     * @param vuelo
     * @return boolean
     */
    public static boolean crearVuelo(Vuelo vuelo){
        // Create
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try{
            // Establecemos la conexi�n con la BDD.
            conexion = Util.establecerConexion();
            
            
            
            // Continuar codigo inserci�n *************************************
            
            
        }catch(Exception ex){
            Util.mostrarMensaje(null, "Error al insertar el registro del nuevo vuelo", Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexi�n pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return respuesta;
    }
    
    /**
     * M�todo para borrar un vuelo de la BDD.
     * @param codigo
     */
    public static void borrarVuelo(String codigo){
        // Delete
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexi�n con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query p�ra insertar el nuevo avi�n
            String query = "DELETE FROM vuelo WHERE codigo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaraci�n preparada
            declaracion.execute();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro del vuelo con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexi�n pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }   
    }
    
    /**
     * M�todo para recuperar todos los aviones de la BDD
     * @return List
     */
    public static List<Vuelo> recuperarVuelos(){
        // Create
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
                Vuelo vuelo = new Vuelo(consulta.getString(1), consulta.getString(2), consulta.getInt(3), 
                                            consulta.getString(4), consulta.getString(5), consulta.getDate(6),
                                            consulta.getDate(7), consulta.getDate(8));
                listaVuelos.add(vuelo);
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar los registros de la tabla avion.",
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexi�n pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }   
        return listaVuelos;
    }
    
    /**
     * M�todo que busca en la tabla avion por el codigo llegado por parametro
     * @param codigo
     * @return Avion
     */
    public static Vuelo buscarAvionPorCodigo(String codigo){
        // Search
        Vuelo vuelo = null;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        ResultSet consulta = null;
        try {
            // Establecemos la conexi�n con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query p�ra insertar el nuevo avi�n
            String query = "SELECT codigo, codigo_avion, numero_plazas_disponibles, aeropuerto_origen, "
                    .concat("aeropuerto_destino, fecha_salida, fecha_llegada, fecha_escala FROM vuelo ")
                    .concat("WHERE codigo = ?");
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaraci�n preparada
            consulta = declaracion.executeQuery();
            
            if(consulta.next()){
                vuelo = new Vuelo(consulta.getString(1), consulta.getString(2), consulta.getInt(3), 
                                        consulta.getString(4), consulta.getString(5), consulta.getDate(6),
                                        consulta.getDate(7), consulta.getDate(8));
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar el registro del avi�n con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexi�n pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return vuelo;
    }
}
