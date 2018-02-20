package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;

public class TimeService extends UnicastRemoteObject implements TimeServiceInterface {

	protected TimeService() throws RemoteException {
	}

	public Date getDateAndTime() throws RemoteException {

		System.out.println("success");

		Date date = new Date();

		return date;

	}

	@Override
	public void addEvent(Event event) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Event> getAllEvents() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getNextEvent() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Event> getFutureEvents() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
