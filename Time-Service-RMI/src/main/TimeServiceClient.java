package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class TimeServiceClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		TimeServiceInterface timeServiceInterface = (TimeServiceInterface) Naming.lookup("rmi://127.0.0.1:8080/TS");

		Date date = timeServiceInterface.getDateAndTime();

		System.out.println(date.toString());
		
		timeServiceInterface.addEvent(new Event(date, "wow"));
		
		System.out.println(timeServiceInterface.getAllEvents().get(0).getEventName());
		
		

	}

}
