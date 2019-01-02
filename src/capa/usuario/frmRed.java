/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.usuario;

import com.sun.org.apache.xerces.internal.impl.dtd.models.ContentModelValidator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Castillo
 */
public class frmRed extends javax.swing.JFrame {

    String barra = File.separator;
    String directorio = System.getProperty("user.dir")+barra+"src"+barra+"capa"+barra+"datos"+barra+"propiedades"+barra+"redes"+barra;
    
    File contenedor = new File(directorio);
    File [] registros = contenedor.listFiles();
    String [] titulo = {"Id", "Nombre", "IP Local", "IP Destino"};
    DefaultTableModel dtm = new DefaultTableModel(null, titulo);
    
    private  void  RegTable(){
        for (int i = 0; i < registros.length; i++) {
            File url = new File(directorio+registros[i].getName());
            try {
                FileInputStream fis = new FileInputStream(url);
                Properties mostrar = new Properties();
                mostrar.load(fis);
                String filas [] = {registros[i].getName().replace(".properties", ""),
                mostrar.getProperty("Nombre"), mostrar.getProperty("IpPuertaEnlace"), mostrar.getProperty("IpDestino")};
                dtm.addRow(filas);
            } catch (Exception e) {
            }
        }
        tblRed.setModel(dtm);
    }
    
    
    public frmRed() {
        initComponents();
        RegTable();
    }
    
    private  void ActualizarTabla(){
        registros = contenedor.listFiles();
        dtm.setRowCount(0);
        RegTable();
    }

    private void Crear(){
            String archivo = txtId.getText()+".properties";
            File crea_ubicacion = new File(directorio);
            File crea_archivo = new File(directorio+archivo);
            
            if (txtNombreRed.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane,"No hay ID");
        }else{
                try {
                    if (crea_archivo.exists()) {
                    JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
                    }else{
                        crea_ubicacion.mkdirs();
                        Formatter crea = new Formatter(directorio+archivo);
                            crea.format("%s\r\n%s\r\n%s\r\n%s","Id="+txtId.getText(),"Nombre="+txtNombreRed.getText(),
                                    "IpPuertaEnlace="+txtIpPuertaEnlace.getText(),"IpDestino="+txtIpDestino.getText());
                        crea.close();
                        JOptionPane.showMessageDialog(rootPane, "Archivo creado correctamente");
                        ActualizarTabla();
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
                    txtNombreRed.setText(mostrar.getProperty("Nombre"));
                    txtIpPuertaEnlace.setText(mostrar.getProperty("IpPuertaEnlace"));
                    txtIpDestino.setText(mostrar.getProperty("IpDestino"));
                } catch (Exception e) {
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "El Registro no Existe");
            }
        }
    }
    
    private void Modificar(){
        File url = new File(directorio+txtId.getText()+".properties");
        if (txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Nombre de Registro a Modificar");
        }else{
            if (url.exists()) {
                try {
                    FileWriter editar = new FileWriter(directorio+txtId.getText()+".properties");
                    String Id = "Id=";
                    String Nombre = "Nombre=";
                    String PuertaEnlace = "IpPuertaEnlace=";
                    String DireccionDestino= "IpDestino=";
                    
                    PrintWriter guardar = new PrintWriter(editar);
                    guardar.println(Id+txtId.getText());
                    guardar.println(Nombre+txtNombreRed.getText());
                    guardar.println(PuertaEnlace+txtIpPuertaEnlace.getText());
                    guardar.println(DireccionDestino+txtIpDestino.getText());
                    editar.close();
                    JOptionPane.showMessageDialog(rootPane, "Modificación de datos Correcta");
                    ActualizarTabla();
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(rootPane,"Error"+ e);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "El Registro No existe");
            }
        }
    }
    
    private void Eliminar(){
        File url = new File(directorio+txtId.getText()+".properties");
        String btns [] = {"Eliminar", "Cancelar"};
        if (txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese el registro a eliminar");
        }else{
            if (url.exists()) {
                try {
                    FileInputStream cerrar = new FileInputStream(url);
                    cerrar.close();
                    System.gc();
                    int confirmar = JOptionPane.showOptionDialog(rootPane, "¿Eliminar el registro?... "+txtId.getText(), "Eliminar", 0, 0, null, btns, null);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        url.delete();
                        JOptionPane.showMessageDialog(rootPane, "¡Registro eliminado permanentemente!");
                        ActualizarTabla();
                    }
                    if (confirmar == JOptionPane.YES_OPTION) {
                        
                    }
                } catch (Exception e) {
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDatosGenerales = new javax.swing.JPanel();
        jPanelRed = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombreRed = new javax.swing.JLabel();
        txtNombreRed = new javax.swing.JTextField();
        lblPuertaEnlace = new javax.swing.JLabel();
        txtIpPuertaEnlace = new javax.swing.JTextField();
        lblDireccionDestino = new javax.swing.JLabel();
        txtIpDestino = new javax.swing.JTextField();
        btnAdicionarSubestacion1 = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnModificarSubestacion1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanelTablaRedesRegistradas = new javax.swing.JPanel();
        jScrollPaneTabla2 = new javax.swing.JScrollPane();
        tblRed = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelDatosGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jPanelRed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros de Red", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblID.setText("ID:");

        lblNombreRed.setText("Nombre de Red:");

        lblPuertaEnlace.setText("Puerta de Enlace:");

        lblDireccionDestino.setText("Dirección IP Destino:");

        btnAdicionarSubestacion1.setText("Adicionar");
        btnAdicionarSubestacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarSubestacion1ActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnModificarSubestacion1.setText("Modificar");
        btnModificarSubestacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarSubestacion1ActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRedLayout = new javax.swing.GroupLayout(jPanelRed);
        jPanelRed.setLayout(jPanelRedLayout);
        jPanelRedLayout.setHorizontalGroup(
            jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRedLayout.createSequentialGroup()
                        .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccionDestino)
                            .addComponent(lblPuertaEnlace)
                            .addComponent(lblNombreRed)
                            .addComponent(lblID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombreRed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txtIpPuertaEnlace, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIpDestino)
                            .addComponent(txtId)))
                    .addGroup(jPanelRedLayout.createSequentialGroup()
                        .addComponent(btnAdicionarSubestacion1)
                        .addGap(6, 6, 6)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarSubestacion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRedLayout.setVerticalGroup(
            jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreRed)
                    .addComponent(txtNombreRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuertaEnlace)
                    .addComponent(txtIpPuertaEnlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionDestino)
                    .addComponent(txtIpDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarSubestacion1)
                    .addComponent(btnModificarSubestacion1)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar)
                    .addComponent(btnMostrar))
                .addContainerGap())
        );

        jPanelTablaRedesRegistradas.setBorder(javax.swing.BorderFactory.createTitledBorder("Redes Registradas"));

        tblRed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblRed.setColumnSelectionAllowed(true);
        jScrollPaneTabla2.setViewportView(tblRed);
        tblRed.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanelTablaRedesRegistradasLayout = new javax.swing.GroupLayout(jPanelTablaRedesRegistradas);
        jPanelTablaRedesRegistradas.setLayout(jPanelTablaRedesRegistradasLayout);
        jPanelTablaRedesRegistradasLayout.setHorizontalGroup(
            jPanelTablaRedesRegistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelTablaRedesRegistradasLayout.setVerticalGroup(
            jPanelTablaRedesRegistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaRedesRegistradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabla2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDatosGeneralesLayout = new javax.swing.GroupLayout(jPanelDatosGenerales);
        jPanelDatosGenerales.setLayout(jPanelDatosGeneralesLayout);
        jPanelDatosGeneralesLayout.setHorizontalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelTablaRedesRegistradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanelDatosGeneralesLayout.setVerticalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelTablaRedesRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarSubestacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarSubestacion1ActionPerformed
        Modificar();
    }//GEN-LAST:event_btnModificarSubestacion1ActionPerformed

    private void btnAdicionarSubestacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarSubestacion1ActionPerformed
        Crear();
    }//GEN-LAST:event_btnAdicionarSubestacion1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmAdministrador ADM = new frmAdministrador();
        ADM.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        Mostrar();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frmRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarSubestacion1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificarSubestacion1;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jPanelDatosGenerales;
    private javax.swing.JPanel jPanelRed;
    private javax.swing.JPanel jPanelTablaRedesRegistradas;
    private javax.swing.JScrollPane jScrollPaneTabla2;
    private javax.swing.JLabel lblDireccionDestino;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombreRed;
    private javax.swing.JLabel lblPuertaEnlace;
    private javax.swing.JTable tblRed;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIpDestino;
    private javax.swing.JTextField txtIpPuertaEnlace;
    private javax.swing.JTextField txtNombreRed;
    // End of variables declaration//GEN-END:variables
}
