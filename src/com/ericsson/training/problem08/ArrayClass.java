package com.ericsson.training.problem08;

import java.util.ArrayList;
import java.util.List;
/**
 * ArrayClass is used for implementing List<String> whose size should not be greater than 40
 * @author ezaksch
 * @see ArrayBoundException
 */
public class ArrayClass {
/**
 * To check the size of a List and thorw an ArrayBoundException 
 * @param dataList
 */
	public void check(List<String> dataList) {
		if(dataList.size() >=40) {
			throw new ArrayBoundException("User had crosssed the limits");
		}
	}
/**
 * To check the size of a List<String>
 * @param args
 */
	public static void main(String[] args) {
		List<String> dataList=new ArrayList<String>(30);
		ArrayClass arrayClassObject=new ArrayClass();
		arrayClassObject.check(dataList);

	}

}
