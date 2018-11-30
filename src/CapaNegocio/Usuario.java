
package CapaNegocio;

public class Usuario {
    public String usuario;
    private String contraseña;
    
    
   public Usuario(){
    this.usuario = "";
    this.contraseña = "";
   }
   
   public Usuario(String usuario){
    this.usuario = usuario;
    this.contraseña = "";
   }
   
   public Usuario(String usuario, String contraseña){
    this.usuario = usuario;
    this.contraseña = contraseña;
   }
    
    void asignarAtributos(String usuario, String contraseña){
    this.usuario = usuario;
    this.contraseña = contraseña;
}
    
    
    void autenticar(){
        System.out.println("El usuario se esta autenticando");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
