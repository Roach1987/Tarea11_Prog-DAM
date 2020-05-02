package programacion.dam.tarea11.ventanas.vuelo;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import programacion.dam.tarea11.beans.Vuelo;
import programacion.dam.tarea11.dao.VueloDAO;

/**
 *
 * @author Roach
 */
public class VentanaVueloLista extends javax.swing.JPanel {

    // Atributos
    public DefaultTableModel modelo;
    private boolean existenDatos = false;
    
    /**
     * Creates new form VentanaVueloLista
     */
    public VentanaVueloLista() {
        initComponents();
    }

    /**
     * M�todo que pinta el panel en la ventana vuelo.
     * @return 
     */
    public JPanel ventanaListaVuelo() {
        // Pintamos los atributos mas importantes de los vuelos.
        String[] columnas = {"C�d","Cod Avion", "N� Plz Disp", "Origen", "Destino", "F.Sal", "F.Lleg", "F.Escala"};
        modelo = new DefaultTableModel(null, columnas);

        tablaListaVuelos.setModel(modelo);
        // Cargamos la lista de los vuelos.
        this.cargarListaVuelos();
        
        existenDatos = true;
        return this;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaVuelos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        tablaListaVuelos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tablaListaVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Cod Avion", "N� Plz Disp", "Origen", "Destino", "F Sal", "F Lleg", "F Escala"
            }
        ));
        jScrollPane1.setViewportView(tablaListaVuelos);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("LISTA VUELOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(187, 187, 187))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

// ***************************************************************************************************
// ************************************ Utilidades de la Clase ***************************************
// ***************************************************************************************************
    
    /**
     * M�todo auxiliar que limpia la tabla.
     */
    private void borrarTabla(){
        int longitud = tablaListaVuelos.getRowCount()-1;  
        for(int i = longitud; i >= 0; i--){
            modelo.removeRow(i);
        }
    }
    
    /**
     * M�todo que carga los articulos que se encuentran en la lista temporal,
     * y recoge los datos mas importantes para cargarlos en la tabla.
     */
    private void cargarListaVuelos(){
        // Liampiamos la tabla al cargar nuevos aviones, para evitar duplicidades.
        if(existenDatos){
            borrarTabla();
        }
        
        List<Vuelo> listaAviones = VueloDAO.recuperarVuelos();
        
        for(Vuelo vuelo : listaAviones){
            // Creamos un array para recoger los datos necesarios de cada vuelo.
            String numeroPlazas = String.valueOf(vuelo.getNumeroPlazasDisponibles());
            String fechaEscala = (null != vuelo.getFechaEscala()) ? vuelo.getFechaEscala().toString() : null;
            String [] fila = {vuelo.getCodigo(), vuelo.getCodigoAvion(), numeroPlazas, vuelo.getAeropuertoOrigen(),
                                vuelo.getAeropuertoDestino(), vuelo.getFechaSalida().toString(), 
                                vuelo.getFechaLlegada().toString(), fechaEscala};
    
            // A�adimos a la tabla los datos de la cuenta actual.
            modelo.addRow(fila);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaListaVuelos;
    // End of variables declaration//GEN-END:variables
}
