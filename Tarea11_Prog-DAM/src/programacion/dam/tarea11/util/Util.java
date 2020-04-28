package programacion.dam.tarea11.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
    public static final String PLAZA_RESERVADA = "Reservada";
    public static final String PLAZA_DISPONIBLE = "Disponible";

// ************************************************************************************************
// ************************************ Conexion BDD **********************************************
// ************************************************************************************************
    
    /**
     * Método que establece la conexión con la BDD MySQL
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
            mostrarMensaje(null, "Error al crear la conexión con MySQL", ERROR);
        }
        return conexion;
    }
    
    /**
     * Método que cierra la conexión llegada por parametro
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
     * Método para mostrar mensajes de error generados en el flujo del programa.
     * @param panel
     * @param mensaje 
     * @param severidad 
     */
    public static void mostrarMensaje(JPanel panel,String mensaje, int severidad){
        JOptionPane.showMessageDialog(panel, mensaje, "Información del sistema", 
                severidad);
    }
    
    /**
     * Método que convierte una fecha java.util.Date a java.sql.Timestamp
     * @param fecha
     * @return java.sql.Timestamp
     */
    public static Timestamp convertirFechas(Date fecha) {
        Timestamp timestamp = new Timestamp(fecha.getTime());
        return timestamp;
    }
    
}
