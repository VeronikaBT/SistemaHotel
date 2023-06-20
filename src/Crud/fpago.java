package Crud;

import Modelo.Pago;
import utils.Conexion;
import Modelo.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class fpago {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private  String sSQL="";
    public Integer totalregistros;
    public Double totalpago;
  
    public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","ID Reserva","Tipo Pago","Total Pago","Fecha Pago"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        totalpago=0.0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from pago where idreserva like '%"+Buscar+"%' order by idpago desc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpago");
                registro [1]=rs.getString("idreserva");
                registro [2]=rs.getString("tipo_pago");
                registro [3]=rs.getString("total_pago");
                registro [4]=rs.getString("fecha_pago");
                
                totalregistros=totalregistros+1;
                totalpago=totalpago+(rs.getDouble("total_pago"));
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
    public boolean insertar(Pago pg){
        sSQL="insert into pago (idreserva,tipo_pago,total_pago,fecha_pago)"+
                "values (?,?,?,?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, pg.getIdreserva());
            pst.setString(2, pg.getTipopago());
            pst.setDouble(3, pg.getTotalpago());
            pst.setDate(4, pg.getFechapago());
           
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
    
    public boolean editar(Pago pg){
        sSQL="update pago set idreserva=?,tipo_pago=?,total_pago=?,fecha_pago=?"+
                "where idpago=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, pg.getIdreserva());
            pst.setString(2, pg.getTipopago());
            pst.setDouble(3, pg.getTotalpago());
            pst.setDate(4, pg.getFechapago());
            pst.setInt(5, pg.getIdpago());
            
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
    
    public boolean eliminar(Pago pg){
        sSQL="delete from pago where idpago=?";     
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, pg.getIdpago());
            
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
        public DefaultTableModel mostrartodos(String tipopago){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","ID Reserva","Tipo Pago","Total Pago","Fecha Pago"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        totalpago=0.0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from pago where tipo_pago like '%"+tipopago
                + "%' order by fecha_pago asc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpago");
                registro [1]=rs.getString("idreserva");
                registro [2]=rs.getString("tipo_pago");
                registro [3]=rs.getString("total_pago");
                registro [4]=rs.getString("fecha_pago");
                
                totalregistros=totalregistros+1;
                totalpago=totalpago+(rs.getDouble("total_pago"));
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
        public DefaultTableModel buscarporfechas(String Buscar,String buscar2){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","ID Reserva","Tipo Pago","Total Pago","Fecha Pago"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        totalpago=0.0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from pago where fecha_pago between '"+Buscar+"' and '"+buscar2+"' order by fecha_pago asc";//order by idpago desc
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpago");
                registro [1]=rs.getString("idreserva");
                registro [2]=rs.getString("tipo_pago");
                registro [3]=rs.getString("total_pago");
                registro [4]=rs.getString("fecha_pago");
                
                totalregistros=totalregistros+1;
                totalpago=totalpago+(rs.getDouble("total_pago"));
                
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
         public DefaultTableModel buscartipopago(String Buscar,String buscar2,String tipopago){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","ID Reserva","Tipo Pago","Total Pago","Fecha Pago"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        totalpago=0.0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from pago where fecha_pago between '"+Buscar+"' and '"+buscar2+"' and tipo_pago = '"
                +tipopago+ "' order by fecha_pago asc";//order by idpago desc
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpago");
                registro [1]=rs.getString("idreserva");
                registro [2]=rs.getString("tipo_pago");
                registro [3]=rs.getString("total_pago");
                registro [4]=rs.getString("fecha_pago");
                
                totalregistros=totalregistros+1;
                totalpago=totalpago+(rs.getDouble("total_pago"));
                
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
}
