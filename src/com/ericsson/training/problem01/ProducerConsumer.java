package com.ericsson.training.problem01;



/**
 * for implementing producer consumer concept
 * @author ezaksch
 *
 */
public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		Fruit fruits=new Fruit();
		Consumer consumer=new Consumer(fruits);
		Producer producer=new Producer(fruits);
		Thread threadProducer=new Thread(producer);
		Thread threadConsumer=new Thread(consumer);
		threadProducer.start();
		threadConsumer.start();
		
	}

}
