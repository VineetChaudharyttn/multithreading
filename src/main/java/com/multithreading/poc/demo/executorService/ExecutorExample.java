package com.multithreading.poc.demo.executorService;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

	public static void executorExample() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("We are able to use the trained neural network...");
			}
		});

		for(int i=0;i<5;++i)
			executorService.execute(new Worker(i+1, barrier));

		executorService.shutdown();
	}

}

class Worker implements Runnable {

	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;

	public Worker(int id, CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
		this.random = new Random();
		this.id = id;
	}

	@Override
	public void run() {
		doWork();
	}

	private void doWork() {
		System.out.println("Thread with ID " + id + " starts the task...");
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread with ID " + id + " finished...");

		try {
			cyclicBarrier.await();
			System.out.println("After await...");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public String toString() { return ""+this.id; };
}
