package programacion.dam.tarea11.dao;

/**
 *
 * @author Roach
 */
public class UtilDAO {
    
    /**
     * M�todo que comprueba que un avi�n no tenga vuelos, si no los tiene
     * borra el registro del avion si existe
     * @param codigo
     * @return String
     */
    public static String borrarAvion(String codigo){
        String mensaje = "";
        if(VueloDAO.buscarVueloPorCodigoAvion(codigo)){
            mensaje = "El Avion tiene vuelos en curso";
        }else{
            boolean avionBorrado = AvionDAO.borrarAvion(codigo);
                
            if(avionBorrado){
                mensaje = "Avi�n con codigo ".concat(codigo).concat(" borrado correctamente.");
            }else{
                mensaje = "No existe un avi�n con codigo ".concat(codigo);
            }
        }
        return mensaje;
    }
}
