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

public class IOFactory {

	private OutputStream output;
	private BufferedWriter writer;
	private InputStream input;
	private BufferedReader reader;
	private Socket socket;

	public IOFactory(ServerSocket serverSocket) throws IOException {
		socket = serverSocket.accept();
		initalizeIO();

	}

	public IOFactory(String ip) throws IOException {
		socket = new Socket(ip, 8080);
		initalizeIO();

	}

	private void initalizeIO() throws IOException {
		output = socket.getOutputStream();
		writer = new BufferedWriter(new OutputStreamWriter(output));
		input = socket.getInputStream();
		reader = new BufferedReader(new InputStreamReader(input));
	}

	public BufferedWriter getWriter() {
		return writer;
	}

	public BufferedReader getReader() {
		return reader;
	}

}