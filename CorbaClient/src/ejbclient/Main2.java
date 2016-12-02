
package ejbclient;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import myejb.I_RemoteEjb;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main2 {

    public static void main(String[] args) {
        try {
            System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");    
            System.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.203.2");
            System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext();
            System.out.println(ctx.getEnvironment());
            // El nombre: "java:global/Saludo" es definido en la clase que implementa la interfaz
            I_RemoteEjb stub = (I_RemoteEjb) ctx.lookup("java:global/CorbaServer/Saludo");
            System.out.println(stub.hola("Diego"));
        } catch (NamingException ex) {
            System.out.println(ex.getExplanation());
        }
    }
    
}
