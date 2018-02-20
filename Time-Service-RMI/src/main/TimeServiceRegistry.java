package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TimeServiceRegistry {

	public static void main(String[] args) throws Exception {

		Registry registry = LocateRegistry.createRegistry(8080);
		TimeService timeService = new TimeService();
		registry.bind("TS", timeService);
		System.out.println("RMI started on port 8080");

	}

}
