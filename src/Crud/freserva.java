package Crud;

import utils.Conexion;
import Modelo.Reserva;
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
public class freserva {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private  String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String Buscar){
        DefaultTableModel modelo;
        
        String [] titulos= {"ID","idHabitación","Número","idHuesped","Huesped","Estancia","Fecha Reserva","Fecha Ingreso","Fecha Salida","Costo"};
        
        String [] registro =new String [10];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select r.idreserva,r.idhabitacion,h.numerohabitacion,r.idhuesped,"+
                "(select nombre from persona where idpersona=r.idhuesped)as huespedn,"+ 
                "(select apellidopaterno from persona where idpersona=r.idhuesped)as huespedap,r.estancia,r.fechareserva,"+
                "r.ingreso,r.salida,r.costo"+
                " from reserva r inner join habitacion h on r.idhabitacion=h.idhabitacion where r.fechareserva like '%"+Buscar+
                "%' order by idreserva desc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idreserva");
                registro [1]=rs.getString("idhabitacion");
                registro [2]=rs.getString("numerohabitacion");
                registro [3]=rs.getString("idhuesped");
                registro [4]=rs.getString("huespedn")+ " "+rs.getString("huespedap");
                registro [5]=rs.getString("estancia");
                registro [6]=rs.getString("fechareserva");
                registro [7]=rs.getString("ingreso");
                registro [8]=rs.getString("salida");
                registro [9]=rs.getString("costo");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;        
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
       
    }
    
    public boolean insertar(Reserva rsv){
        sSQL="insert into reserva (idhabitacion,idhuesped,estancia,fechareserva,ingreso,salida,costo)"+
                "values (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, rsv.getIdhab());
            pst.setInt(2, rsv.getIdhuesped());
            pst.setInt(3, rsv.getEstancia());
            pst.setDate(4, rsv.getFecharsv());
            pst.setString(5, rsv.getIngreso());
            pst.setString(6, rsv.getSalida());
            pst.setDouble(7, rsv.getCosto());

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
    
    public boolean editar(Reserva rsv){
        //sSQL="update reserva set idhabitacion=?,idhuesped=?,estancia=?,fechareserva=?,ingreso=?,salida=?,costo=?"+
                //"where idreserva=?";
         sSQL="update reserva set salida=?"+
                "where idreserva=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            //pst.setInt(1, rsv.getIdhab());
            //pst.setInt(2, rsv.getIdhuesped());
            //pst.setInt(3, rsv.getEstancia());
            //pst.setDate(4, rsv.getFecharsv());
            //pst.setString(5, rsv.getIngreso());
            pst.setString(1, rsv.getSalida());
            //pst.setDouble(7, rsv.getCosto());
            pst.setInt(2, rsv.getIdreserva());
            
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
    
    public boolean eliminar(Reserva rsv){
        sSQL="delete from reserva where idreserva=?";     
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, rsv.getIdreserva());
            
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
        
        String [] titulos= {"ID","idHabitación","Número","idHuesped","Huesped","Estancia","Fecha Reserva","Fecha Ingreso","Fecha Salida","Costo"};
        
        String [] registro =new String [10];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select r.idreserva,r.idhabitacion,h.numerohabitacion,r.idhuesped,"+
                "(select nombre from persona where idpersona=r.idhuesped)as huespedn,"+ 
                "(select apellidopaterno from persona where idpersona=r.idhuesped)as huespedap,r.estancia,r.fechareserva,"+
                "r.ingreso,r.salida,r.costo"+
                " from reserva r inner join habitacion h on r.idhabitacion=h.idhabitacion where r.fechareserva like '%"+Buscar+
                "%' order by idreserva desc";
        
        try {
            
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sSQL);
           
            while(rs.next()){
                registro [0]=rs.getString("idreserva");
                registro [1]=rs.getString("idhabitacion");
                registro [2]=rs.getString("numerohabitacion");
                registro [3]=rs.getString("idhuesped");
                registro [4]=rs.getString("huespedn")+ " "+rs.getString("huespedap");
                registro [5]=rs.getString("estancia");
                registro [6]=rs.getString("fechareserva");
                registro [7]=rs.getString("ingreso");
                registro [8]=rs.getString("salida");
                registro [9]=rs.getString("costo");
                
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
