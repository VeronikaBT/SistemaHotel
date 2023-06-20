
package Crud;

import utils.Conexion;
import Modelo.Huesped;
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
public class fhuesped {
    
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private  String sSQL="";
    private  String sSQL2="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","Nombre","A.Paterno","A.Materno","T.Doc","N.Doc","Dirección","Celular","Código"};
        
        String [] registro =new String [9];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select p.idpersona,p.nombre,p.apellidopaterno,p.apellidomaterno,p.tipodocumento,p.numdocumento,"+
                "p.direccion,p.celular,h.cod_huesped from persona p inner join huesped h " +
                "on p.idpersona=h.idpersona where numdocumento like '%"+
                Buscar+"%' order by idpersona desc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpersona");
                registro [1]=rs.getString("nombre");
                registro [2]=rs.getString("apellidopaterno");
                registro [3]=rs.getString("apellidomaterno");
                registro [4]=rs.getString("tipodocumento");
                registro [5]=rs.getString("numdocumento");
                registro [6]=rs.getString("direccion");
                registro [7]=rs.getString("celular");
                registro [8]=rs.getString("cod_huesped");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
    public boolean insertar(Huesped hue){
        sSQL="insert into persona (nombre,apellidopaterno,apellidomaterno,tipodocumento,"+
                "numdocumento,direccion,celular)"+
                "values (?,?,?,?,?,?,?)";
        sSQL2="insert into huesped (idpersona,cod_huesped)"+
                "values ((select idpersona from persona order by idpersona desc limit 1),?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst2=cn.prepareStatement(sSQL2);
            
            pst.setString(1, hue.getNom());
            pst.setString(2, hue.getApep());
            pst.setString(3, hue.getApem());
            pst.setString(4, hue.getTdoc());
            pst.setString(5, hue.getNdoc());
            pst.setString(6, hue.getDir());
            pst.setString(7, hue.getCel());
            
            pst2.setString(1, hue.getCodhuesped());
            
            
            int n=pst.executeUpdate();
            if(n!=0){
                int n2=pst2.executeUpdate();
                if (n2!=0) {
                    return true;
                    
                }
                else{
                    return false;
                }
                
            }
            else{
                return false;
            }
            
            
            
        } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
    
    public boolean editar(Huesped hue){
        sSQL="update persona set nombre=?,apellidopaterno=?,apellidomaterno=?,tipodocumento=?,"+
                " numdocumento=?,direccion=?,celular=? where idpersona=?";
       sSQL2="update huesped set cod_huesped=? where idpersona=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst2=cn.prepareStatement(sSQL2);
            
            pst.setString(1, hue.getNom());
            pst.setString(2, hue.getApep());
            pst.setString(3, hue.getApem());
            pst.setString(4, hue.getTdoc());
            pst.setString(5, hue.getNdoc());
            pst.setString(6, hue.getDir());
            pst.setString(7, hue.getCel());
            pst.setInt(8, hue.getIdper());
            
            pst2.setString(1, hue.getCodhuesped());
            pst2.setInt(2, hue.getIdper());
            
            
            int n=pst.executeUpdate();
            if(n!=0){
                int n2=pst2.executeUpdate();
                if (n2!=0) {
                    return true;
                    
                }
                else{
                    return true;
                }
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
                return false;
        }
    }
    
    public boolean eliminar(Huesped hue){
        sSQL="delete from huesped where idpersona=?";
        sSQL2="delete from persona where idpersona=?"; 
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst2=cn.prepareStatement(sSQL2);
            
            pst.setInt(1, hue.getIdper());
            
            pst2.setInt(1, hue.getIdper());
            
            int n=pst.executeUpdate();
            if(n!=0){
                int n2=pst2.executeUpdate();
                if (n2!=0) {
                    return true;
                    
                }
                else{
                    return false;
                }
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
        
        String [] titulos= {"ID","Nombre","A.Paterno","A.Materno","T.Doc","N.Doc","Dirección","Celular","Código"};
        
        String [] registro =new String [9];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select p.idpersona,p.nombre,p.apellidopaterno,p.apellidomaterno,p.tipodocumento,p.numdocumento,"+
                "p.direccion,p.celular,h.cod_huesped from persona p inner join huesped h " +
                "on p.idpersona=h.idpersona where numdocumento like '%"+
                Buscar+"%' order by idpersona desc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpersona");
                registro [1]=rs.getString("nombre");
                registro [2]=rs.getString("apellidopaterno");
                registro [3]=rs.getString("apellidomaterno");
                registro [4]=rs.getString("tipodocumento");
                registro [5]=rs.getString("numdocumento");
                registro [6]=rs.getString("direccion");
                registro [7]=rs.getString("celular");
                registro [8]=rs.getString("cod_huesped");
                
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
