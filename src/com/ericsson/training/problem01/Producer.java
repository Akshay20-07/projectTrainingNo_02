package com.ericsson.training.problem01;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.training.common.ConstantFile;
/**
 * Producer is a thread class which is using produce method in run
 * @author ezaksch
 *
 */
public class Producer implements Runnable {
	Fruit fruit;
/**
 *for setting the value of fruit. 
 * @param fruit
 */
	Producer(Fruit fruit){
		this.fruit=fruit;
	}
/**
 * In thread execution it will add fruits to list,setQuantity and use synchronized produce method. 
 */
	public void run() {
		List<String> fruitList=new ArrayList<String>();
		fruitList.add(ConstantFile.APPLE);
		fruitList.add(ConstantFile.ORANGE);
		fruitList.add(ConstantFile.BANANA);
		fruitList.add(ConstantFile.BERRY);
		fruit.setQuantity(fruitList.size());
		for(String fruitObj :fruitList) {
			try {
				fruit.produce(fruitObj);
				Thread.sleep(1000);
				} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


}
