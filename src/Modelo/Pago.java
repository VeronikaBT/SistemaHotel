package Modelo;
import java.sql.*;

/**
 *
 * @author Leonardo
 */
public class Pago {
    private int idpago;
    private int idreserva;
    private String tipopago;
    private double totalpago;
    private Date fechapago;

    public Pago() {
    }

    public Pago(int idpago, int idreserva, String tipopago, double totalpago, Date fechapago) {
        this.idpago = idpago;
        this.idreserva = idreserva;
        this.tipopago = tipopago;
        this.totalpago = totalpago;
        this.fechapago = fechapago;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public double getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(double totalpago) {
        this.totalpago = totalpago;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }
    
    
    
    
    
    
}
