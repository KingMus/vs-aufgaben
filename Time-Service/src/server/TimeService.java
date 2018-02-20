package server;

import java.io.IOException;
import java.net.ServerSocket;

import tools.Clock;
import tools.IOController;

public class TimeService extends Thread {

	private IOController ioController;

	public TimeService(ServerSocket serverSocket) throws IOException {

		ioController = new IOController(serverSocket);
	}

	public void run() {
		String userInput = "";
		try {
			do {
				switch (userInput) {
				case "date":
					ioController.getWriter().write(Clock.date());
					break;
				case "time":
					ioController.getWriter().write(Clock.time());
					break;
				default:
					userInput = "exit";
					break;
				}
				ioController.getWriter().newLine();
				ioController.getWriter().flush();
				userInput = ioController.getReader().readLine();
			} while (!(userInput == null || userInput.equals("exit")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
