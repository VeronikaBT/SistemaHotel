
package Crud;

import utils.Conexion;
import Modelo.Huesped;
import Modelo.usuario;
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
public class fusuario {
    
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private  String sSQL="";
    private  String sSQL2="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","Nombre","A.Paterno","A.Materno","T.Doc","N.Doc","Dirección","Celular","Sueldo","Cargo","User","Contra"};
        
        String [] registro =new String [12];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select p.idpersona,p.nombre,p.apellidopaterno,p.apellidomaterno,p.tipodocumento,p.numdocumento,"+
                "p.direccion,p.celular,u.sueldo,u.cargo,u.user,u.contra from persona p inner join usuarios u " +
                "on p.idpersona=u.idpersona where numdocumento like '%"+
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
                registro [8]=rs.getString("sueldo");
                registro [9]=rs.getString("cargo");
                registro [10]=rs.getString("user");
                registro [11]=rs.getString("contra");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
    public boolean insertar(usuario usr){
        
        sSQL="insert into persona (nombre,apellidopaterno,apellidomaterno,tipodocumento,"+
                "numdocumento,direccion,celular)"+
                "values (?,?,?,?,?,?,?)";
        sSQL2="insert into usuarios (idpersona,sueldo,cargo,user,contra)"+
                "values ((select idpersona from persona order by idpersona desc limit 1),?,?,?,?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst2=cn.prepareStatement(sSQL2);
            
            pst.setString(1, usr.getNom());
            pst.setString(2, usr.getApep());
            pst.setString(3, usr.getApem());
            pst.setString(4, usr.getTdoc());
            pst.setString(5, usr.getNdoc());
            pst.setString(6, usr.getDir());
            pst.setString(7, usr.getCel());
            
            pst2.setDouble(1, usr.getSueldo());
            pst2.setString(2, usr.getCargo());
            pst2.setString(3, usr.getUser());
            pst2.setString(4, usr.getContra());
            
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
    
    public boolean editar(usuario usr){
        sSQL="update persona set nombre=?,apellidopaterno=?,apellidomaterno=?,tipodocumento=?,"+
                " numdocumento=?,direccion=?,celular=? where idpersona=?";
       sSQL2="update usuarios set sueldo=?,cargo=?,user=?,contra=? where idpersona=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst2=cn.prepareStatement(sSQL2);
            
            pst.setString(1, usr.getNom());
            pst.setString(2, usr.getApep());
            pst.setString(3, usr.getApem());
            pst.setString(4, usr.getTdoc());
            pst.setString(5, usr.getNdoc());
            pst.setString(6, usr.getDir());
            pst.setString(7, usr.getCel());
            pst.setInt(8, usr.getIdper());
            
            pst2.setDouble(1, usr.getSueldo());
            pst2.setString(2, usr.getCargo());
            pst2.setString(3, usr.getUser());
            pst2.setString(4, usr.getContra());
            pst2.setInt(5, usr.getIdper());
            
            
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
    
    public boolean eliminar(usuario usr){
        sSQL="delete from usuarios where idpersona=?";
        sSQL2="delete from persona where idpersona=?"; 
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            PreparedStatement pst2=cn.prepareStatement(sSQL2);
            
            pst.setInt(1, usr.getIdper());
            
            pst2.setInt(1, usr.getIdper());
            
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
    
    public DefaultTableModel login(String user,String contra){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","Nombre","A.Paterno","A.Materno","Cargo","User","Contra"};
        
        String [] registro =new String [7];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select p.idpersona,p.nombre,p.apellidopaterno,p.apellidomaterno,"+
                "u.cargo,u.user,u.contra from persona p inner join usuarios u " +
                "on p.idpersona=u.idpersona where u.user = '"+
                user+"' and u.contra = '"+contra+"'";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idpersona");
                registro [1]=rs.getString("nombre");
                registro [2]=rs.getString("apellidopaterno");
                registro [3]=rs.getString("apellidomaterno");
                registro [4]=rs.getString("cargo");
                registro [5]=rs.getString("user");
                registro [6]=rs.getString("contra");
                
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
