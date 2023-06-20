package Modelo;

import java.sql.Date;

/**
 *
 * @author Leonardo
 */
public class Reserva {
    
    private int idreserva;
    private int idhab;
    private int idhuesped;
    private int estancia;
    private Date fecharsv;
    private String ingreso;
    private String salida;
    private Double costo;

    public Reserva() {
    }
    

    public Reserva(int idreserva, int idhab, int idhuesped, int estancia, Date fecharsv, String ingreso, String salida, Double costo) {
        this.idreserva = idreserva;
        this.idhab = idhab;
        this.idhuesped = idhuesped;
        this.estancia = estancia;
        this.fecharsv = fecharsv;
        this.ingreso = ingreso;
        this.salida = salida;
        this.costo = costo;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdhab() {
        return idhab;
    }

    public void setIdhab(int idhab) {
        this.idhab = idhab;
    }

    public int getIdhuesped() {
        return idhuesped;
    }

    public void setIdhuesped(int idhuesped) {
        this.idhuesped = idhuesped;
    }

    public int getEstancia() {
        return estancia;
    }

    public void setEstancia(int estancia) {
        this.estancia = estancia;
    }

    public Date getFecharsv() {
        return fecharsv;
    }

    public void setFecharsv(Date fecharsv) {
        this.fecharsv = fecharsv;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
    

   
    
    

   
    

    

    
}
