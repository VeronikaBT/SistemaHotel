/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Leonardo
 */
public class usuario extends persona {
    
    private Double sueldo;
    private String Cargo;
    private String user;
    private String contra;

    public usuario() {
    }

    public usuario(Double sueldo, String Cargo, String user, String contra) {
        this.sueldo = sueldo;
        this.Cargo = Cargo;
        this.user = user;
        this.contra = contra;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
    
    
    
    
    
     
    
}
