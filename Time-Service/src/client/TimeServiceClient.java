package client;

import java.io.IOException;
import java.net.UnknownHostException;

import tools.IOController;

public class TimeServiceClient {

	public static String dateFromServer(String ip) throws UnknownHostException, IOException {
		return interactWithOrder(ip, "date");
	}

	public static String timeFromServer(String ip) throws UnknownHostException, IOException {
		return interactWithOrder(ip, "time");
	}

	private static String interactWithOrder(String ip, String order) throws IOException {

		IOController ioController = new IOController(ip);

		ioController.getReader().readLine();
		ioController.getWriter().write(order);
		ioController.getWriter().newLine();
		ioController.getWriter().flush();

		String ausgabe = ioController.getReader().readLine();
		return ausgabe;
	}
}
