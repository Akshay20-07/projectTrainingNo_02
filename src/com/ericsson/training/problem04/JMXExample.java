package com.ericsson.training.problem04;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.net.Socket;

import javax.management.*;

import com.ericsson.training.common.ConstantFile;

/**
 * Connecting the client with the server at port number 79 and retrives the detail using JMX.
 * 
 * @author ezaksch
 * @see Socket,ConstantFile,PrintWriter,
 */
public class JMXExample {

	/**
	 * for enabling MBean by creating a platform for MBeanServer and registering the
	 * Mbean into the MBeanServer.
	 */
	private void enableMBean() {
		MBeanServer mbeanServer = null;
		mbeanServer = ManagementFactory.getPlatformMBeanServer();
		Hello helloBean = new Hello();
		try {

			ObjectName helloName = new ObjectName(ConstantFile.OBJECTNAME);
			mbeanServer.registerMBean(helloBean, helloName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * It will create a stream socket and connect to the localHost portnumber 79.
	 * Get an inputstream and publish it to the client and then take an input from
	 * console and print it into the stream.
	 * 
	 * @throws Exception
	 */
	private void beanClient() throws Exception {
		final int portNumber = 79;
		System.out.println(ConstantFile.HOST + portNumber);
		Socket socket;
		BufferedReader bufferReader, userInputBR;
		String userInput;
		PrintWriter print;
		while (true) {
			socket = new Socket(ConstantFile.HOST, portNumber);
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(ConstantFile.SERVER_SAY + bufferReader.readLine());

			userInputBR = new BufferedReader(new InputStreamReader(System.in));
			userInput = userInputBR.readLine();
			
			print = new PrintWriter(socket.getOutputStream(), true);
			print.println(userInput);

			System.out.println(ConstantFile.SERVER_SAYS + bufferReader.readLine());

			if ("exit".equalsIgnoreCase(userInput)) {
				socket.close();
				break;
			}
		}
	}

	public static void main(String argv[]) throws Exception {
		JMXExample agent = new JMXExample();
		agent.enableMBean();
		agent.beanClient();
	}
}
