
package Crud;

import utils.Conexion;
import Modelo.habitacion;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

public class fhabitacion {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private  String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","Número","Piso","Tipo","Descripción","Precio","Estado"};
        
        String [] registro =new String [8];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from habitacion where pisohabitacion like '%"+Buscar+"%' order by idhabitacion";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idhabitacion");
                registro [1]=rs.getString("numerohabitacion");
                registro [2]=rs.getString("pisohabitacion");
                registro [3]=rs.getString("tipohabitacion");
                registro [4]=rs.getString("descripcion");
                registro [5]=rs.getString("precio");
                registro [6]=rs.getString("estado");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
    public boolean insertar(habitacion hab){
        sSQL="insert into habitacion (numerohabitacion,pisohabitacion,tipohabitacion,descripcion,precio,estado)"+
                "values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, hab.getNumero());
            pst.setString(2, hab.getPiso());
            pst.setString(3, hab.getTipohabitacion());
            pst.setString(4, hab.getDescripcion());
            pst.setDouble(5, hab.getPreciodiario());
            pst.setString(6, hab.getEstado());
            
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
    
    public boolean editar(habitacion hab){
        sSQL="update habitacion set numerohabitacion=?,pisohabitacion=?,tipohabitacion=?,descripcion=?,precio=?,estado=?"+
                "where idhabitacion=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, hab.getNumero());
            pst.setString(2, hab.getPiso());
            pst.setString(3, hab.getTipohabitacion());
            pst.setString(4, hab.getDescripcion());
            pst.setDouble(5, hab.getPreciodiario());
            pst.setString(6, hab.getEstado());
            pst.setInt(7, hab.getIdhabitacion());
            
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
    
    
    public boolean eliminar(habitacion hab){
        sSQL="delete from habitacion where idhabitacion=?";     
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, hab.getIdhabitacion());
            
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
    public DefaultTableModel mostrarvista(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","Número","Piso","Tipo","Descripción","Precio","Estado"};
        
        String [] registro =new String [8];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from habitacion where pisohabitacion like '%"+Buscar+"%' and estado= 'Disponible' order by idhabitacion";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idhabitacion");
                registro [1]=rs.getString("numerohabitacion");
                registro [2]=rs.getString("pisohabitacion");
                registro [3]=rs.getString("tipohabitacion");
                registro [4]=rs.getString("descripcion");
                registro [5]=rs.getString("precio");
                registro [6]=rs.getString("estado");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
        public boolean desocupar(habitacion hab){
        sSQL="update habitacion set estado='Disponible'"+
                " where idhabitacion=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, hab.getIdhabitacion());
            
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
   
        public boolean ocupar(habitacion hab){
        sSQL="update habitacion set estado='Ocupado'"+
                " where idhabitacion=?"; 
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, hab.getIdhabitacion());
            
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
    
    
    
}
