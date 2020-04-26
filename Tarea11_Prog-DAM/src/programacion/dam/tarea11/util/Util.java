package programacion.dam.tarea11.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Roach
 */
public class Util {
    
    // Constantes de clase
    public static final int INFORMACION = JOptionPane.INFORMATION_MESSAGE;
    public static final int ADVERTENCIA = JOptionPane.WARNING_MESSAGE;
    public static final int ERROR = JOptionPane.ERROR_MESSAGE;

// ************************************************************************************************
// ************************************ Conexion BDD **********************************************
// ************************************************************************************************
    
    /**
     * M�todo que establece la conexi�n con la BDD MySQL
     * @return Connection
     */
    public static Connection establecerConexion(){
        Connection conexion = null;
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/aerolinea?serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            mostrarMensaje(null, "Error al crear la conexi�n con MySQL", ERROR);
        }
        return conexion;
    }
    
    /**
     * M�todo que cierra la conexi�n llegada por parametro
     * @param conexion 
     */
    public static void cierraConexion(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException ex) {
            mostrarMensaje(null, "Error al cerrar conexion", ERROR);
        }
    }

// ************************************************************************************************
// ************************************ Validaciones **********************************************
// ************************************************************************************************    
    
    
    
// ************************************************************************************************
// ************************************ Utilitarios ***********************************************
// ************************************************************************************************        
    /**
     * M�todo para mostrar mensajes de error generados en el flujo del programa.
     * @param panel
     * @param mensaje 
     * @param severidad 
     */
    public static void mostrarMensaje(JPanel panel,String mensaje, int severidad){
        JOptionPane.showMessageDialog(panel, mensaje, "Informaci�n del sistema", 
                severidad);
    }
}
