package com.ericsson.training.problem01;
/**
 * Consumer is a thread class which is using consume method in run
 * @author ezaksch
 *
 */
public class Consumer implements Runnable{
  Fruit fruit;
 /**
  * for setting the value of fruit.
  * @param fruit
  */
  Consumer (Fruit fruit){
	  this.fruit=fruit;
  }
/**
 * To use synchronized consume method in thread
 */
	public void run() {
		int i=0;
		while(!(i==fruit.getQuantity())){
			try {
				fruit.consume();
				Thread.sleep(1000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			i++;
		}
		
	}
	

}
