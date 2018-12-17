/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.usuario;

import capa.negocio.Archivo;
import capa.negocio.Dispositivo;
import capa.negocio.Red;
import capa.negocio.Subestacion;
import com.sun.prism.shader.FillEllipse_ImagePattern_AlphaTest_Loader;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Castillo
 */
public class frmDispositivo extends javax.swing.JFrame {

    String barra = File.separator;
    String directorio = System.getProperty("user.dir")+barra+"src"+barra+"capa"+barra+"datos"+barra+"propiedades"+barra;
    
        
    public frmDispositivo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void Crear(){
            String archivo = txtId.getText()+".properties";
            File crea_ubicacion = new File(directorio);
            File crea_archivo = new File(directorio+archivo);
            
            if (txtTipo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane,"No hay ID");
        }else{
                try {
                    if (crea_archivo.exists()) {
                    JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
                    }else{
                        crea_ubicacion.mkdirs();
                        Formatter crea = new Formatter(directorio+archivo);
                            crea.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s","Id="+txtId.getText(),"Tipo="+txtTipo.getText(),
                                    "Marca="+txtMarca.getText(),"Modelo="+txtModelo.getText(),"NombreDispositivo="+txtNombreDispositivo.getText(),
                                    "DireccionIP="+txtDireccionIP.getText(),"NombreArchivo="+txtNombreArchivo.getText()/*frmSubestacion.txtNombreSubestacion.getText()+"__"+frmSubestacion.txtCelda.getText()+"__"+frmSubestacion.txtNivelTension.getText()*/);
                        crea.close();
                        JOptionPane.showMessageDialog(rootPane, "Archivo creado");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane,"No se pudo crear");
                }
                
            }
        }
    
    private void Mostrar(){
        File url = new File(directorio+txtId.getText()+".properties");
        if (txtId.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Indique el ID para Mostrar");
        }else{
            if (url.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(url);
                    Properties mostrar = new Properties();
                    mostrar.load(fis);
                    txtTipo.setText(mostrar.getProperty("Tipo"));
                    txtMarca.setText(mostrar.getProperty("Marca"));
                    txtModelo.setText(mostrar.getProperty("Modelo"));
                    txtNombreDispositivo.setText(mostrar.getProperty("NombreDispositivo"));
                    txtDireccionIP.setText(mostrar.getProperty("DireccionIP"));
                    txtNombreArchivo.setText(mostrar.getProperty("NombreAchivo"));
                } catch (Exception e) {
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "El Registro no Existe");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDatosGenerales = new javax.swing.JPanel();
        jPanelDispositivo = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblNombreDispositivo = new javax.swing.JLabel();
        txtNombreDispositivo = new javax.swing.JTextField();
        lblDireccionIP = new javax.swing.JLabel();
        txtDireccionIP = new javax.swing.JTextField();
        lblNombreArchivo = new javax.swing.JLabel();
        txtNombreArchivo = new javax.swing.JTextField();
        btnAdicionarDispositivo = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnModificarDispositivo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanelTablaDispositivosRegistrados = new javax.swing.JPanel();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tblDispositivo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Dispositivos y Redes");

        jPanelDatosGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        jPanelDatosGenerales.setToolTipText("");
        jPanelDatosGenerales.setName(""); // NOI18N

        jPanelDispositivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dispositivos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelDispositivo.setToolTipText("Dispositivo");
        jPanelDispositivo.setName(""); // NOI18N

        lblID.setText("ID:");

        lblTipo.setText("Tipo:");

        lblMarca.setText("Marca:");

        lblModelo.setText("Modelo:");

        lblNombreDispositivo.setText("Nombre de Dispositivo:");

        lblDireccionIP.setText("Dirección IP:");

        txtDireccionIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionIPActionPerformed(evt);
            }
        });

        lblNombreArchivo.setText("Nombre de Archivo:");

        txtNombreArchivo.setEditable(false);

        btnAdicionarDispositivo.setText("Adicionar");
        btnAdicionarDispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDispositivoActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnModificarDispositivo.setText("Modificar");
        btnModificarDispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDispositivoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDispositivoLayout = new javax.swing.GroupLayout(jPanelDispositivo);
        jPanelDispositivo.setLayout(jPanelDispositivoLayout);
        jPanelDispositivoLayout.setHorizontalGroup(
            jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                        .addComponent(btnAdicionarDispositivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarDispositivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                        .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo)
                            .addComponent(lblModelo)
                            .addComponent(lblNombreDispositivo)
                            .addComponent(lblDireccionIP)
                            .addComponent(lblMarca)
                            .addComponent(lblNombreArchivo)
                            .addComponent(lblID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId)
                            .addComponent(txtNombreArchivo)
                            .addComponent(txtDireccionIP)
                            .addComponent(txtNombreDispositivo)
                            .addComponent(txtModelo)
                            .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanelDispositivoLayout.setVerticalGroup(
            jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDispositivo)
                    .addComponent(txtNombreDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionIP)
                    .addComponent(txtDireccionIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreArchivo))
                .addGap(18, 18, 18)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarDispositivo)
                    .addComponent(btnModificarDispositivo)
                    .addComponent(btnMostrar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        jPanelTablaDispositivosRegistrados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dispositivos Registrados"));

        tblDispositivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tipo", "Marca", "Modelo", "Dispositivo", "Dirección IP", "Archivo"
            }
        ));
        tblDispositivo.setColumnSelectionAllowed(true);
        jScrollPaneTabla.setViewportView(tblDispositivo);
        tblDispositivo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanelTablaDispositivosRegistradosLayout = new javax.swing.GroupLayout(jPanelTablaDispositivosRegistrados);
        jPanelTablaDispositivosRegistrados.setLayout(jPanelTablaDispositivosRegistradosLayout);
        jPanelTablaDispositivosRegistradosLayout.setHorizontalGroup(
            jPanelTablaDispositivosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelTablaDispositivosRegistradosLayout.setVerticalGroup(
            jPanelTablaDispositivosRegistradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaDispositivosRegistradosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelDatosGeneralesLayout = new javax.swing.GroupLayout(jPanelDatosGenerales);
        jPanelDatosGenerales.setLayout(jPanelDatosGeneralesLayout);
        jPanelDatosGeneralesLayout.setHorizontalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTablaDispositivosRegistrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDatosGeneralesLayout.setVerticalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                .addComponent(jPanelDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelTablaDispositivosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jPanelDispositivo.getAccessibleContext().setAccessibleName("Dispositivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDatosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelDatosGenerales.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("Gestion de Dispositivos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionIPActionPerformed

    private void btnAdicionarDispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDispositivoActionPerformed
        Crear();
    }//GEN-LAST:event_btnAdicionarDispositivoActionPerformed
    
    
    private void btnModificarDispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDispositivoActionPerformed
        //managerrpa.oPropiedades.setProperty("REPG00402", "REPG00363");
    }//GEN-LAST:event_btnModificarDispositivoActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        Mostrar();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmAdministrador ADM = new frmAdministrador();
        ADM.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDispositivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDispositivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDispositivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDispositivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDispositivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarDispositivo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificarDispositivo;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jPanelDatosGenerales;
    private javax.swing.JPanel jPanelDispositivo;
    private javax.swing.JPanel jPanelTablaDispositivosRegistrados;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JLabel lblDireccionIP;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombreArchivo;
    private javax.swing.JLabel lblNombreDispositivo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTable tblDispositivo;
    private javax.swing.JTextField txtDireccionIP;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombreArchivo;
    private javax.swing.JTextField txtNombreDispositivo;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
