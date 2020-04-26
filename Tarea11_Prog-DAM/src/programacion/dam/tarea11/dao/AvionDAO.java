package programacion.dam.tarea11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import programacion.dam.tarea11.beans.Avion;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class AvionDAO {
    
    /**
     * Método para crear un nuevo avión en BDD
     * @param avion
     * @return boolean
     */
    public static boolean nuevoAvion(Avion avion){
        // Create
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try{
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = " INSERT INTO avion (codigo, modelo, numero_plazas)"
               .concat(" VALUES (?, ?, ?)");

            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, avion.getCodigo());
            declaracion.setString (2, avion.getModelo());
            declaracion.setInt (3, avion.getNumeroPlazas());

            // ejecutamos la declaración preparada
            declaracion.execute();
            declaracion.close();
            respuesta = true;
        }catch(SQLException ex){
            Util.mostrarMensaje(null, "Error al insertar el registro del nuevo avión", Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }    
        return respuesta;
    }
    
    /**
     * Método para borrar un avión de la BDD.
     * @param codigo
     */
    public static void borrarAvion(String codigo){
        // Delete
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "DELETE FROM avion WHERE codigo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaración preparada
            declaracion.execute();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro del avión con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }   
    }
    
    /**
     * Método para recuperar todos los aviones de la BDD
     * @return List
     */
    public static List<Avion> recuperarAviones(){
        // Create
        List<Avion> listaAviones = new ArrayList();
        Connection conexion = null;
        Statement declaracion = null;
        ResultSet consulta = null;
        try {
            conexion = Util.establecerConexion();
            declaracion = conexion.createStatement();
            
            // Creamos la query para consultar la tabla avion
            String query = "SELECT codigo, modelo, numero_plazas FROM avion";
            
            consulta = declaracion.executeQuery(query);
            
            while(consulta.next()){
                Avion avion = new Avion(consulta.getString(1), consulta.getString(2), 
                                            consulta.getInt(3));
                listaAviones.add(avion);
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
        return listaAviones;
    }
    
    /**
     * Método que busca en la tabla avion por el codigo llegado por parametro
     * @param codigo
     * @return Avion
     */
    public static Avion buscarAvionPorCodigo(String codigo){
        // Search
        Avion avion = null;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        ResultSet consulta = null;
        try {
            // Establecemos la conexión con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query pàra insertar el nuevo avión
            String query = "SELECT codigo, modelo, numero_plazas FROM avion WHERE codigo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaración preparada
            consulta = declaracion.executeQuery();
            
            if(consulta.next()){
                avion = new Avion(consulta.getString(1), consulta.getString(2), 
                                            consulta.getInt(3));
            }
            consulta.close();
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al recuperar el registro del avión con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexión pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return avion;
    }
}