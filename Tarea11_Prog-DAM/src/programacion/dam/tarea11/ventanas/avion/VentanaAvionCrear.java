package programacion.dam.tarea11.ventanas.avion;

import javax.swing.JPanel;
import programacion.dam.tarea11.beans.Avion;
import programacion.dam.tarea11.dao.AvionDAO;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class VentanaAvionCrear extends javax.swing.JPanel {

    /**
     * Creates new form VentanaAvionCrear
     */
    public VentanaAvionCrear() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tCodigoAvion = new javax.swing.JTextField();
        tModeloAvion = new javax.swing.JTextField();
        tNumPlazasAvion = new javax.swing.JTextField();
        bCrearAvion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        bCrearAvion.setBackground(new java.awt.Color(204, 204, 0));
        bCrearAvion.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        bCrearAvion.setText("CREAR");
        bCrearAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearAvionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("CODIGO:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("MODELO:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setText("NUMERO PLAZAS:");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setText("CREAR AVION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(183, 183, 183))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tModeloAvion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigoAvion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNumPlazasAvion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(bCrearAvion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tCodigoAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tModeloAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNumPlazasAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(bCrearAvion)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public JPanel ventanaNuevoAvion() {
        return this;
    }
    
    /**
     * Acci�n para crear un nuevo avi�n.
     * @param evt 
     */
    private void bCrearAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearAvionActionPerformed
        
        // Realizamos las validaciones de los campos
        if(validarFormulario()){
            // Creamos el objeto avion
            int numeroPlazas = Integer.parseInt(tNumPlazasAvion.getText());
            Avion avion = new Avion(tCodigoAvion.getText(), tModeloAvion.getText(), numeroPlazas);
            
            // Creamos el nuevo registro en BDD
            boolean avionCreado = AvionDAO.nuevoAvion(avion);
            
            if(avionCreado){
                Util.mostrarMensaje(this, "Avion creado correctamente con codigo ".concat(tCodigoAvion.getText()),
                        Util.INFORMACION);
            }
            
            tCodigoAvion.setText("");
            tModeloAvion.setText("");
            tNumPlazasAvion.setText("");
        }
    }//GEN-LAST:event_bCrearAvionActionPerformed

// ***************************************************************************************************
// ************************************ Utilidades de la Clase ***************************************
// ***************************************************************************************************
    
    /**
     * M�todo que realiza las validaciones del formulario de creaci�n de aviones
     * @return boolean
     */
    private boolean validarFormulario(){
        // Codigo avi�n
        if(tCodigoAvion.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Codigo no puede estar vacio", Util.INFORMACION);
            return false;
        }
        
        // Modelo del avi�n
        if(tModeloAvion.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Modelo no puede estar vacio", Util.INFORMACION);
            return false;
        }
        
        if(tNumPlazasAvion.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Numero de Plazas no puede estar vacio", Util.INFORMACION);
            return false;
        }else if(!Util.validaNumeros(tNumPlazasAvion.getText().trim())){
            Util.mostrarMensaje(this, "El campo Numero de Plazas tiene que ser numerico", Util.INFORMACION);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrearAvion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tCodigoAvion;
    private javax.swing.JTextField tModeloAvion;
    private javax.swing.JTextField tNumPlazasAvion;
    // End of variables declaration//GEN-END:variables
}
