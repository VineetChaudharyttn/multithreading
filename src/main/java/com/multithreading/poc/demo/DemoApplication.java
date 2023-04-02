package com.multithreading.poc.demo;

import com.multithreading.poc.demo.executorService.ExecutorExample;
import com.multithreading.poc.demo.forkJoin.ForkJoinExample;
import com.multithreading.poc.demo.futurePromise.FutureExample;
import com.multithreading.poc.demo.semaphores.SemaphoreExample;
import com.multithreading.poc.demo.waitNotify.WaitNotifyExample;

public class DemoApplication {

	public static void main(String[] args) {
		ExecutorExample.executorExample();
		ForkJoinExample.forkJoinExample();
		FutureExample.futureExample();
		SemaphoreExample.semaphoreExample();
		WaitNotifyExample.waitNotifyExample();
	}

}
