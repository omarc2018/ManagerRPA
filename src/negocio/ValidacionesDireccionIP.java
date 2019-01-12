package negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidacionesDireccionIP {
    private static Pattern PatronIP;
    private static Matcher EmparejadorIP;
    
    private static final String PATRON_DIRECCIONES_IP =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-4])\\."+
            "([01]?\\d\\d?|2[0-4]\\d|25[0-4])\\."+
            "([01]?\\d\\d?|2[0-4]\\d|25[0-4])\\."+
            "([01]?\\d\\d?|2[0-4]\\d|25[0-4])$";
    
    public static void main(String[] args) {
        String[] listaIP = {"3322.33.8922","a.b.c.d","10.122.11.56","$.#.m.%","192.168.1.2"};
        PatronIP = Pattern.compile(PATRON_DIRECCIONES_IP);
        for (String direccionIP : listaIP) {
            System.out.println(direccionIP + validarDirecionIP(direccionIP));
        }
    }
    
    
    public static String validarDirecionIP(final  String direccionIP){
        EmparejadorIP = PatronIP.matcher(direccionIP);
        if(EmparejadorIP.matches()){
        
            return  " Dirección IP Valida";
        }
        return " DirecciónIP Invalida";
    }
}
