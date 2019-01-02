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
    String Id, Nombre, IpPuertaEnlace,IpDestino ;

    public Red(String Id, String Nombre, String IpPuertaEnlace, String IpDestino) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.IpPuertaEnlace = IpPuertaEnlace;
        this.IpDestino = IpDestino;
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

    public String getIpPuertaEnlace() {
        return IpPuertaEnlace;
    }

    public void setIpPuertaEnlace(String IpPuertaEnlace) {
        this.IpPuertaEnlace = IpPuertaEnlace;
    }

    public String getIpDestino() {
        return IpDestino;
    }

    public void setIpDestino(String IpDestino) {
        this.IpDestino = IpDestino;
    }
    
}
