
package capa.usuario;


import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class frmDispositivo extends javax.swing.JFrame {

    String barra = File.separator;
    String directorio = System.getProperty("user.dir")+barra+"src"+barra+"capa"+barra+"datos"+barra+"propiedades"+barra+"dispositivos"+barra;
    String directorio1 = System.getProperty("user.dir")+barra+"src"+barra+"capa"+barra+"datos"+barra;
    File contenedor = new File(directorio);
    File contenedor1 = new File(directorio1);
    File [] registros = contenedor.listFiles();
    File [] registros1 = contenedor1.listFiles();
    String [] titulo = {"Nombre", "Tipo", "Marca", "Modelo", "Numero Serie", "IP", "Nombre Archivo"};
    DefaultTableModel dtm = new DefaultTableModel(null, titulo);
    DefaultComboBoxModel modeloMarca, modeloModelo;
    
    private  void  RegTable(){
        for (int i = 0; i < registros.length; i++) {
            File url = new File(directorio+registros[i].getName());
            try {
                FileInputStream fis = new FileInputStream(url);
                Properties mostrar = new Properties();
                mostrar.load(fis);
                String filas [] = {registros[i].getName().replace(".properties", ""),
                mostrar.getProperty("Tipo"), mostrar.getProperty("Marca"), mostrar.getProperty("Modelo"),
                mostrar.getProperty("NumeroSerie"), mostrar.getProperty("IpDispositivo"), mostrar.getProperty("NombreArchivo")};
                dtm.addRow(filas);
            } catch (Exception e) {
            }
        }
        tblDispositivo.setModel(dtm);
    }
    
    public void verComboTipo(){
        Properties oTipo = new Properties();
        InputStream esArchivo;
        try {
            esArchivo = new FileInputStream(directorio1+"TipoDispositivo.properties");
            oTipo.load(esArchivo);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        for (Enumeration elementos = oTipo.keys(); elementos.hasMoreElements(); ) {
            Object itemString = elementos.nextElement();
            cbxTipo.addItem(oTipo.getProperty(itemString.toString()));
        }
     }
    
    
    /*private void verComboMarca(){
        try {
            String marcas[] = new String[3];
            File archivo = new File(directorio1+"MarcaOrdenadores.properties");
            FileReader leer = new FileReader(archivo);
            BufferedReader br = new BufferedReader(leer);
            for (int i = 0; i < archivo.length(); ) {
                marcas[i]= br.readLine();
            }
            modeloMarca = new DefaultComboBoxModel(marcas);
            cbxMarca.setModel(modeloMarca);
            br.close();
        } catch (IOException e) {
        }
    
            
    }*/
    
    
    
    public frmDispositivo() {
        initComponents();
        this.setLocationRelativeTo(null);
        verComboTipo();
        //verComboMarca();
        RegTable();
    }
    
    private  void ActualizarTabla(){
        registros = contenedor.listFiles();
        dtm.setRowCount(0);
        RegTable();
    }
    
    private void Crear(){
        String archivo = txtNombreDispositivo.getText()+".properties";
            File crea_ubicacion = new File(directorio);
            File crea_archivo = new File(directorio+archivo);
            
            if (cbxTipo.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(rootPane,"No hay ID");
        }else{
                try {
                    if (crea_archivo.exists()) {
                    JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
                    }else{
                        crea_ubicacion.mkdirs();
                        Formatter crea = new Formatter(directorio+archivo);
                            crea.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s","NombreDispositivo="+txtNombreDispositivo.getText(),"Tipo="+cbxTipo.getSelectedItem(),
                                    "Marca="+cbxMarca.getSelectedItem(),"Modelo="+cbxModelo.getSelectedItem(),"NumeroSerie="+txtNumeroSerie.getText(),
                                    "IpDispositivo="+txtIpDispositivo.getText(),"NombreArchivo="+txtNombreArchivo.getText());
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
        File url = new File(directorio+txtNombreDispositivo.getText()+".properties");
        if (txtNombreDispositivo.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Indique el ID para Mostrar");
        }else{
            if (url.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(url);
                    Properties mostrar = new Properties();
                    mostrar.load(fis);
                    cbxTipo.setSelectedItem(mostrar.getProperty("Tipo"));
                    cbxMarca.setSelectedItem(mostrar.getProperty("Marca"));
                    cbxModelo.setSelectedItem(mostrar.getProperty("Modelo"));
                    txtNumeroSerie.setText(mostrar.getProperty("NumeroSerie"));
                    txtIpDispositivo.setText(mostrar.getProperty("IpDispositivo"));
                    txtNombreArchivo.setText(mostrar.getProperty("NombreAchivo"));
                } catch (Exception e) {
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "El Registro no Existe");
            }
        }
    }
    
    private void Modificar(){
        File url = new File(directorio+txtNombreDispositivo.getText()+".properties");
        if (txtNombreDispositivo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Nombre de Registro a Modificar");
        }else{
            if (url.exists()) {
                try {
                    FileWriter editar = new FileWriter(directorio+txtNombreDispositivo.getText()+".properties");
                    String Nombre = "Nombre=";
                    String Tipo = "Tipo=";
                    String Marca = "Marca=";
                    String Modelo = "Modelo";
                    String Serie = "NumeroSerie=";
                    String IpDispositivo = "IpDispositivo=";
                    String Archivo= "NombreArchivo=";
                    
                    PrintWriter guardar = new PrintWriter(editar);
                    guardar.println(Nombre+txtNombreDispositivo.getText());
                    guardar.println(Tipo+cbxTipo.getSelectedItem());
                    guardar.println(Marca+cbxMarca.getSelectedItem());
                    guardar.println(Modelo+cbxModelo.getSelectedItem());
                    guardar.println(Serie+txtNumeroSerie.getText());
                    guardar.println(IpDispositivo+txtIpDispositivo.getText());
                    guardar.println(Archivo+txtNombreArchivo.getText());
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
        File url = new File(directorio+txtNombreDispositivo.getText()+".properties");
        String btns [] = {"Eliminar", "Cancelar"};
        if (txtNombreDispositivo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese el registro a eliminar");
        }else{
            if (url.exists()) {
                try {
                    FileInputStream cerrar = new FileInputStream(url);
                    cerrar.close();
                    System.gc();
                    int confirmar = JOptionPane.showOptionDialog(rootPane, "¿Eliminar el registro?... "+txtNombreDispositivo.getText(), "Eliminar", 0, 0, null, btns, null);
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
        jPanelDispositivo = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtNombreDispositivo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblNombreDispositivo = new javax.swing.JLabel();
        txtNumeroSerie = new javax.swing.JTextField();
        lblDireccionIP = new javax.swing.JLabel();
        txtIpDispositivo = new javax.swing.JTextField();
        lblNombreArchivo = new javax.swing.JLabel();
        txtNombreArchivo = new javax.swing.JTextField();
        btnAdicionarDispositivo = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnModificarDispositivo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxMarca = new javax.swing.JComboBox<>();
        cbxModelo = new javax.swing.JComboBox<>();
        jPanelTablaDispositivosRegistrados = new javax.swing.JPanel();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tblDispositivo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Dispositivos y Red");

        jPanelDatosGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        jPanelDatosGenerales.setToolTipText("");
        jPanelDatosGenerales.setName(""); // NOI18N

        jPanelDispositivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dispositivos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelDispositivo.setToolTipText("Dispositivo");
        jPanelDispositivo.setName(""); // NOI18N

        lblID.setText("Nombre de Dispositivo:");

        txtNombreDispositivo.setText("Ejemplo: REPG00000; CL-0000");

        lblTipo.setText("Tipo:");

        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        lblMarca.setText("Marca:");

        lblModelo.setText("Modelo:");

        lblNombreDispositivo.setText("Número de Serie:");

        lblDireccionIP.setText("Dirección IP:");

        txtIpDispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIpDispositivoActionPerformed(evt);
            }
        });

        lblNombreArchivo.setText("Nombre de Archivo:");

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

        cbxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarcaActionPerformed(evt);
            }
        });

        cbxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxModeloActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarDispositivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                        .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo)
                            .addComponent(lblNombreDispositivo)
                            .addComponent(lblDireccionIP)
                            .addComponent(lblNombreArchivo)
                            .addComponent(lblID)
                            .addComponent(lblModelo)
                            .addComponent(lblMarca))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMarca, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreDispositivo)
                            .addComponent(txtNombreArchivo)
                            .addComponent(txtIpDispositivo)
                            .addComponent(txtNumeroSerie)
                            .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelDispositivoLayout.setVerticalGroup(
            jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblNombreDispositivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIpDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblDireccionIP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblNombreArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                {},
                {},
                {},
                {}
            },
            new String [] {

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaDispositivosRegistradosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDatosGenerales.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("Gestion de Dispositivos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIpDispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIpDispositivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIpDispositivoActionPerformed

    private void btnAdicionarDispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDispositivoActionPerformed
        Crear();
    }//GEN-LAST:event_btnAdicionarDispositivoActionPerformed
    
    
    private void btnModificarDispositivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDispositivoActionPerformed
        Modificar();
    }//GEN-LAST:event_btnModificarDispositivoActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        Mostrar();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmAdministrador ADM = new frmAdministrador();
        ADM.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        if(cbxTipo.getSelectedItem().equals("Medidor")){
            txtNombreArchivo.setVisible(true);
            lblNombreArchivo.setVisible(true);
        }else{
            if(cbxTipo.getSelectedItem().equals("Ordenador")){
                txtNombreArchivo.setVisible(false);
                lblNombreArchivo.setVisible(false);
            }
        }
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarcaActionPerformed
        //verComboMarca();
    }//GEN-LAST:event_cbxMarcaActionPerformed

    private void cbxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxModeloActionPerformed

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
         if(evt.getStateChange() == ItemEvent.SELECTED)
       {
           if(this.cbxTipo.getSelectedIndex()>0)
           {
               this.cbxMarca.setModel(modeloMarca);
           }
       }
    }//GEN-LAST:event_cbxTipoItemStateChanged

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
    private javax.swing.JComboBox<String> cbxMarca;
    private javax.swing.JComboBox<String> cbxModelo;
    private javax.swing.JComboBox<String> cbxTipo;
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
    private javax.swing.JTextField txtIpDispositivo;
    private javax.swing.JTextField txtNombreArchivo;
    private javax.swing.JTextField txtNombreDispositivo;
    private javax.swing.JTextField txtNumeroSerie;
    // End of variables declaration//GEN-END:variables
}
