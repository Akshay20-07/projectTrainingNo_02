package com.ericsson.training.problem04;
/**
 * creating a MBean named as HelloMBean having setMessage,getMessage,sayHello,sayHi
 * @author ezaksch
 *
 */
public interface HelloMBean {
	/**
	 * setting the value of message as userdefined string
	 * @param message
	 */
	public void setMessage(String message);
	/**
	 * getting the value of message 
	 * @return message
	 */
	public String getMessage();
	/**
	 * To publish the hello statement to user
	 * @param name
	 * @return String
	 */
	public String sayHello(String name);
	/**
	 * just to say hi
	 */
	public void sayHi();

}
