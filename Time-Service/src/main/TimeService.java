package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService extends Thread {

	private OutputStream output;
	private BufferedWriter writer;
	private InputStream input;
	private BufferedReader reader;
	private Socket socket;

	public TimeService(ServerSocket serverSocket) throws IOException {
		socket = serverSocket.accept();
		output = socket.getOutputStream();
		writer = new BufferedWriter(new OutputStreamWriter(output));
		input = socket.getInputStream();
		reader = new BufferedReader(new InputStreamReader(input));
	}

	public void run() {
		String eingabe = "";
		try {
			do {
				switch (eingabe) {
				case "date":
					writer.write(Clock.date());
					break;
				case "time":
					writer.write(Clock.time());
					break;
				default:
					eingabe = "exit";
					break;
				}
				writer.newLine();
				writer.flush();
				eingabe = reader.readLine();
			} while (!(eingabe == null || eingabe.equals("exit")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
