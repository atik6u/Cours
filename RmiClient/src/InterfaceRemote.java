import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemote extends Remote {
	
	public double convertir(double mt) throws RemoteException;
	
}
