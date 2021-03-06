package programacion.dam.tarea11.ventanas;

import javax.swing.SwingUtilities;
import programacion.dam.tarea11.ventanas.avion.VentanaAvionPrincipal;
import programacion.dam.tarea11.ventanas.vuelo.VentanaVueloPrincipal;

/**
 *
 * @author Roach
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    // Atributos
    VentanaAvionPrincipal ventanaAvionPrincipal;
    VentanaVueloPrincipal ventanaVueloPricipal;

    /**
     * Creates new form Principal
     */
    public VentanaPrincipal() {
        initComponents();
        ventanaAvionPrincipal = new VentanaAvionPrincipal();
        ventanaVueloPricipal = new VentanaVueloPrincipal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotones = new javax.swing.JPanel();
        bAviones = new javax.swing.JButton();
        bVuelos = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jtbAccionesPrincipales = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bAviones.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        bAviones.setText("Aviones");
        bAviones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAvionesActionPerformed(evt);
            }
        });

        bVuelos.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        bVuelos.setText("Vuelos");
        bVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVuelosActionPerformed(evt);
            }
        });

        bSalir.setBackground(new java.awt.Color(204, 204, 0));
        bSalir.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBotonesLayout.createSequentialGroup()
                        .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bVuelos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bAviones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2))
                .addGap(29, 29, 29))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(bAviones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(bVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programacion/dam/tarea11/imagenes/Cabecera.png"))); // NOI18N

        jtbAccionesPrincipales.setRollover(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtbAccionesPrincipales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtbAccionesPrincipales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acci�n para salir de la aplicaci�n.
     * @param evt 
     */
    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed

    /**
     * Acci�n para gestionar los aviones
     * @param evt 
     */
    private void bAvionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAvionesActionPerformed
        // limpiamos el panel
        jtbAccionesPrincipales.removeAll();
        jtbAccionesPrincipales.add(ventanaAvionPrincipal.AvionPrincipalPanel());
        // Cambiamos el aspecto del panel auxiliar y pintamos la vista de Ingresar en cuenta.
        SwingUtilities.updateComponentTreeUI(this); 
    }//GEN-LAST:event_bAvionesActionPerformed

    /**
     * Acci�n para gestionar los vuelos
     * @param evt 
     */
    private void bVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVuelosActionPerformed
        // limpiamos el panel
        jtbAccionesPrincipales.removeAll();
        jtbAccionesPrincipales.add(ventanaVueloPricipal.vueloPrincipalPanel());
        // Cambiamos el aspecto del panel auxiliar y pintamos la vista de Ingresar en cuenta.
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_bVuelosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAviones;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bVuelos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jtbAccionesPrincipales;
    // End of variables declaration//GEN-END:variables
}
