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
     * M�todo para crear un nuevo avi�n en BDD
     * @param avion
     * @return boolean
     */
    public static boolean nuevoAvion(Avion avion){
        // Create
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try{
            // Establecemos la conexi�n con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query p�ra insertar el nuevo avi�n
            String query = " INSERT INTO avion (codigo, modelo, numero_plazas)"
               .concat(" VALUES (?, ?, ?)");

            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, avion.getCodigo());
            declaracion.setString (2, avion.getModelo());
            declaracion.setInt (3, avion.getNumeroPlazas());

            // ejecutamos la declaraci�n preparada
            int lineaAltereda = declaracion.executeUpdate();
            respuesta = lineaAltereda > 0;
            declaracion.close();
        }catch(SQLException ex){
            Util.mostrarMensaje(null, "Error al insertar el registro del nuevo avi�n", Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexi�n pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }    
        return respuesta;
    }
    
    /**
     * M�todo para borrar un avi�n de la BDD.
     * @param codigo
     * @return boolean
     */
    public static boolean borrarAvion(String codigo){
        // Delete
        boolean respuesta = false;
        Connection conexion = null;
        PreparedStatement declaracion = null;
        try {
            // Establecemos la conexi�n con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query p�ra insertar el nuevo avi�n
            String query = "DELETE FROM avion WHERE codigo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaraci�n preparada
            int lineaAlterada = declaracion.executeUpdate();
            respuesta = lineaAlterada > 0;
            declaracion.close();
        } catch (SQLException ex) {
            Util.mostrarMensaje(null, "Error al borrar el registro del avi�n con codigo ".concat(codigo),
                    Util.ADVERTENCIA);
        }finally{
            // Cerramos la conexi�n pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }
        return respuesta;
    }
    
    /**
     * M�todo para recuperar todos los aviones de la BDD
     * @return List
     */
    public static List<Avion> recuperarAviones(){
        // Read
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
            // Cerramos la conexi�n pase lo que pase.
            if(null != conexion){
                Util.cierraConexion(conexion);
            }
        }   
        return listaAviones;
    }
    
    /**
     * M�todo que busca en la tabla avion por el codigo llegado por parametro
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
            // Establecemos la conexi�n con la BDD.
            conexion = Util.establecerConexion();
            
            // Creamos la query p�ra insertar el nuevo avi�n
            String query = "SELECT codigo, modelo, numero_plazas FROM avion WHERE codigo = ?";
            declaracion = conexion.prepareStatement(query);
            declaracion.setString (1, codigo);
            
            // ejecutamos la declaraci�n preparada
            consulta = declaracion.executeQuery();
            
            if(consulta.next()){
                avion = new Avion(consulta.getString(1), consulta.getString(2), 
                                            consulta.getInt(3));
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
        return avion;
    }
}