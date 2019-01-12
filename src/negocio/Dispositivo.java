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
public class Dispositivo {
    private String NombreDispositivo, Tipo, Marca, Modelo, NumeroSerie, IpDispositivo, NombreArchivo;
    
    public Dispositivo(){
    }
    
    public Dispositivo(String NombreDispositivo, String Tipo, String Marca, String Modelo, String NumeroSerie, String IpDispositivo, String Archivo, String NombreArchivo) {
        this.NombreDispositivo = NombreDispositivo;
        this.Tipo = Tipo;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.NumeroSerie = NumeroSerie;
        this.IpDispositivo = IpDispositivo;
        this.NombreArchivo = NombreArchivo;
    }

    public String getNombreDispositivo() {
        return NombreDispositivo;
    }

    public void setNombreDispositivo(String NombreDispositivo) {
        this.NombreDispositivo = NombreDispositivo;
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

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String NumeroSerie) {
        this.NumeroSerie = NumeroSerie;
    }

    public String getIpDispositivo() {
        return IpDispositivo;
    }

    public void setDireccionIP(String IpDispositivo) {
        this.IpDispositivo = IpDispositivo;
    }

    public String getNombreArchivo() {
        return NombreArchivo;
    }

    public void setNombreArchivo(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
    }

       
    
    
}
