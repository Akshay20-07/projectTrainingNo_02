package com.ericsson.training.problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.ericsson.training.common.ConstantFile;

/**
 * To make a ServerSocket at port number 79 and to assist the client
 * 
 * @author ezaksch
 * @see ConstantFile,BufferedReader,IOException,InputStreamReader,OutputStream,PrintWriter,ServerSocket,Socket
 */
public class BeanServer {
	/**
	 * serverConnection method is for making a server at port number 79 and after connection using
	 * getMessage printing into the stream.Getting an input stream and publishing it
	 * to the client
	 * 
	 * @throws IOException
	 */
	public void serverConnection() throws IOException {
		Hello helloObject = new Hello();
		ServerSocket beanServerSocket = null;
		Socket socket = null;
		OutputStream outputStreamObject;
		PrintWriter print = null;
		BufferedReader bufferReader;
		String name = null;
		try {
			beanServerSocket = new ServerSocket(79);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(ConstantFile.CONNNECTED);
		while (true) {
			try {
				socket = beanServerSocket.accept();
				outputStreamObject = socket.getOutputStream();
				print = new PrintWriter(outputStreamObject, true);
				print.println(helloObject.getMessage());

				bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				name = bufferReader.readLine();
				
				print.println(helloObject.sayHello(name));
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				print.close();
				socket.close();

			}

			System.out.println(ConstantFile.REPLY + name);
		}

	}

	public static void main(String[] args) throws IOException {
		BeanServer beanServerObject = new BeanServer();
		beanServerObject.serverConnection();

	}

}
