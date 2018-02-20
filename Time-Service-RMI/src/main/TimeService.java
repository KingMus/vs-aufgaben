package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class TimeService extends UnicastRemoteObject implements TimeServiceInterface {

	protected TimeService() throws RemoteException {
	}

	public Date getDateAndTime() throws RemoteException {

		return null;

	}

}
