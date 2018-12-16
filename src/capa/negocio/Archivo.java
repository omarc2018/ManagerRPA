/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.negocio;

/**
 *
 * @author Omar Castillo
 */
public class Archivo {
    String Nombre, Extension;

    public Archivo(String Nombre, String Extension) {
        this.Nombre = Nombre;
        this.Extension = Extension;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String Extension) {
        this.Extension = Extension;
    }
    
    
}
