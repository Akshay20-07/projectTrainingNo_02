package com.ericsson.training.problem04;

import com.ericsson.training.common.ConstantFile;
/**
 * Hello class implementing HelloMBean and defining the methods of HelloMbean
 * @author ezaksch
 * @see ConstantFile
 */
public class Hello implements HelloMBean {
	String message;
	/**
	 * setting the value of message as "Who are you?"
	 */
	Hello(){
		message=ConstantFile.MESSAGE;
	}
	
	/**
	 *  the value of message as userdefined string
	 * @param message
	 */
	Hello(String message){
		this.message=message;
	}
	
	@Override
	public void setMessage(String message) {
		this.message=message;
		
	}

	@Override
	public String getMessage() {

		return message;
	}

	@Override
	public String sayHello(String name) {
		String sayhello=ConstantFile.HELLO+name;
		return sayhello;
		
	}
	@Override
	public void sayHi() {
		System.out.println(message);
		
	}
	

}
