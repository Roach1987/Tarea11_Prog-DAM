package programacion.dam.tarea11.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

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
    /**
     * Método en el que validaremos que el String llegado sean todo
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
    
        /**
     * Método que comprueba el formato de una fecha, el formato debe de ser yyyy-MM-dd HH:mm:ss.
     * @param fecha
     * @return boolean si la fecha es valida.
     */
    public static boolean validarFecha(String fecha) {
        boolean resultado;
        try {
            // Seteamos al formato fecha el modo  Modo no-permisivo
            // para que solo soporte el formato yyyy-MM-dd HH:mm:ss
            FORMATO_FECHA.setLenient(false);
            FORMATO_FECHA.parse(fecha);
            resultado = true;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            // Si la fecha llegada por parametro es invalida, el metodo devolvera
            // false
            resultado = false;
        }
        return resultado;
    }
    
    /**
     * Método que crea una fecha apartir de un String con el formato yyyy-MM-dd HH:mm:ss
     * @param fecha
     * @return Date
     */
    public static Date crearFecha(String fecha){
        Date fechaResultado = null;
        try {
            fechaResultado = FORMATO_FECHA.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return fechaResultado;
    }    
}
