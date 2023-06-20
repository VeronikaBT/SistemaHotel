package Crud;

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
public class fproducto {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private  String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","Nombre","Descripcion","Precio"};
        
        String [] registro =new String [4];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from productos where nombre like '"+Buscar+"%' order by idproductos desc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idproductos");
                registro [1]=rs.getString("nombre");
                registro [2]=rs.getString("descripcion");
                registro [3]=rs.getString("precio");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
    public boolean insertar(producto pdt){
        sSQL="insert into productos (nombre,descripcion,precio)"+
                "values (?,?,?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, pdt.getNombre());
            pst.setString(2, pdt.getDescripcion());
            pst.setDouble(3, pdt.getPrecio());

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
    
    public boolean editar(producto pdt){
        sSQL="update productos set nombre=?,descripcion=?,precio=?"+
                "where idproductos=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, pdt.getNombre());
            pst.setString(2, pdt.getDescripcion());
            pst.setDouble(3, pdt.getPrecio());
            pst.setInt(4, pdt.getIdproducto());
            
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
    
    public boolean eliminar(producto pdt){
        sSQL="delete from productos where idproductos=?";     
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, pdt.getIdproducto());
            
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
        
        String [] titulos= {"ID","Nombre","Descripcion","Precio"};
        
        String [] registro =new String [4];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from productos where nombre like '%"+Buscar+"%' order by idproductos desc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idproductos");
                registro [1]=rs.getString("nombre");
                registro [2]=rs.getString("descripcion");
                registro [3]=rs.getString("precio");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
}
