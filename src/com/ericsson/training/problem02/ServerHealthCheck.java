package com.ericsson.training.problem02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ericsson.training.common.ConstantFile;
/**
 * Check the server's health check it periodically using ExecutorService framework
 * @author ezaksch
 * @see Executors,ScheduledExecutorService,TimeUnit
 *
 */
public class ServerHealthCheck {
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

		Runnable worker = new CheckConnection(ConstantFile.SERVER);
		executor.execute(worker);

		executor.scheduleAtFixedRate(worker, 5, 5, TimeUnit.SECONDS);
		if( executor.isShutdown()==true) {
		System.out.println(ConstantFile.SHUTDOWN);
		}
	}
}