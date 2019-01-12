
package negocio;

/**
 *
 * @author Omar Castillo
 */
public class Red {
    private String Id, Nombre, IpPuertaEnlace,IpDestino ;

    public Red(){
    }
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
