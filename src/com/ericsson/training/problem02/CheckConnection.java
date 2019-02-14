package com.ericsson.training.problem02;

import java.io.IOException;
import java.net.Socket;

import com.ericsson.training.common.ConstantFile;

/**
 * to check the whether the whether there is a connection between the socket and
 * port.
 * 
 * @author ezaksch
 * @see Socket
 */

class CheckConnection implements Runnable {
	private String message;

	/**
	 * for setting up a messsage.
	 * 
	 * @param message
	 */
	public CheckConnection(String message) {
		this.message = message;
	}

	public void run() {
		establishConnection();
	}

	/**
	 * to check whether there is a connection between the port and the socket .
	 */
	private synchronized void establishConnection() {
		Socket socketObject = null;
		try {
			socketObject = new Socket(ConstantFile.GOOGLE, 80);

			if (socketObject.isConnected() == true) {

				System.out.println(ConstantFile.CONNNECTED + message);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				socketObject.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}

	}
}
