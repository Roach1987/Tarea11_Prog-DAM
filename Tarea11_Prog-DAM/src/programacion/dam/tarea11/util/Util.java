package programacion.dam.tarea11.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static final String OPERACION_FECHA_ESCALA = "FECHA_ESCALA";
    public static final String OPERACION_FECHA_SIN_ESCALA = "FECHA_SIN_ESCALA";
    public static final String OK = "OK";

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
        
        if (fecha == null)
            return new Timestamp(new Date().getTime());
        
        Timestamp timestamp = new Timestamp(fecha.getTime());
        return timestamp;
    }
    
        /**
     * M�todo que comprueba el formato de una fecha, el formato debe de ser dd/MM/yyyy HH:mm:ss.
     * @param fecha
     * @return boolean si la fecha es valida.
     */
    public static boolean validarFecha(String fecha) {
        boolean resultado;
        try {
            // Seteamos al formato fecha el modo  Modo no-permisivo
            // para que solo soporte el formato dd/MM/yyyy HH:mm:ss
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
     * M�todo que crea una fecha apartir de un String con el formato dd/MM/yyyy HH:mm:ss
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
    
    /**
     * M�todo que crea un String apartir de una Fecha con el formato dd/MM/yyyy HH:mm:ss
     * @param fecha
     * @return Date
     */
    public static String crearFechaString(Date fecha){
        String fechaResultado = null;
        fechaResultado = FORMATO_FECHA.format(fecha);
        return fechaResultado;
    }
    
    /**
     * Metodo que compara las diferentes fechas llegadas por parametro
     * compara que la fecha de escala sea mayor que la fecha de salida y menor que la fecha de llegada
     * tambien compara que la fecha de salida sea menor que la fecha de llegada.
     * @param fecha1
     * @param fecha2
     * @param fecha3
     * @param operacion
     * @return String
     */
    public static String compararFechas(String fecha1, String fecha2, String fecha3, String operacion){
        String resultado = "";
        Date primeraFecha = crearFecha(fecha1);
        Date segundaFecha = crearFecha(fecha2);
        Date fechaEscala = (null != fecha3) ? crearFecha(fecha3) : null;
        
        if(null != fecha3 && operacion.equals(OPERACION_FECHA_ESCALA)){
            if(primeraFecha.before(fechaEscala)){
                resultado = (segundaFecha.after(fechaEscala)) ? OK
                        : "La fecha de escala no puede ser mayor que la de llegada.";
            }else{
                resultado = "La fecha de escala no puede ser menor que la de salida.";
            }
        }else{
            resultado = (primeraFecha.before(segundaFecha)) ? OK 
                    : "La fecha salida no puede ser mayor que la de llegada.";
        }
        return resultado;
    }
}
