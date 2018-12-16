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
public class frmGestionarDispositivos extends javax.swing.JFrame {

    String barra = File.separator;
    String directorio = System.getProperty("user.dir")+barra+"src"+barra+"capa"+barra+"datos"+barra;
    
    
    public frmGestionarDispositivos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void Crear(){
            String archivo = txtTipo.getText()+".properties";
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
                            crea.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s","Tipo="+txtTipo.getText(),
                                    "Marca="+txtMarca.getText(),"Modelo="+txtModelo.getText(),"NombreDispositivo="+txtNombreDispositivo.getText(),
                                    "DireccionIP="+txtDireccionIP.getText(),"NombreArchivo="+txtNombreArchivo.getText());
                        crea.close();
                        JOptionPane.showMessageDialog(rootPane, "Archivo crado");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane,"No se pudo crear");
                }
                
            }
        }
    
    private  void Mostrar(){
        File url new File(directorio+txtTipo.getText()+".properties");
        if (txtTipo.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Indique el ID para Mostrar");
        }else{
            if (url.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(url);
                    Properties mostrar = new Properties();
                    mostrar.load(fis);
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
        btnCancelar = new javax.swing.JButton();
        jPanelDispositivo = new javax.swing.JPanel();
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
        btnAdicionarDispositivo = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnModificarDispositivo = new javax.swing.JButton();
        lblNombreArchivo = new javax.swing.JLabel();
        txtNombreArchivo = new javax.swing.JTextField();
        jPanelSubestacion = new javax.swing.JPanel();
        lblNombreSubestacion = new javax.swing.JLabel();
        txtNombreSubestacion = new javax.swing.JTextField();
        lblNivelTension = new javax.swing.JLabel();
        txtNivelTension = new javax.swing.JTextField();
        lblCelda = new javax.swing.JLabel();
        txtCelda = new javax.swing.JTextField();
        btnAdicionarSubestacion = new javax.swing.JButton();
        btnModificarSubestacion = new javax.swing.JButton();
        lblNivelTension1 = new javax.swing.JLabel();
        jPanelRed = new javax.swing.JPanel();
        lblNombreRed = new javax.swing.JLabel();
        txtNombreRed = new javax.swing.JTextField();
        lblPuertaEnlace = new javax.swing.JLabel();
        txtPuertaEnlace = new javax.swing.JTextField();
        lblDireccionDestino = new javax.swing.JLabel();
        txtDireccionDestino = new javax.swing.JTextField();
        btnModificarSubestacion1 = new javax.swing.JButton();
        btnAdicionarSubestacion1 = new javax.swing.JButton();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tblDispositivo = new javax.swing.JTable();
        jPanelTabla1 = new javax.swing.JPanel();
        jScrollPaneTabla1 = new javax.swing.JScrollPane();
        tblDispositivo1 = new javax.swing.JTable();
        jPanelTabla2 = new javax.swing.JPanel();
        jScrollPaneTabla2 = new javax.swing.JScrollPane();
        tblDispositivo2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Dispositivos y Redes");

        jPanelDatosGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        jPanelDatosGenerales.setToolTipText("");
        jPanelDatosGenerales.setName(""); // NOI18N

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanelDispositivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dispositivos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelDispositivo.setToolTipText("Dispositivo");
        jPanelDispositivo.setName(""); // NOI18N

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

        lblNombreArchivo.setText("Nombre de Archivo:");

        javax.swing.GroupLayout jPanelDispositivoLayout = new javax.swing.GroupLayout(jPanelDispositivo);
        jPanelDispositivo.setLayout(jPanelDispositivoLayout);
        jPanelDispositivoLayout.setHorizontalGroup(
            jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                        .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdicionarDispositivo)
                            .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca)
                                    .addComponent(lblTipo)
                                    .addComponent(lblModelo)
                                    .addComponent(lblNombreDispositivo)
                                    .addComponent(lblDireccionIP))
                                .addGap(11, 11, 11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionIP)
                            .addComponent(txtNombreDispositivo)
                            .addComponent(txtModelo)
                            .addComponent(txtMarca)
                            .addComponent(txtNombreArchivo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDispositivoLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnMostrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(btnModificarDispositivo)
                                .addGap(35, 35, 35))
                            .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(lblNombreArchivo))
                .addContainerGap())
        );
        jPanelDispositivoLayout.setVerticalGroup(
            jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDispositivoLayout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreArchivo))
                .addGap(18, 18, 18)
                .addGroup(jPanelDispositivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarDispositivo)
                    .addComponent(btnModificarDispositivo)
                    .addComponent(btnMostrar))
                .addContainerGap())
        );

        jPanelSubestacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subestación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblNombreSubestacion.setText("Nombre de Subestación:");

        lblNivelTension.setText("Nivel de Tensión:");

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

        lblNivelTension1.setText("kV");

        javax.swing.GroupLayout jPanelSubestacionLayout = new javax.swing.GroupLayout(jPanelSubestacion);
        jPanelSubestacion.setLayout(jPanelSubestacionLayout);
        jPanelSubestacionLayout.setHorizontalGroup(
            jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombreSubestacion)
                        .addComponent(lblNivelTension)
                        .addComponent(lblCelda))
                    .addComponent(btnAdicionarSubestacion))
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreSubestacion, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(txtCelda)
                            .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                                .addComponent(txtNivelTension, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(lblNivelTension1))))
                    .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnModificarSubestacion)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelSubestacionLayout.setVerticalGroup(
            jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubestacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreSubestacion)
                    .addComponent(txtNombreSubestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivelTension)
                    .addComponent(txtNivelTension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNivelTension1))
                .addGap(18, 18, 18)
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelda)
                    .addComponent(txtCelda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSubestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarSubestacion)
                    .addComponent(btnModificarSubestacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros de Red", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblNombreRed.setText("Nombre de Red:");

        lblPuertaEnlace.setText("Puerta de Enlace:");

        lblDireccionDestino.setText("Dirección IP Destino:");

        btnModificarSubestacion1.setText("Modificar");
        btnModificarSubestacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarSubestacion1ActionPerformed(evt);
            }
        });

        btnAdicionarSubestacion1.setText("Adicionar");
        btnAdicionarSubestacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarSubestacion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRedLayout = new javax.swing.GroupLayout(jPanelRed);
        jPanelRed.setLayout(jPanelRedLayout);
        jPanelRedLayout.setHorizontalGroup(
            jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccionDestino)
                    .addComponent(lblPuertaEnlace)
                    .addComponent(lblNombreRed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreRed, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuertaEnlace, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRedLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionarSubestacion1)
                .addGap(29, 29, 29)
                .addComponent(btnModificarSubestacion1)
                .addGap(66, 66, 66))
        );
        jPanelRedLayout.setVerticalGroup(
            jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreRed)
                    .addComponent(txtNombreRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuertaEnlace)
                    .addComponent(txtPuertaEnlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionDestino)
                    .addComponent(txtDireccionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarSubestacion1)
                    .addComponent(btnModificarSubestacion1))
                .addGap(28, 28, 28))
        );

        jPanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Dispositivos Registrados"));

        tblDispositivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Marca", "Modelo", "Dispositivo", "Dirección IP", "Archivo"
            }
        ));
        tblDispositivo.setColumnSelectionAllowed(true);
        jScrollPaneTabla.setViewportView(tblDispositivo);
        tblDispositivo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        );

        jPanelTabla1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dispositivos Registrados"));

        tblDispositivo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Subestación", "Tensión kV", "Celda"
            }
        ));
        tblDispositivo1.setColumnSelectionAllowed(true);
        jScrollPaneTabla1.setViewportView(tblDispositivo1);
        tblDispositivo1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanelTabla1Layout = new javax.swing.GroupLayout(jPanelTabla1);
        jPanelTabla1.setLayout(jPanelTabla1Layout);
        jPanelTabla1Layout.setHorizontalGroup(
            jPanelTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelTabla1Layout.setVerticalGroup(
            jPanelTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabla1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        );

        jPanelTabla2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dispositivos Registrados"));

        tblDispositivo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Red", "Puerta Enlace", "IP Destino"
            }
        ));
        tblDispositivo2.setColumnSelectionAllowed(true);
        jScrollPaneTabla2.setViewportView(tblDispositivo2);
        tblDispositivo2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanelTabla2Layout = new javax.swing.GroupLayout(jPanelTabla2);
        jPanelTabla2.setLayout(jPanelTabla2Layout);
        jPanelTabla2Layout.setHorizontalGroup(
            jPanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelTabla2Layout.setVerticalGroup(
            jPanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabla2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDatosGeneralesLayout = new javax.swing.GroupLayout(jPanelDatosGenerales);
        jPanelDatosGenerales.setLayout(jPanelDatosGeneralesLayout);
        jPanelDatosGeneralesLayout.setHorizontalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelSubestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(116, 116, 116)))
                .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTabla2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanelDatosGeneralesLayout.setVerticalGroup(
            jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelSubestacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(24, 24, 24)
                        .addGroup(jPanelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelTabla2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(jPanelDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addGap(32, 32, 32)
                .addComponent(jPanelDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmAdministrador ADM = new frmAdministrador();
            ADM.setVisible(true);
            dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarSubestacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarSubestacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarSubestacionActionPerformed

    private void btnModificarSubestacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarSubestacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarSubestacionActionPerformed

    private void btnModificarSubestacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarSubestacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarSubestacion1ActionPerformed

    private void btnAdicionarSubestacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarSubestacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarSubestacion1ActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        Mostrar();
    }//GEN-LAST:event_btnMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(frmGestionarDispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGestionarDispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGestionarDispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGestionarDispositivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new frmGestionarDispositivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarDispositivo;
    private javax.swing.JButton btnAdicionarSubestacion;
    private javax.swing.JButton btnAdicionarSubestacion1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificarDispositivo;
    private javax.swing.JButton btnModificarSubestacion;
    private javax.swing.JButton btnModificarSubestacion1;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jPanelDatosGenerales;
    private javax.swing.JPanel jPanelDispositivo;
    private javax.swing.JPanel jPanelRed;
    private javax.swing.JPanel jPanelSubestacion;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelTabla1;
    private javax.swing.JPanel jPanelTabla2;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JScrollPane jScrollPaneTabla1;
    private javax.swing.JScrollPane jScrollPaneTabla2;
    private javax.swing.JLabel lblCelda;
    private javax.swing.JLabel lblDireccionDestino;
    private javax.swing.JLabel lblDireccionIP;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNivelTension;
    private javax.swing.JLabel lblNivelTension1;
    private javax.swing.JLabel lblNombreArchivo;
    private javax.swing.JLabel lblNombreDispositivo;
    private javax.swing.JLabel lblNombreRed;
    private javax.swing.JLabel lblNombreSubestacion;
    private javax.swing.JLabel lblPuertaEnlace;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTable tblDispositivo;
    private javax.swing.JTable tblDispositivo1;
    private javax.swing.JTable tblDispositivo2;
    private javax.swing.JTextField txtCelda;
    private javax.swing.JTextField txtDireccionDestino;
    private javax.swing.JTextField txtDireccionIP;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNivelTension;
    private javax.swing.JTextField txtNombreArchivo;
    private javax.swing.JTextField txtNombreDispositivo;
    private javax.swing.JTextField txtNombreRed;
    private javax.swing.JTextField txtNombreSubestacion;
    private javax.swing.JTextField txtPuertaEnlace;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
