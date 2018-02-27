package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class TimeServiceClient {

	public static void main(String[] args)
			throws MalformedURLException, RemoteException, NotBoundException, InterruptedException {
		TimeServiceInterface timeServiceInterface = (TimeServiceInterface) Naming.lookup("rmi://127.0.0.1:8080/TS");

		Date date = timeServiceInterface.getDateAndTime();

		System.out.println(date.toString());

		timeServiceInterface.addEvent(new Event(new Date(2018, 02, 27, 12, 00), "wow"));

		System.out.println("added");
		timeServiceInterface.startThread();
		System.out.println("started");
	}

}
