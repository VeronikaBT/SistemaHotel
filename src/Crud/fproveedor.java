package Crud;

import Modelo.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Conexion;

public class fproveedor {

    private Conexion mysql = new Conexion();
    private Connection con = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String Buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "A.Paterno", "A.Materno", "T.Doc", "N.Doc", "Dirección", "Celular", "Razon Social", "Suministro"};

        String[] registro = new String[10];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpersona,p.nombre,p.apellidopaterno,p.apellidomaterno,p.tipodocumento,p.numdocumento,"
                + "p.direccion,p.celular,v.razon,v.suministro from persona p inner join proveedor v "
                + "on p.idpersona=v.idpersona where numdocumento like '%"
                + Buscar + "%' order by idpersona desc";

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidopaterno");
                registro[3] = rs.getString("apellidomaterno");
                registro[4] = rs.getString("tipodocumento");
                registro[5] = rs.getString("numdocumento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("celular");
                registro[8] = rs.getString("razon");
                registro[9] = rs.getString("suministro");
                

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Proveedor pro) {

        sSQL = "insert into persona (nombre,apellidopaterno,apellidomaterno,tipodocumento,"
                + "numdocumento,direccion,celular)"
                + "values (?,?,?,?,?,?,?)";
        sSQL2 = "insert into proveedor (idpersona,razon,suministro)"
                + "values ((select idpersona from persona order by idpersona desc limit 1),?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            pst.setString(1, pro.getNom());
            pst.setString(2, pro.getApep());
            pst.setString(3, pro.getApem());
            pst.setString(4, pro.getTdoc());
            pst.setString(5, pro.getNdoc());
            pst.setString(6, pro.getDir());
            pst.setString(7, pro.getCel());

            pst2.setString(1, pro.getRazon());
            pst2.setString(2, pro.getSuministro());
            

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error");
            return false;
        }
    }

    public boolean editar(Proveedor pro) {
        sSQL = "update persona set nombre=?,apellidopaterno=?,apellidomaterno=?,tipodocumento=?,"
                + " numdocumento=?,direccion=?,celular=? where idpersona=?";
        sSQL2 = "update proveedor set razon=?,suministro=? where idpersona=?";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            pst.setString(1, pro.getNom());
            pst.setString(2, pro.getApep());
            pst.setString(3, pro.getApem());
            pst.setString(4, pro.getTdoc());
            pst.setString(5, pro.getNdoc());
            pst.setString(6, pro.getDir());
            pst.setString(7, pro.getCel());
            pst.setInt(8, pro.getIdper());

            pst2.setString(1, pro.getRazon());
            pst2.setString(2, pro.getSuministro());
            pst2.setInt(8, pro.getIdper());

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;

                } else {
                    return true;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Proveedor pro) {
        sSQL = "delete from usuarios where idpersona=?";
        sSQL2 = "delete from persona where idpersona=?";

        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            pst.setInt(1, pro.getIdper());

            pst2.setInt(1, pro.getIdper());

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    

    
}
