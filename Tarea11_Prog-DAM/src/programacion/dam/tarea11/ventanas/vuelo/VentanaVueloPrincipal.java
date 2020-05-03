package programacion.dam.tarea11.ventanas.vuelo;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Roach
 */
public class VentanaVueloPrincipal extends javax.swing.JPanel {

    // Atributos
    VentanaVueloLista ventanaVueloLista;
    VentanaVueloCrear ventanaVueloCrear;
    VentanaVueloBuscar ventanaVueloBuscar;
    VentanaVueloBorrar ventanaVueloBorrar;
    
    /**
     * Creates new form VentanaVueloPrincipal
     */
    public VentanaVueloPrincipal() {
        initComponents();
        ventanaVueloLista = new VentanaVueloLista();
        ventanaVueloCrear = new VentanaVueloCrear();
        ventanaVueloBuscar = new VentanaVueloBuscar();
        ventanaVueloBorrar = new VentanaVueloBorrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bListaVuelos = new javax.swing.JButton();
        bBuscarVuelo = new javax.swing.JButton();
        bCrearVuelo = new javax.swing.JButton();
        bBorrarVuelo = new javax.swing.JButton();
        jtbAccionesVuelo = new javax.swing.JToolBar();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("VUELOS");

        bListaVuelos.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        bListaVuelos.setText("LISTA");
        bListaVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bListaVuelosActionPerformed(evt);
            }
        });

        bBuscarVuelo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        bBuscarVuelo.setText("BUSCAR");
        bBuscarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarVueloActionPerformed(evt);
            }
        });

        bCrearVuelo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        bCrearVuelo.setText("CREAR");
        bCrearVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearVueloActionPerformed(evt);
            }
        });

        bBorrarVuelo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        bBorrarVuelo.setText("BORRAR");
        bBorrarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bListaVuelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bBuscarVuelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCrearVuelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bBorrarVuelo, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(bListaVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(bBuscarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(bCrearVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(bBorrarVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jtbAccionesVuelo.setRollover(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtbAccionesVuelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtbAccionesVuelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JPanel vueloPrincipalPanel() {
        return this;
    }
    /**
     * Acci�n Buscar vuelo
     * @param evt 
     */
    private void bBuscarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarVueloActionPerformed
        // limpiamos el panel
        jtbAccionesVuelo.removeAll();
        jtbAccionesVuelo.add(ventanaVueloBuscar.ventanaBuscarVuelo());
        // Pintamos el panel auxiliar
        SwingUtilities.updateComponentTreeUI(this); 
        
    }//GEN-LAST:event_bBuscarVueloActionPerformed

    /**
     * Acci�n listar vuelos
     * @param evt 
     */
    private void bListaVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bListaVuelosActionPerformed
        // limpiamos el panel
        jtbAccionesVuelo.removeAll();
        jtbAccionesVuelo.add(ventanaVueloLista.ventanaListaVuelo());
        // Pintamos el panel auxiliar
        SwingUtilities.updateComponentTreeUI(this); 
    }//GEN-LAST:event_bListaVuelosActionPerformed

    /**
     * Acci�n crear vuelo
     * @param evt 
     */
    private void bCrearVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearVueloActionPerformed
        // limpiamos el panel
        jtbAccionesVuelo.removeAll();
        jtbAccionesVuelo.add(ventanaVueloCrear.ventanaCrearVuelo());
        // Pintamos el panel auxiliar
        SwingUtilities.updateComponentTreeUI(this); 
        
    }//GEN-LAST:event_bCrearVueloActionPerformed

    /**
     * Acci�n borrar vuelo
     * @param evt 
     */
    private void bBorrarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarVueloActionPerformed
        // limpiamos el panel
        jtbAccionesVuelo.removeAll();
        jtbAccionesVuelo.add(ventanaVueloBorrar.ventanaBorrarVuelo());
        // Pintamos el panel auxiliar
        SwingUtilities.updateComponentTreeUI(this); 
        
    }//GEN-LAST:event_bBorrarVueloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBorrarVuelo;
    private javax.swing.JButton bBuscarVuelo;
    private javax.swing.JButton bCrearVuelo;
    private javax.swing.JButton bListaVuelos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jtbAccionesVuelo;
    // End of variables declaration//GEN-END:variables
}
