/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.sql.Connection;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.Conexion;

/**
 *
 * @author user
 */
public class frmHabitaciones extends javax.swing.JFrame {

    /**
     * Creates new form hb
     */
    public frmHabitaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        Botones();
        buscarhbreservadas();
    }
    
    int filas = 5;
    int columnas= 6;
    int largoboton= 140;
    int anchoboton= 60;
    int ejex=20;
    int ejey=20;
    
    //private static Connection conexion;
    public static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado;
    private Conexion mysql=new Conexion();

    

    
    public JToggleButton [][] JTBotones = new JToggleButton[filas][columnas];
    
    public void Botones(){
        int contadorhb= 1;
        JTBotones = new JToggleButton[filas][columnas];
        for(int i=0;i<filas;i++){
            for (int j=0;j<columnas;j++){
            JTBotones [i][j] = new JToggleButton();
            JTBotones [i][j].setBounds(ejex,ejey,largoboton,anchoboton);
            JTBotones [i][j].setText("Habitación "+contadorhb);
            JTBotones [i][j].setBackground(Color.green);
            
            AccionBotones accion =new AccionBotones();
            JTBotones [i][j].addActionListener(accion);
            jPanel1.add(JTBotones[i][j]);
            
            contadorhb++;
            ejex+=160;
            }
            ejex =20;
            ejey+=80;
            
        }
    }
    
    public void reservahb(int numerohb){
        Connection cn=mysql.conectar();
        try{
           String consulta ="UPDATE habitacion SET estado ='Ocupado' WHERE numerohabitacion ="+numerohb;
           sentenciaPreparada = cn.prepareStatement(consulta);
           int mensaje = sentenciaPreparada.executeUpdate();
           
           if (mensaje>0){
               JOptionPane.showMessageDialog(null, "Habitacion reservada");
               this.dispose();
           }else{
            JOptionPane.showMessageDialog(null, "Error");
           }
        }
        catch (HeadlessException|SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: "+ex);
            }
        }
    }
    
    public void eliminarhb(int numerohb){
        Connection cn=mysql.conectar();
        try{
           String consulta ="UPDATE habitacion SET estado ='Disponible' WHERE numerohabitacion ="+numerohb;
           sentenciaPreparada = cn.prepareStatement(consulta);
           int mensaje = sentenciaPreparada.executeUpdate();
           
           if (mensaje>0){
               JOptionPane.showMessageDialog(null, "Se quito la reserva");
               this.dispose();
           }else{
            JOptionPane.showMessageDialog(null, "Error");
           }
        }
        catch (HeadlessException|SQLException e){
            System.out.println("Error: "+e);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: "+ex);
            }
        }
    }
    
    
    public void buscarhbreservadas(){
        Connection cn=mysql.conectar();
        try {
            String consulta= "SELECT numerohabitacion,estado FROM habitacion";
            sentenciaPreparada = cn.prepareStatement(consulta);
            resultado = sentenciaPreparada.executeQuery();
            
            int numero;
            String estado;
            while(resultado.next()){
                numero =resultado.getInt("numerohabitacion");
                estado =resultado.getString("estado");
                for(int i=0;i<filas;i++){
                    for (int j=0;j<columnas;j++){
                       
                        if(JTBotones[i][j].getText().length() == 12){
                            String numeroLetra = JTBotones[i][j].getText().charAt(11)+"";
                            int numeroN = Integer.parseInt(numeroLetra);
                            if((numero == numeroN) && (estado.equals("Ocupado"))){
                                JTBotones[i][j].setBackground(Color.RED);
                                JTBotones[i][j].setSelected(true);
                            }
                        }else if (JTBotones[i][j].getText().length() == 13){
                            String numeroLetra = JTBotones[i][j].getText().charAt(11)+""+JTBotones[i][j].getText().charAt(12);
                            int numeroN = Integer.parseInt(numeroLetra);
                            if((numero == numeroN) && (estado.equals("Ocupado"))){
                                JTBotones[i][j].setBackground(Color.RED);
                                JTBotones[i][j].setSelected(true);
                            }
                        }
                    }
                }
                
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
    } 
    
    
    public class AccionBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0;i<filas;i++){
                for(int j=0;j<columnas;j++){
                
                    if(e.getSource().equals(JTBotones[i][j])){
                        if(JTBotones[i][j].isSelected()){
                           JTBotones[i][j].setBackground(Color.RED);
                           
                           if(JTBotones[i][j].getText().length() == 12){
                               String numeroLetra =JTBotones[i][j].getText().charAt(11)+"";
                               int numero =Integer.parseInt(numeroLetra);
                               reservahb(numero);
                           }else if(JTBotones[i][j].getText().length() == 13){
                               String numeroLetra =JTBotones[i][j].getText().charAt(11)+""+JTBotones[i][j].getText().charAt(12);
                               int numero =Integer.parseInt(numeroLetra);
                               reservahb(numero);
                           }
                        }else{
                            JTBotones[i][j].setBackground(Color.GREEN);
                            if(JTBotones[i][j].getText().length() == 12){
                               String numeroLetra =JTBotones[i][j].getText().charAt(11)+"";
                               int numero =Integer.parseInt(numeroLetra);
                               eliminarhb(numero);
                           }else if(JTBotones[i][j].getText().length() == 13){
                               String numeroLetra =JTBotones[i][j].getText().charAt(11)+""+JTBotones[i][j].getText().charAt(12);
                               int numero =Integer.parseInt(numeroLetra);
                               eliminarhb(numero);
                           }
                        }
                    }
                }
            }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setText("Estado de habitaciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 300, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1040, 420));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 60, 60));

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 60, 60));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mantenimiento");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Desocupado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ocupado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, -1, -1));

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.gif"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(frmHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHabitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
