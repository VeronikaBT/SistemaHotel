
package Modelo;

/**
 *
 * @author Leonardo
 */
public class habitacion {
    
    private int idhabitacion;
    private String numero;
    private String piso;
    private String descripcion;
    private Double preciodiario;
    private String estado;
    private String tipohabitacion;

    public habitacion(int idhabitacion, String numero, String piso, String descripcion, Double preciodiario, String estado, String tipohabitacion) {
        this.idhabitacion = idhabitacion;
        this.numero = numero;
        this.piso = piso;
        this.descripcion = descripcion;
        this.preciodiario = preciodiario;
        this.estado = estado;
        this.tipohabitacion = tipohabitacion;
    }

    public habitacion() {
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPreciodiario() {
        return preciodiario;
    }

    public void setPreciodiario(Double preciodiario) {
        this.preciodiario = preciodiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }
    
    
    
    
    
    
}
