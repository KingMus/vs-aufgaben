package main;

import java.io.IOException;
import java.net.ServerSocket;

public class TimeService extends Thread {

	private IOFactory ioFactory;

	public TimeService(ServerSocket serverSocket) throws IOException {

		ioFactory = new IOFactory(serverSocket);
	}

	public void run() {
		String userInput = "";
		try {
			do {
				switch (userInput) {
				case "date":
					ioFactory.getWriter().write(Clock.date());
					break;
				case "time":
					ioFactory.getWriter().write(Clock.time());
					break;
				default:
					userInput = "exit";
					break;
				}
				ioFactory.getWriter().newLine();
				ioFactory.getWriter().flush();
				userInput = ioFactory.getReader().readLine();
			} while (!(userInput == null || userInput.equals("exit")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
