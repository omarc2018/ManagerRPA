/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 * @author Omar Castillo
 */
public class Main {
    public static void main(String[] args){
        
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario("admin");
        Usuario usuario3 = new Usuario("admin","789");
        
        System.out.println(usuario1.usuario);
        System.out.println(usuario1.getContraseña());
        
        usuario1.autenticar();
        
    }
}
