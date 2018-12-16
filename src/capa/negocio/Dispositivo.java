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
public class Dispositivo {
    String Tipo, Marca, Modelo, Nombre, DireccionIP;

    public Dispositivo(String Tipo, String Marca, String Modelo, String Nombre, String DireccionIP) {
        this.Tipo = Tipo;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Nombre = Nombre;
        this.DireccionIP = DireccionIP;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccionIP() {
        return DireccionIP;
    }

    public void setDireccionIP(String DireccionIP) {
        this.DireccionIP = DireccionIP;
    }

    
    
    
    
}
