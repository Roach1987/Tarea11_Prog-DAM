package programacion.dam.tarea11.ventanas.avion;

import javax.swing.JPanel;
import programacion.dam.tarea11.beans.Avion;
import programacion.dam.tarea11.dao.AvionDAO;
import programacion.dam.tarea11.dao.UtilDAO;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach
 */
public class VentanaAvionMix extends javax.swing.JPanel {

    // Atributos.
    private String distintivo;
    
    /**
     * Creates new form VentanaAvionMix
     */
    public VentanaAvionMix() {
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

        lTitulo = new javax.swing.JLabel();
        tCodigoAvion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bVarios = new javax.swing.JButton();

        lTitulo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lTitulo.setText("VARIOS");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Codigo Avion:");

        bVarios.setBackground(new java.awt.Color(204, 204, 0));
        bVarios.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        bVarios.setText("Varios");
        bVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(lTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bVarios)
                    .addComponent(tCodigoAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lTitulo)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCodigoAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(bVarios)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public JPanel ventanaMix(String distintivo) {    
        this.distintivo = distintivo;
        
        if(distintivo.equals(Util.DISTINTIVO_BORRAR)){
            lTitulo.setText("BORRAR AVION");
            tCodigoAvion.setText("");
            bVarios.setText(Util.DISTINTIVO_BORRAR);
        }else{
            lTitulo.setText("CONSULTAR AVION");
            tCodigoAvion.setText("");
            bVarios.setText(Util.DISTINTIVO_CONSULTAR);
        }
        return this;
    }
        
    /**
     * Acci�n que realiza el boton varios, estas pueden ser Borrar o Buscar
     * @param evt 
     */
    private void bVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVariosActionPerformed
        // Borrar 
        if(distintivo.equals(Util.DISTINTIVO_BORRAR)){
            if(validarFormulario()){
                String mensaje = UtilDAO.borrarAvion(tCodigoAvion.getText());
                Util.mostrarMensaje(null, mensaje, Util.INFORMACION);
            }           
        }else{
            if(validarFormulario()){   
                Avion avion = AvionDAO.buscarAvionPorCodigo(tCodigoAvion.getText());
                if(null != avion){
                    Util.mostrarMensaje(null, "Datos recuperados del avi�n: ".concat("\n\t")
                            .concat("Codigo: ").concat(avion.getCodigo()).concat("\n\t")
                            .concat("Modelo: ").concat(avion.getModelo()).concat("\n\t")
                            .concat("Numero de plazas: ").concat(String.valueOf(avion.getNumeroPlazas())),
                            Util.INFORMACION);
                }else{
                    Util.mostrarMensaje(null, "No existe ningun avi�n con codigo ".concat(tCodigoAvion.getText()),
                            Util.INFORMACION);
                }
            }
        }
        tCodigoAvion.setText("");
    }//GEN-LAST:event_bVariosActionPerformed

// ***************************************************************************************************
// ************************************ Utilidades de la Clase ***************************************
// ***************************************************************************************************
    
    /**
     * M�todo que realiza las validaciones del formulario de borrado o consulta de aviones
     * @return boolean
     */
    private boolean validarFormulario(){
        // Codigo avi�n
        if(tCodigoAvion.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Codigo no puede estar vacio", Util.INFORMACION);
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bVarios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JTextField tCodigoAvion;
    // End of variables declaration//GEN-END:variables
}