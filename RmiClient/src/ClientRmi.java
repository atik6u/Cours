import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRmi {
	public static void main(String[] args) {
		try {
			// on a besion de l’interface ....
			// définition d’un stub ....
			InterfaceRemote stub = (InterfaceRemote)
			Naming.lookup("rmi://localhost:1099/Conversion");
			System.out.println(stub.convertir(11));
		} catch (Exception ex) {
			Logger.getLogger(ClientRmi.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
		
}
