package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ManagerRPA {

     
    
    
    
    public static void main(String[] args){
        Properties oPropiedades = new Properties();
        ArchivoPropiedades creaArchivo = new ArchivoPropiedades();
        creaArchivo.crearArchivo();
        InputStream isArchivo;
        
        try {
            isArchivo = new FileInputStream("D:\\Documents\\NetBeansProjects\\ManagerRPA\\src\\CapaDatos\\RPA.properties");
            oPropiedades.load(isArchivo);
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        
        for (Enumeration e = oPropiedades.keys(); e.hasMoreElements(); ){
            Object obj = e.nextElement();
            System.out.print(obj + "; " + oPropiedades.getProperty(obj.toString()));
        }
        oPropiedades.setProperty("CodigoPC", "DESKTOP-3TGV4KL");
        oPropiedades.setProperty("SubestacionRed", "SESOC");
        oPropiedades.setProperty("NivelTension", "138");
        oPropiedades.setProperty("DispositivoLinea", "L-1022");
        oPropiedades.setProperty("NombreArchivo", ".csv");
        oPropiedades.setProperty("IP", "10.122.11.402");
        
        try{
            oPropiedades.store(new FileWriter("D:\\Documents\\NetBeansProjects\\ManagerRPA\\src\\Capa\\Datos\\RPA.properties"), "Se actualizó la configuración");
        }
        catch (IOException ex){
            Logger.getLogger(ManagerRPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
