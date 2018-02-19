package main;

import java.io.IOException;
import java.net.UnknownHostException;

public class Program {

	public static void main(String[] args) throws UnknownHostException, IOException {

		TimeServiceClient timeServiceClient = new TimeServiceClient();

		System.out.println(timeServiceClient.dateFromServer("127.0.0.1"));
		
	}

}
