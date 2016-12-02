
package ejbclient;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import myejb.I_RemoteEjb;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Verifique que incluyó en Libraries el jar: gf-client.jar
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");            
            //Si el servidor corre en localhost, entonces esta línea no es necesaria
            props.setProperty("org.omg.CORBA.ORBInitialHost", "werwerwer");
            //Si se usa el puerto 3700(puerto por defecto del ORB),
            //entonces la siguiente línea no es necesaria
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            // El nombre: "java:global/Saludo" es definido en la clase que implementa la interfaz
            I_RemoteEjb stub = (I_RemoteEjb) new InitialContext(props).lookup("java:global/Saludo");
            System.out.println(stub.hola("Diego"));
        } catch (NamingException ex) {
            System.out.println(ex.getExplanation());
        }
    }
    
}
