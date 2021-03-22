package com.dhatric.threads;

class Employee {

    // shared variable
    private String name;

    // method is synchronize on 'this' object
    public synchronized void setName(String name) {
        
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.name = name;
		System.out.println("In setName "+this.name);
    }

    // also synchronized on the same object
    public  void resetName() {
        this.name = "";
        System.out.println("In reset "+this.name);
    }

    // equivalent of adding synchronized in method
    // definition
    public String getName() {
        synchronized (this) {
            return this.name;
        }
    }
}