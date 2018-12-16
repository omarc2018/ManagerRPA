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
public class Subestacion {
    String Nombre, NivelTensión, Celda;

    public Subestacion(String Nombre, String NivelTensión, String Celda) {
        this.Nombre = Nombre;
        this.NivelTensión = NivelTensión;
        this.Celda = Celda;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNivelTensión() {
        return NivelTensión;
    }

    public void setNivelTensión(String NivelTensión) {
        this.NivelTensión = NivelTensión;
    }

    public String getCelda() {
        return Celda;
    }

    public void setCelda(String Celda) {
        this.Celda = Celda;
    }
    
    
}
