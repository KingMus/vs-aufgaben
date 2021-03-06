package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;

public class TimeService extends UnicastRemoteObject implements TimeServiceInterface {

	private Vector<Event> allEvents = new Vector<Event>();
	private Vector<EventListener> allEventListener = new Vector<EventListener>();

	protected TimeService() throws RemoteException {

	}

	public Date getDateAndTime() throws RemoteException {

		System.out.println("success");
		Date date = new Date();
		return date;

	}

	@Override
	public void addEvent(Event event) throws RemoteException {
		allEvents.addElement(event);
	}

	@Override
	public Vector<Event> getAllEvents() throws RemoteException {
		return allEvents;
	}

	@Override
	public Event getNextEvent() throws RemoteException {

		Date date = new Date();

		for (Event event : allEvents) {
			if (date.getTime() < event.getDate().getTime()) {
				return event;
			}
		}

		return null;
	}

	@Override
	public Vector<Event> getFutureEvents() throws RemoteException {

		Date date = new Date();
		Vector<Event> allFutureEvents = new Vector<Event>();

		for (Event event : allEvents) {
			if (date.getTime() < event.getDate().getTime()) {
				allFutureEvents.addElement(event);
			}
		}

		return allFutureEvents;
	}

	@Override
	public void addEventListener(EventListener eventListener) throws RemoteException {

		allEventListener.addElement(eventListener);

	}

	@Override
	public void removeEventListener(EventListener eventListener) throws RemoteException {

		allEventListener.remove(eventListener);

	}

	@Override
	public void startThread() throws RemoteException, InterruptedException {

		Thread thread = new Thread();
		thread.start();

		while (thread.isAlive()) {

			Date date = new Date();

			long timeTillNextEvent = allEvents.get(0).getDate().getTime() - date.getTime();
			allEvents.remove(0);
			
			System.out.println("Removed");

			Thread.sleep(timeTillNextEvent);

			System.out.println("Es ist 11:47");

		}

	}

}
