package CapaDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;



public class ManagerRPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Properties oPropiedades = new Properties();
        
        InputStream isArchivo;
        
        try {
            isArchivo = new FileInputStream("D:\\Documents\\NetBeansProjects\\ManagerRPA\\src\\CapaDatos\\Configuracion.properties");
            oPropiedades.load(isArchivo);
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        System.out.println("Propiedades");
        
        for (Enumeration e = oPropiedades.keys(); e.hasMoreElements(); ){
            Object obj = e.nextElement();
            System.out.print(obj + "; " + oPropiedades.getProperty(obj.toString()));
        }
        oPropiedades.setProperty("CodigoPC", "DESKTOP-3TGV4KL");
        oPropiedades.setProperty("SubestacionRed", "SESOC");
        oPropiedades.setProperty("NivelTension", "138");
        oPropiedades.setProperty("DispositivoLinea", "L-1022");
        oPropiedades.setProperty("NombreArchivo", value("SubestacionRed")+"__"+value("DispositivoLinea")+"__"+value("NivelTension"));
        oPropiedades.setProperty("IP", "10.122.11.402");
        oPropiedades.remove("IED");
        
        try{
            oPropiedades.store(new FileWriter("D:\\Documents\\NetBeansProjects\\ManagerRPA\\src\\CapaDatos\\Configuracion.properties"), "Se actualizó la configuración");
        }
        catch (IOException ex){
            Logger.getLogger(ManagerRPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
