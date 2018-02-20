package main;

import java.io.IOException;
import java.net.UnknownHostException;

public class TimeServiceClient {

	public static String dateFromServer(String ip) throws UnknownHostException, IOException {
		return interactWithOrder(ip, "date");
	}

	public static String timeFromServer(String ip) throws UnknownHostException, IOException {
		return interactWithOrder(ip, "time");
	}

	private static String interactWithOrder(String ip, String order) throws IOException {

		IOFactory ioFactory = new IOFactory(ip);

		ioFactory.getReader().readLine();
		ioFactory.getWriter().write(order);
		ioFactory.getWriter().newLine();
		ioFactory.getWriter().flush();
		String ausgabe = ioFactory.getReader().readLine();
		System.out.println(ausgabe);
		return ausgabe;
	}
}
