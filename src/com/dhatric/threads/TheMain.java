package com.dhatric.threads;

public class TheMain {

	public static void main(String[] args) throws InterruptedException {
		Employee e = new Employee();
		e.setName("Hello");
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				e.setName("Thread1111111111111");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				e.resetName();
			}
		});

		t1.start();
		Thread.sleep(100);
		t2.start();
		t1.join();
		t2.join();

	}

}
