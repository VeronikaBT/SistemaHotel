/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Leonardo
 */
public class persona {
    private int  idper;
    private String nom;
    private String apep;
    private String apem;
    private String tdoc;
    private String ndoc;
    private String dir;
    private String cel;

    public persona(int idper, String nom, String apep, String apem, String tdoc, String ndoc, String dir, String cel) {
        this.idper = idper;
        this.nom = nom;
        this.apep = apep;
        this.apem = apem;
        this.tdoc = tdoc;
        this.ndoc = ndoc;
        this.dir = dir;
        this.cel = cel;
    }

    public persona() {
    }
    
    
    public int getIdper() {
        return idper;
    }

    public void setIdper(int idper) {
        this.idper = idper;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApep() {
        return apep;
    }

    public void setApep(String apep) {
        this.apep = apep;
    }
    
    public String getApem() {
        return apem;
    }

    public void setApem(String apem) {
        this.apem = apem;
    }

    public String getTdoc() {
        return tdoc;
    }

    public void setTdoc(String tdoc) {
        this.tdoc = tdoc;
    }

    public String getNdoc() {
        return ndoc;
    }

    public void setNdoc(String ndoc) {
        this.ndoc = ndoc;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
    
    
    
}
