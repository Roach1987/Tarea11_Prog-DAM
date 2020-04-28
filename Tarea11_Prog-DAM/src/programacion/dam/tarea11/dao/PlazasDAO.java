package programacion.dam.tarea11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import programacion.dam.tarea11.beans.Plazas;
import programacion.dam.tarea11.beans.Vuelo;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class PlazasDAO {
    
    /**
     * Método para crear nuevas Plazas en BDD
     * @param codigoVuelo
     * @param estadoPlaza
     * @param totalPlazas
     * @return boolean
     */
    public static boolean nuevasPlazas(String codigoVuelo, String estadoPlaza, int totalPlazas){
        // Create
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try{
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = " INSERT INTO plazas (codigo, codigo_vuelo, estado)"
               .concat(" VALUES (?, ?, ?)");
            
            int contador = 0;
            declaracion = conexion.prepareStatement(query);
            for(int i = 0; i < totalPlazas; i++){
                String codigo = (String.valueOf(i+1).length() == 1) ? "0".concat(String.valueOf(i+1)) : String.valueOf(i+1);
                declaracion.setString (1, codigo);
                declaracion.setString (2, codigoVuelo);
                declaracion.setString (3, estadoPlaza);
                
                // ejecutamos la declaración preparada
                int lineaAltereda = declaracion.executeUpdate();
                contador += lineaAltereda;
            }
            
            respuesta = contador > 0;
            declaracion.close();
        }catch(SQLException ex){
            Util.mostrarMensaje(null, "Error al insertar los registros de las nuevas plazas.", Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }    
        return respuesta;
    }
    
    /**
     * Método para actualizar una plaza en la BDD.
     * @param codigo
     * @param codigoVuelo
     * @param estado
     * @return boolean
     */
    public static boolean actualizarPlaza(String codigo, String codigoVuelo, String estado){
        // Update
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "UPDATE plazas SET estado = ? WHERE codigo = ? AND codigo_vuelo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, estado);
            declaracion.setString (2, codigo);
            declaracion.setString (3, codigoVuelo);
            
            // ejecutamos la declaración preparada
            int lineasAlteradas = declaracion.executeUpdate();
            respuesta = lineasAlteradas > 0;
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro de la plaza con codigo ".concat(codigo),
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
     * Método para borrar una plaza de la BDD.
     * @param codigo
     * @param codigoVuelo
     * @return boolean
     */
    public static boolean borrarPlaza(String codigo, String codigoVuelo){
        // Delete
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "DELETE FROM plazas WHERE codigo = ? AND codigo_vuelo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            declaracion.setString (2, codigoVuelo);
            
            // ejecutamos la declaración preparada
            int lineaAlterada = declaracion.executeUpdate();
            respuesta = lineaAlterada > 0;
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro de la plaza con codigo ".concat(codigo),
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
     * Método para borrar todas las plazas de un vuelo de la BDD.
     * @param codigoVuelo
     * @return boolean
     */
    public static boolean borrarTodasPlazasVuelo(String codigoVuelo){
        // Delete
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "DELETE FROM plazas WHERE codigo_vuelo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigoVuelo);
            
            // ejecutamos la declaración preparada
            int lineaAlterada = declaracion.executeUpdate();
            respuesta = lineaAlterada > 0;
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar los registros de las plazas con codigo de vuelo ".concat(codigoVuelo),
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
     * Método para recuperar todas las plazas de un vuelo de la BDD
     * @param codigoVuelo
     * @return List
     */
    public static List<Plazas> recuperarPlazasVuelo(String codigoVuelo){
        // Read
        List<Plazas> listaPlazas = new ArrayList();
        Connection conexion = null;
        PreparedStatement declaracion = null;
        ResultSet consulta = null;
        try {
            conexion = Util.establecerConexion();
            
            // Creamos la query para consultar la tabla avion
            String query = "SELECT codigo, codigo_vuelo, estado FROM plazas WHERE codigo_vuelo = ?";

            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigoVuelo);
            
            consulta = declaracion.executeQuery();
            
            while(consulta.next()){
                Plazas plaza = new Plazas(consulta.getString(1), consulta.getString(2), consulta.getString(3));
                listaPlazas.add(plaza);
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar los registros de las plazas con codigo de vuelo "
                    .concat(codigoVuelo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }   
        return listaPlazas;
    }
    
        /**
     * Método para recuperar todas las plazas de un vuelo de la BDD
     * @param codigo
     * @param codigoVuelo
     * @return Plaza
     */
    public static Plazas recuperarPlaza(String codigo, String codigoVuelo){
        // Search
        Plazas plaza = null;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        ResultSet consulta = null;
        try {
            conexion = Util.establecerConexion();
            
            // Creamos la query para consultar la tabla avion
            String query = "SELECT codigo, codigo_vuelo, estado FROM plazas WHERE codigo = ? AND codigo_vuelo = ?";

            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            declaracion.setString (2, codigoVuelo);
            
            consulta = declaracion.executeQuery();
            
            if(consulta.next()){
                plaza = new Plazas(consulta.getString(1), consulta.getString(2), consulta.getString(3));
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar los registros de la plaza con codigo de vuelo "
                    .concat(codigoVuelo).concat(" y codigo de plaza ").concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }   
        return plaza;
    }
}