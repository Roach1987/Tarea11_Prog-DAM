package programacion.dam.tarea11.dao;

/**
 *
 * @author Roach
 */
public class UtilDAO {
    
    /**
     * Método que comprueba que un avión no tenga vuelos, si no los tiene
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
                mensaje = "Avión con codigo ".concat(codigo).concat(" borrado correctamente.");
            }else{
                mensaje = "No existe un avión con codigo ".concat(codigo);
            }
        }
        return mensaje;
    }
}
