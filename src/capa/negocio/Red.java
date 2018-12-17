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
public class Red {
    String Id, Nombre, Segmento,DirDestino ;

    public Red(String Id, String Nombre, String Segmento, String DirDestino) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Segmento = Segmento;
        this.DirDestino = DirDestino;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSegmento() {
        return Segmento;
    }

    public void setSegmento(String Segmento) {
        this.Segmento = Segmento;
    }

    public String getDirDestino() {
        return DirDestino;
    }

    public void setDirDestino(String DirDestino) {
        this.DirDestino = DirDestino;
    }
    
}
