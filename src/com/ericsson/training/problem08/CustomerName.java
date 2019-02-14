package com.ericsson.training.problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CustomerName class is used to check the fields of the Name.
 * 
 * @author ezaksch
 *
 */
public class CustomerName {
	/**
	 * To check whether the name field is empty or not and throwss a
	 * NoNameEnteredException
	 * 
	 * @param name
	 * @return
	 * @throws NoNameEnteredException
	 */
	public String checkName(String name) throws NoNameEnteredException {

		if ("".equals(name)) {
			throw new NoNameEnteredException("Name is empty!");
		}

		return name;

	}

	/**
	 * To Enter the name from console and check for its Exception
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		CustomerName obj = new CustomerName();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = reader.readLine().trim();
			obj.checkName(input);
			System.out.println(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
