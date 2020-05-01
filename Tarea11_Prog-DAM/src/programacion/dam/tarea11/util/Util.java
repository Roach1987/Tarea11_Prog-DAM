package programacion.dam.tarea11.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public static final String DISTINTIVO_BORRAR = "BORRAR";
    public static final String DISTINTIVO_CONSULTAR = "CONSULTAR";

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
    /**
     * M�todo en el que validaremos que el String llegado sean todo
     * numeros.
     * @param cadena
     * @return (boolean) true si todos los caracteres de la cadena llegada son
     * numeros.
     */
    public static boolean validaNumeros(String cadena) {
        boolean resultado = true;
        int longitud = cadena.length();

        // Recorremos la cadena llegada
        for (int i = 0; i < longitud; i++) {
            // Comprobamos que el caracter es un numero.
            if (!Character.isDigit(cadena.charAt(i))) {
                resultado = false;
                break;
            }
        }
        return resultado;
    }
    
    
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
    
    /**
     * M�todo que convierte una fecha java.util.Date a java.sql.Timestamp
     * @param fecha
     * @return java.sql.Timestamp
     */
    public static Timestamp convertirFechas(Date fecha) {
        Timestamp timestamp = new Timestamp(fecha.getTime());
        return timestamp;
    }
    
    
}
