
package negocio;

public class Usuario {
    private String usuario;
    private int contrasenia;
    
    public Usuario(){
    }
  
    public Usuario(String usuario, int contrasenia){
        this.usuario = usuario;
        this.contrasenia = contrasenia;
   }

        public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
