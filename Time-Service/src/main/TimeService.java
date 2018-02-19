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
import java.net.UnknownHostException;

public class TimeService {

	public static void main(String[] args) {
		// TODO Aufgabe umsetzen

		try {
			ServerSocket ssocket = new ServerSocket(8080);
			Socket socket = ssocket.accept();//new Socket("127.0.0.1", 75);

			OutputStream output = socket.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			writer.write("time service \n");
			writer.flush();

			while (!socket.isClosed()) {
			
				String eingabe = reader.readLine();

				if (eingabe == null) {
					socket.close();
				} else {
					switch (eingabe) {
					case "date":
						writer.write(Clock.date());
						writer.newLine();
						writer.flush();
						break;
					case "time":
						writer.write(Clock.time());
						writer.newLine();
						writer.flush();
						break;
					default:
						socket.close();
						break;
					}
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
