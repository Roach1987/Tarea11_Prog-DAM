/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.dam.tarea11.ventanas.vuelo;

import javax.swing.JPanel;
import programacion.dam.tarea11.dao.UtilDAO;
import programacion.dam.tarea11.util.Util;

/**
 *
 * @author Roach_Mimi
 */
public class VentanaVueloCrear extends javax.swing.JPanel {

    /**
     * Creates new form VentanaVueloCrear
     */
    public VentanaVueloCrear() {
        initComponents();
    }

    public JPanel ventanaCrearVuelo(){
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tCodigoVuelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tCodigoAvion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tAerouertoOrigen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tAeropuertoDestino = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tFechaSalida = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tFechaLlegada = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        tFechaEscala = new javax.swing.JFormattedTextField();
        bCrear = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("CREAR");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Codigo Vuelo:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setText("Codigo Avi�n:");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setText("Aeropuerto Origen:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setText("Aeropuerto Destino:");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("Fecha Salida: ");

        try {
            tFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setText("Fecha Llegada:");

        try {
            tFechaLlegada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setText("Fecha Escala:");
        jLabel8.setToolTipText("Campo Opcional");

        try {
            tFechaEscala.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tFechaEscala.setToolTipText("Campo Opcional");

        bCrear.setBackground(new java.awt.Color(204, 204, 0));
        bCrear.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        bCrear.setText("Crear");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tCodigoVuelo)
                            .addComponent(tCodigoAvion)
                            .addComponent(tAerouertoOrigen)
                            .addComponent(tAeropuertoDestino)
                            .addComponent(tFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(tFechaLlegada)
                            .addComponent(tFechaEscala)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(bCrear)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tCodigoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tCodigoAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tAerouertoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tAeropuertoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tFechaEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(bCrear)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acci�n crear nuevo vuelo
     * @param evt 
     */
    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        if(validarFormulario()){
            String fechaEscala = (null != tFechaEscala.getText().trim()) ? tFechaEscala.getText().trim() 
                    : null;
            String mensaje = UtilDAO.crearNuevoVuelo(tCodigoVuelo.getText().trim(), tCodigoAvion.getText().trim(),
                    tAerouertoOrigen.getText().trim(), tAeropuertoDestino.getText().trim(),
                    tFechaSalida.getText().trim(), tFechaLlegada.getText().trim(), fechaEscala);
        
            if(mensaje.equals(Util.OK)){
                 Util.mostrarMensaje(this, "Vuelo creado correctamente.", Util.INFORMACION);
            }
        }
    }//GEN-LAST:event_bCrearActionPerformed

   /**
     * M�todo que realiza las validaciones del formulario de consulta de vuelos
     * @return boolean
     */
    private boolean validarFormulario(){
        if(tCodigoVuelo.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Codigo vuelo no puede estar vacio", Util.INFORMACION);
            return false;
        }
        
        if(tCodigoAvion.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Codigo Avi�n no puede estar vacio", Util.INFORMACION);
            return false;
        }
        
        if(tAerouertoOrigen.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Aeropuerto Origen no puede estar vacio", Util.INFORMACION);
            return false;
        }
        
        if(tAeropuertoDestino.getText().equals("")){
            Util.mostrarMensaje(this, "El campo Aeropuerto Destino no puede estar vacio", Util.INFORMACION);
            return false;
        }
        
        if(tAerouertoOrigen.getText().equalsIgnoreCase(tAeropuertoDestino.getText())){
            Util.mostrarMensaje(this, "Los campos de Aeropuerto Origen y Aeropuerto Destino no pueden ser iguales.", Util.INFORMACION);
            return false;
        }
        
// ******************************* Validaci�n fechas. **************************

        if(tFechaSalida.getText().equals("  /  /       :  :  ")){
            Util.mostrarMensaje(this, "El campo Fecha Salida no puede estar vacio", Util.INFORMACION);
            return false;
        }else if(!Util.validarFecha(tFechaSalida.getText().trim())){
            Util.mostrarMensaje(this, "La fecha de salida no es valida.", Util.INFORMACION);
            return false;
        }
        
        if(tFechaLlegada.getText().equals("  /  /       :  :  ")){
            Util.mostrarMensaje(this, "El campo Fecha Salida no puede estar vacio", Util.INFORMACION);
            return false;
        }else if(!Util.validarFecha(tFechaLlegada.getText().trim())){
            Util.mostrarMensaje(this, "La fecha de llegada no es valida.", Util.INFORMACION);
            return false;
        }
        
        // Validamos que la fecha de salida sea menor que la fecha de llegada.
        String mensajeSalida = Util.compararFechas(tFechaSalida.getText().trim(), tFechaLlegada.getText().trim(),
                null, Util.OPERACION_FECHA_SIN_ESCALA);
        if(!mensajeSalida.equals(Util.OK)){
            Util.mostrarMensaje(this, mensajeSalida, Util.INFORMACION);
            return false;
        }
        
        // Si existe fecha de escala validamos que no sea menor que la fecha de salida
        // y que no sea mayor que la fecha de llegada.
        if(tFechaSalida.getText().equals("  /  /       :  :  ")){
            System.out.println("No tiene fecha de escala");
        }else{
            if(!Util.validarFecha(tFechaEscala.getText().trim())){
                Util.mostrarMensaje(this, "La fecha de escala no es valida.", Util.INFORMACION);
                return false;
            }else{
                String mensajeEscala = Util.compararFechas(tFechaSalida.getText().trim(), tFechaLlegada.getText().trim(),
                    tFechaEscala.getText().trim(), Util.OPERACION_FECHA_ESCALA);
                if(!mensajeEscala.equals(Util.OK)){
                    Util.mostrarMensaje(this, mensajeEscala, Util.INFORMACION);
                    return false;
                }
            }
        }
       return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tAeropuertoDestino;
    private javax.swing.JTextField tAerouertoOrigen;
    private javax.swing.JTextField tCodigoAvion;
    private javax.swing.JTextField tCodigoVuelo;
    private javax.swing.JFormattedTextField tFechaEscala;
    private javax.swing.JFormattedTextField tFechaLlegada;
    private javax.swing.JFormattedTextField tFechaSalida;
    // End of variables declaration//GEN-END:variables
}