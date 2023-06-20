package Modelo;


public class Consumo {
    private int idconsumo;
    private int idreserva;
    private int idproducto;
    private int cant;
    private double pv;
    private String estado;

    public Consumo() {
    }

    public Consumo(int idconsumo, int idreserva, int idproducto, int cant, double pv, String estado) {
        this.idconsumo = idconsumo;
        this.idreserva = idreserva;
        this.idproducto = idproducto;
        this.cant = cant;
        this.pv = pv;
        this.estado = estado;
    }

    public int getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(int idconsumo) {
        this.idconsumo = idconsumo;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPv() {
        return pv;
    }

    public void setPv(double pv) {
        this.pv = pv;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
