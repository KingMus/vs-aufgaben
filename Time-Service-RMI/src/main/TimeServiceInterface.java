package main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

public interface TimeServiceInterface extends Remote {

	public abstract Date getDateAndTime() throws RemoteException;

	public abstract void addEvent(Event event) throws RemoteException;

	public abstract Vector<Event> getAllEvents() throws RemoteException;

	public abstract Event getNextEvent() throws RemoteException;

	public abstract Vector<Event> getFutureEvents() throws RemoteException;

	public abstract void addEventListener(EventListener eventListener) throws RemoteException;

	public abstract void removeEventListener(EventListener eventListener) throws RemoteException;

}
