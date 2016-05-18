package myejb;

import javax.ejb.Remote;
/**
 *
 * @author dordonez@ute.edu.ec
 */

// En el cliente hay dos alternativas:
// 1) se quita la anotación: @Remote, así como el: import javax.ejb.Remote; ó
// 2) se incluye la librería: Java EE 7 API Library
@Remote
public interface I_RemoteEjb {
    public String hola(String nombre);
}
