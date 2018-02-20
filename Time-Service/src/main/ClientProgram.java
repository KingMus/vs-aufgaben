package main;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientProgram {

	public static void main(String[] args) throws UnknownHostException, IOException {

		System.out.println(TimeServiceClient.dateFromServer("127.0.0.1"));
		System.out.println(TimeServiceClient.timeFromServer("127.0.0.1"));
		
	}

}
