package main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface TimeServiceInterface extends Remote {

	public abstract Date getDateAndTime() throws RemoteException;

}
