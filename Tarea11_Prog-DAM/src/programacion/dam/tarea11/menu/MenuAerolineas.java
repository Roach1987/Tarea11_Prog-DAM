package programacion.dam.tarea11.menu;

import programacion.dam.tarea11.beans.Avion;
import programacion.dam.tarea11.dao.AvionDAO;

/**
 *
 * @author Roach
 */
public class MenuAerolineas {
    
    public static void main(String[] args) {
    
        Avion avion = AvionDAO.buscarAvionPorCodigo("1");
        
    }
}
