package com.ericsson.training.problem01;


import com.ericsson.training.common.ConstantFile;
/**
 * This class for operations like produce,consume,getQuantity,setQuantity.
 * @author ezaksch
 * @see synchronized,wait,notify
 */
public class Fruit {
	String fruit;
	boolean available=false;
	int quantity;

	
	  
	/**
	 * To get value of quantity.
	 * @return int quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * To set value for quantity.
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * add fruit if available is false.
	 * @param fruit
	 * @throws Exception
	 */
	public synchronized void produce(String fruit) throws Exception {
		
		while(available) {
			wait();
		}
		this.fruit=fruit;
		System.out.println(fruit + ConstantFile.FRUIT_AVAILABLE);
		available=true;
		notify();
	}
	/**
	 * consume fruit if available is true.
	 * @throws Exception
	 */
	public synchronized void consume() throws Exception{
		while(!available) {
			wait();
		}
		System.out.println(fruit + ConstantFile.CONSUMED);
		this.fruit=null;
		available=false;
		notify();
	}
}
