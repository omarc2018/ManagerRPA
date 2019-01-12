/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Omar Castillo
 */
public class Subestacion {
    private String Nombre, NivelTensión;
    
    public Subestacion(){
    }

    public Subestacion(String Nombre, String NivelTensión, String Celda) {
        this.Nombre = Nombre;
        this.NivelTensión = NivelTensión;
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
}
