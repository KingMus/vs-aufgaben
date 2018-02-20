package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeServiceClient {

	public static String dateFromServer(String ip) throws UnknownHostException, IOException {

		Socket socket = new Socket(ip, 8080);
		OutputStream output = socket.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
		InputStream input = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		reader.readLine();
		writer.write("date");
		writer.newLine();
		writer.flush();
		String ausgabe = reader.readLine();
		System.out.println(ausgabe);
		return ausgabe;

	}

	public static String timeFromServer(String ip) throws UnknownHostException, IOException {

		Socket socket = new Socket(ip, 8080);
		OutputStream output = socket.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
		InputStream input = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		reader.readLine();
		writer.write("time");
		writer.newLine();
		writer.flush();
		String ausgabe = reader.readLine();
		System.out.println(ausgabe);
		return ausgabe;

	}

}
