package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TimeServiceClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		TimeServiceInterface timeServiceInterface = (TimeServiceInterface) Naming.lookup("rmi://127.0.0.1:8080/TS");

		timeServiceInterface.getDateAndTime();
	}

}
