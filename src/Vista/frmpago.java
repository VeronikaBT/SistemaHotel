/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Crud.fconsumo;
import Crud.fhabitacion;
import Crud.fpago;
import Crud.freserva;
import Modelo.Pago;
import Modelo.habitacion;
import static Vista.frmReserva.txtidhabitacion;
import static Vista.frmReserva.txtidhuesped;
import static Vista.frmReserva.txtnomhuesped;
import static Vista.frmReserva.txtnumhab;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class frmpago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmpago
     */
    public frmpago() {
        initComponents();
        mostrar(idreserva);
        inhabilitar();
        txtidreserva.setText(idreserva);
        txtnomhuesped.setText(huesped);
        txtidhabitacion.setText(idhabitacion);
        txthabitacion.setText(habitacion);
        txttotalreserva.setText(Double.toString(totalreserva));
        
        fconsumo func=new fconsumo();
        func.mostrar(idreserva);
        
        txtotalpago.setText(Double.toString(totalreserva+func.totalconsumo));
        
        
    }
    private String accion="guardar";
    public static String idreserva;
    public static String huesped;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;
    //public static int idusuario;
    
    void ocultar_columnas(){
        jtblPagos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtblPagos.getColumnModel().getColumn(0).setMinWidth(0);
        jtblPagos.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jtblPagos.getColumnModel().getColumn(1).setMaxWidth(0);
        jtblPagos.getColumnModel().getColumn(1).setMinWidth(0);
        jtblPagos.getColumnModel().getColumn(1).setPreferredWidth(0);
         
    }
      void ocultar_columnasconsumo(){
        jbtlConsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        jbtlConsumo.getColumnModel().getColumn(0).setMinWidth(0);
        jbtlConsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jbtlConsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        jbtlConsumo.getColumnModel().getColumn(1).setMinWidth(0);
        jbtlConsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        jbtlConsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        jbtlConsumo.getColumnModel().getColumn(2).setMinWidth(0);
        jbtlConsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
         
    }
    
    
    void inhabilitar(){
        txtidpago.setVisible(false);
        txtidreserva.setVisible(false);
        txtidhabitacion.setVisible(false);
             
        txtnomhuesped.setEnabled(false);
        txttotalreserva.setEnabled(false);
        txthabitacion.setEnabled(false);
        jcbTipopago.setEnabled(false);
        txtotalpago.setEnabled(false);
        dcfechapago.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtidpago.setText("");
        txtotalpago.setText("");
                  
    }

        void habilitar(){
        txtidpago.setVisible(false);
        txtidreserva.setVisible(true);
        txtidhabitacion.setVisible(true);
        
        txtnomhuesped.setEnabled(true);
        txttotalreserva.setEnabled(true);
        txthabitacion.setEnabled(true);
        jcbTipopago.setEnabled(true);
        txtotalpago.setEnabled(true);
        dcfechapago.setEnabled(true);
        
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtidpago.setText("");
        //txtotalpago.setText("");
    }
        
    void mostrar(String buscar){
        try {
            DefaultTableModel modelo;
            fpago func= new fpago();
            modelo = func.mostrar(buscar);      
            jtblPagos.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos: "+Integer.toString(func.totalregistros));
            lblpago.setText("S/. "+func.totalpago);
        
            
            //Mostrar los datos de los consumos
            fconsumo func2=new fconsumo();
            modelo = func2.mostrar(buscar);
            jbtlConsumo.setModel(modelo);
            ocultar_columnasconsumo();
            lbltotalregistrosconsumo.setText("Total Consumos: "+Integer.toString(func2.totalregistros));
            lblconsumo.setText("S/. "+func2.totalconsumo);
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
                    
        }
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
        txtnomhuesped = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidpago = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtidreserva = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dcfechapago = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtotalpago = new javax.swing.JTextField();
        jcbTipopago = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txthabitacion = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttotalreserva = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblPagos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        lblpago = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jbtlConsumo = new javax.swing.JTable();
        lbltotalregistrosconsumo = new javax.swing.JLabel();
        lblconsumo1 = new javax.swing.JLabel();
        lblconsumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pago");

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtnomhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomhuespedActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Reserva:");

        btnNuevo.setBackground(new java.awt.Color(102, 102, 102));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.GIF"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Fecha Pago:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tipo Pago:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Total Pago:");

        txtotalpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotalpagoActionPerformed(evt);
            }
        });

        jcbTipopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Yape", "Plin" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Habitación:");

        txthabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthabitacionActionPerformed(evt);
            }
        });

        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Total Reserva:");

        txttotalreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalreservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnNuevo)
                        .addGap(22, 22, 22)
                        .addComponent(btnGuardar)
                        .addGap(35, 35, 35)
                        .addComponent(btnCancelar)))
                .addGap(0, 117, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(txtnomhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(jcbTipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtotalpago, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnomhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbTipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtotalpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(dcfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNuevo))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jtblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblPagosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtblPagos);

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.gif"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalregistros.setText("Registros");

        lblpago.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblpago)
                .addGap(82, 82, 82)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistros)
                    .addComponent(lblpago)))
        );

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de consumos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jbtlConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jbtlConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtlConsumoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtlConsumoMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jbtlConsumo);

        lbltotalregistrosconsumo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalregistrosconsumo.setText("Registros");

        lblconsumo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblconsumo1.setText("Consumo Total:");

        lblconsumo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblconsumo.setText("S/.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblconsumo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblconsumo)
                        .addGap(110, 110, 110)
                        .addComponent(lbltotalregistrosconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltotalregistrosconsumo)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblconsumo1)
                        .addComponent(lblconsumo))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomhuespedActionPerformed
        // TODO add your handling code here:
        txtnomhuesped.transferFocus();
    }//GEN-LAST:event_txtnomhuespedActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("guardar");
        accion="guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        Pago pg=new Pago();
        fpago func=new fpago();

        pg.setIdreserva(Integer.parseInt(txtidreserva.getText()));
        
        int seleccionado=jcbTipopago.getSelectedIndex();
        pg.setTipopago((String)jcbTipopago.getItemAt(seleccionado));
        
        pg.setTotalpago(Double.parseDouble(txtotalpago.getText()));
        
        
        Calendar cal;
        int d,m,a,h;
        cal=dcfechapago.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        pg.setFechapago(new Date(a,m,d));

        if(accion.equals("guardar")){
            if(func.insertar(pg)){
                JOptionPane.showMessageDialog(rootPane,"El pago  del huesped "+txtnomhuesped.getText()+
                        " fue registrado correctamente");
                mostrar(idreserva);
                inhabilitar();
                
                //Desocupar la habitacion
                fhabitacion func2=new fhabitacion();
                habitacion hab=new habitacion();
                
                hab.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                func2.desocupar(hab);   

            }
            else{
                JOptionPane.showMessageDialog(rootPane,"El pago no fue registrado correctamente");

            }
        }
        else if(accion.equals("editar")){
            pg.setIdpago(Integer.parseInt(txtidpago.getText()));

            if(func.editar(pg)){
                JOptionPane.showMessageDialog(rootPane,"El pago  del huesped "+txtnomhuesped.getText()+
                        " fue editado correctamente");
                mostrar(idreserva);
                inhabilitar();
                
                

            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void jtblPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblPagosMouseClicked
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("Editar");
        btnEliminar.setEnabled(true);
        accion="editar";

        int fila = jtblPagos.rowAtPoint(evt.getPoint());

        txtidpago.setText(jtblPagos.getValueAt(fila,0).toString());
        jcbTipopago.setSelectedItem(jtblPagos.getValueAt(fila,2).toString());
        txtotalpago.setText(jtblPagos.getValueAt(fila, 3).toString());
        dcfechapago.setDate(Date.valueOf(jtblPagos.getValueAt(fila,4).toString()));

    }//GEN-LAST:event_jtblPagosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        if (!txtidpago.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de eliminar el pago?","confirmar",2);

            if (confirmacion==0) {
                fpago func=new fpago();
                Pago pdt= new Pago();

                pdt.setIdpago(Integer.parseInt(txtidpago.getText()));
                func.eliminar(pdt);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtotalpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotalpagoActionPerformed
        // TODO add your handling code here:
        transferFocus();
    }//GEN-LAST:event_txtotalpagoActionPerformed

    private void txthabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthabitacionActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void txttotalreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalreservaActionPerformed

    private void jbtlConsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtlConsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtlConsumoMouseClicked

    private void jbtlConsumoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtlConsumoMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtlConsumoMousePressed

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
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser dcfechapago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jbtlConsumo;
    private javax.swing.JComboBox<String> jcbTipopago;
    private javax.swing.JTable jtblPagos;
    private javax.swing.JLabel lblconsumo;
    private javax.swing.JLabel lblconsumo1;
    private javax.swing.JLabel lblpago;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumo;
    public static javax.swing.JTextField txthabitacion;
    public static javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidpago;
    public static javax.swing.JTextField txtidreserva;
    public static javax.swing.JTextField txtnomhuesped;
    public static javax.swing.JTextField txtotalpago;
    public static javax.swing.JTextField txttotalreserva;
    // End of variables declaration//GEN-END:variables
}
