package main;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerProgram {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(8080);
		
		while (true) {
			TimeService timeService = new TimeService(serverSocket);
			timeService.start();
		}
	}

}
