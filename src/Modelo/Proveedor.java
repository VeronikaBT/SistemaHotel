
package Modelo;

/**
 *
 * @author Sandro
 */
public class Proveedor extends persona{
    private String razon;
    private String suministro;

    public Proveedor() {
    }

    public Proveedor(String razon, String suministro) {
        this.razon = razon;
        this.suministro = suministro;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getSuministro() {
        return suministro;
    }

    public void setSuministro(String suministro) {
        this.suministro = suministro;
    }
    
    
}
