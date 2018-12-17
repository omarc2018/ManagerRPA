/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Castillo
 */
public class frmSubestacion extends javax.swing.JFrame {

    String barra = File.separator;
    String directorio = System.getProperty("user.dir")+barra+"src"+barra+"capa"+barra+"datos"+barra+"propiedades"+barra;
    
    public frmSubestacion() {
        initComponents();
    }

    private void Crear(){
            String archivo = txtId.getText()+".properties";
            File crea_ubicacion = new File(directorio);
            File crea_archivo = new File(directorio+archivo);
            
            if (txtNombreSubestacion.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane,"No hay ID");
        }else{
                try {
                    if (crea_archivo.exists()) {
                    JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
                    }else{
                        crea_ubicacion.mkdirs();
                        Formatter crea = new Formatter(directorio+archivo);
                            crea.format("%s\r\n%s\r\n%s\r\n%s","Id="+txtId.getText(),"Nombre="+txtNombreSubestacion.getText(),
                                    "NivelTension="+txtNivelTension.getText(),"Celda="+txtCelda.getText());
                        crea.close();
                        JOptionPane.showMessageDialog(rootPane, "Archivo creado correctamente");
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
                    txtNombreSubestacion.setText(mostrar.getProperty("Nombre"));
                    txtNivelTension.setText(mostrar.getProperty("NivelTension"));
                    txtCelda.setText(mostrar.getProperty("Celda"));
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
                    String NivelTension = "NivelTension=";
                    String Celda = "Celda=";
                    
                    PrintWriter guardar = new PrintWriter(editar);
                    guardar.println(Id+txtId.getText());
                    guardar.println(Nombre+txtNombreSubestacion.getText());
                    guardar.println(NivelTension+txtNivelTension.getText());
                    guardar.print(Celda+txtCelda.getText());
                    editar.close();
                    JOptionPane.showMessageDialog(rootPane, "Modificación de datos Correcta");
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
        jPanelSubestacion = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombreSubestacion = new javax.swing.JLabel();
        txtNombreSubestacion = new javax.swing.JTextField();
        lblNivelTension = new javax.swing.JLabel();
        txtNivelTension = new javax.swing.JTextField();
        lblNivelTension1 = new javax.swing.JLabel();
        lblCelda = new javax.swing.JLabel();
        txtCelda = new javax.swing.JTextField();
        btnAdicionarSubestacion = new javax.swing.JButton();
        btnModificarSubestacion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jPanelTablaSubestacionesRegistradas = new javax.swing.JPanel();
        jScrollPaneTabla1 = new javax.swing.JScrollPane();
        tblDispositivo1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelDatosGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        jPanelDatosGenerales.setToolTipText("");

        jPanelSubestacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subestación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblID.setText("ID:");

        lblNombreSubestacion.setText("Nombre de Subestación:");

        lblNivelTension.setText("Nivel de Tensión:");

        lblNivelTension1.setText("kV");

        lblCelda.setText("Celda:");

        btnAdicionarSubestacion.setText("Adicionar");
        btnAdicionarSubestacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarSubestacionActionPerformed(evt);
            }
        });

        btnModificarSubestacion.setText("Modificar");
        btnModificarSubestacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarSubestacionActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSubestacionLayout = new javax.swing.GroupLayout(jPanelSubestacion);
        jPanelSubestacion.setLayout(jPanelSubestacionLayout);
        jPanelSubestacionLayout.setHorizontalGroup(
            jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                        .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                                .addComponent(lblID)
                                .addGap(124, 124, 124))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSubestacionLayout.createSequentialGroup()
                                .addComponent(lblNombreSubestacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreSubestacion)
                            .addComponent(txtId)))
                    .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                        .addComponent(btnAdicionarSubestacion)
                        .addGap(3, 3, 3)
                        .addComponent(btnMostrar)
                        .addGap(4, 4, 4)
                        .addComponent(btnModificarSubestacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                        .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNivelTension)
                            .addComponent(lblCelda))
                        .addGap(54, 54, 54)
                        .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                                .addComponent(txtNivelTension, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(lblNivelTension1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCelda))))
                .addContainerGap())
        );
        jPanelSubestacionLayout.setVerticalGroup(
            jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreSubestacion)
                    .addComponent(txtNombreSubestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNivelTension1)
                        .addComponent(txtNivelTension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNivelTension, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCelda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCelda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarSubestacion)
                    .addComponent(btnModificarSubestacion)
                    .addComponent(btnCancelar)
                    .addComponent(btnMostrar)
                    .addComponent(btnEliminar))
                .addGap(6, 6, 6))
        );

        jPanelTablaSubestacionesRegistradas.setBorder(javax.swing.BorderFactory.createTitledBorder("Subestaciones Registradas"));

        tblDispositivo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Subestación", "Tensión kV", "Celda"
            }
        ));
        tblDispositivo1.setColumnSelectionAllowed(true);
        jScrollPaneTabla1.setViewportView(tblDispositivo1);
        tblDispositivo1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanelTablaSubestacionesRegistradasLayout = new javax.swing.GroupLayout(jPanelTablaSubestacionesRegistradas);
        jPanelTablaSubestacionesRegistradas.setLayout(jPanelTablaSubestacionesRegistradasLayout);
        jPanelTablaSubestacionesRegistradasLayout.setHorizontalGroup(
            jPanelTablaSubestacionesRegistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelTablaSubestacionesRegistradasLayout.setVerticalGroup(
            jPanelTablaSubestacionesRegistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaSubestacionesRegistradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDatosGeneralesLayout = new javax.swing.GroupLayout(jPanelDatosGenerales);
        jPanelDatosGenerales.setLayout(jPanelDatosGeneralesLayout);
        jPanelDatosGeneralesLayout.setHorizontalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTablaSubestacionesRegistradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(jPanelSubestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDatosGeneralesLayout.setVerticalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSubestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTablaSubestacionesRegistradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmAdministrador ADM = new frmAdministrador();
        ADM.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarSubestacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarSubestacionActionPerformed
        Crear();;
    }//GEN-LAST:event_btnAdicionarSubestacionActionPerformed

    private void btnModificarSubestacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarSubestacionActionPerformed
        Modificar();
    }//GEN-LAST:event_btnModificarSubestacionActionPerformed

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
            java.util.logging.Logger.getLogger(frmSubestacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSubestacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSubestacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSubestacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSubestacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarSubestacion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificarSubestacion;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jPanelDatosGenerales;
    private javax.swing.JPanel jPanelSubestacion;
    private javax.swing.JPanel jPanelTablaSubestacionesRegistradas;
    private javax.swing.JScrollPane jScrollPaneTabla1;
    private javax.swing.JLabel lblCelda;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNivelTension;
    private javax.swing.JLabel lblNivelTension1;
    private javax.swing.JLabel lblNombreSubestacion;
    private javax.swing.JTable tblDispositivo1;
    private javax.swing.JTextField txtCelda;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNivelTension;
    private javax.swing.JTextField txtNombreSubestacion;
    // End of variables declaration//GEN-END:variables
}
