
package capa.datos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ArchivoPropiedades {
    String barra = File.separator;
    String directorio = System.getProperty("user.dir")+barra+"src"+barra+"capa"+barra+"datos"+barra+"propiedades"+barra;
    
    public void crearArchivo(){
        Properties propiedades = new Properties();
        OutputStream salida = null;
        try {
            salida = new FileOutputStream(directorio+"TipoDispositivo.properties");
            propiedades.store(salida, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
        finally{
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
