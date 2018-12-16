
package capa.negocio;

public class Usuario {
    public String usuario;
    public String contraseña;
    
    
  
    public Usuario(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
   }

        public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
