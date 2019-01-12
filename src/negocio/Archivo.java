
package negocio;


public class Archivo {
    private String Nombre, Extension;
    
    public Archivo(){
    }
    
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
