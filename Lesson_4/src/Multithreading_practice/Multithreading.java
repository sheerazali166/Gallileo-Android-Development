package Multithreading_practice;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Multithreading {

	public static void main(String[] args) {
		
		Scanner inputReader = new Scanner(System.in);
		String userinput;
		
		Chef chef = new Chef();
		Entry comingcustomer = new Entry();
		Attender attender1 = new Attender(1);
		Attender attender2 = new Attender(2);
		
		chef.start();
		comingcustomer.start();
		attender1.start();
		attender2.start();
		
		//Stop with any key, except just Enter
		while (true) {
			
			userinput = inputReader.next();
			chef.end();
			comingcustomer.end();
			attender1.end();
			attender2.end();
			System.exit(0);

			
		}
		
	}

}


final class FoodStock {
	
	private static int burger, sandwitch, salad;
	
	private FoodStock() {;}
	
	public static synchronized boolean cooksellburger(String action) {
		
		if (action.equals("cook")) {
			
			burger++;
			return true;
		
		} else if (action.equals("sell")) {
			
			if(burger > 0) {
				
				burger--;
				return true;
			}
			
		}
		
		return false;
	} 
	
	public static synchronized boolean cooksellsandwitch(String action) {
		
		if (action.equals("cook")) {
			
			sandwitch++;
			return true;
		
		} else if(action.equals("sell")){
			
			if (sandwitch > 0) {
				
				sandwitch--;
				return true;
			}
		}
		
		return false;
	}
	
	public static synchronized boolean cooksellsalad(String action) {
	
		if(action.equals("cook")) {
			
			salad++;
			return true;
		
		} else if (action.equals("sell")){
			
			salad++;
			
			if (salad > 0) {
				salad--;
				return true;
			}
			
		}
		
		return false;
	}
	
	public String toString() {
		
		return "\nFood Stock burger: " + burger + " sandwitch: " + sandwitch + " salad: " + salad;
	}
}

final class CustomerQueues {
	
	private static LinkedList<Customer> customerQueue1 = new LinkedList<Customer>();
	
	private static LinkedList<Customer> customerQueue2 = new LinkedList<Customer>();
	
	private CustomerQueues() {;}
	
	public static void enterCustomer(int queue, Customer customer) {
		
		if (queue == 0) 
			customerQueue1.addLast(customer);
		else
			customerQueue2.addLast(customer);
	} 
	
	public static Customer attendCustomer(int queue) {
		
		if (queue == 0) {
			
			if (customerQueue1.size() > 0)
				return customerQueue1.removeFirst();
				
			return null;
		}
		
		if (customerQueue2.size() > 0)
			return customerQueue2.removeLast();
		return null;
		
	}
	
	public String toString() {
		
		return "\tQueue 1: " + customerQueue1 +
				"\n\tQueue 2: " + customerQueue2;
	}
	
}

class Customer {
	
	public int id, timetodecide;
	public String desiredFood;
	

	public Customer(int id, int timetodecide, String desiredFood) {
		
		this.id = id;
		this.timetodecide = timetodecide;
		this.desiredFood = desiredFood;
		
	}


	public String toString() {
		
		return "Customer #" + this.id;
	}
}

class Chef extends Thread {
	
	Random randomgenerator = new Random();
	private boolean threadalive = true;
	
	public Chef() {;}
	
	public void run() {
		
		int timetocook = 0, wichfood = 0;
		
		while(this.threadalive) {
			
			timetocook = 2000 + 1000*randomgenerator.nextInt(3); 
			
			try {
				
				this.sleep(timetocook);
				
				wichfood = randomgenerator.nextInt(3);
				
				System.out.println("Chef on " + (timetocook/1000) + " seconds Cook a");
				
				switch(wichfood) {
				
					case 0:
						FoodStock.cooksellburger("cook");
						System.out.println("burger");
						break;
					case 1:
						FoodStock.cooksellsandwitch("sell");
						System.out.println("sandwich");
						break;
					case 2:
						FoodStock.cooksellsalad("cook");
						System.out.println("salad");
						break;
						
				}
				
			} catch (InterruptedException e) {
				
				System.out.println("Chef Interrupted");
			}
		
		}
	}
	
	public void end() {
		
		this.threadalive = false;
	}
} 

class Entry extends Thread {
	
	Random randomgenerator = new Random();
	public static int IDs;
	private boolean threadalive = true;
	
	public Entry() {;}
	
	public void run() {
	
		int timecustomerenter = 0;
	
		while (this.threadalive) {
			
			timecustomerenter = 1000 + 1000*randomgenerator.nextInt(3);
		
			try {
				
				this.sleep(timecustomerenter);
				this.entry(timecustomerenter);
			
			} catch (InterruptedException e) {
				
				System.out.println("Entry Interrupted");
			}
		
		
		}
		
	}

	public void entry(int timecustomerenter) {
		
		int wichqueue = randomgenerator.nextInt(2);
		int wichfood = randomgenerator.nextInt(3);
		int timetodecide = 1000 + 1000*randomgenerator.nextInt(3);
		
		String foodname = "";
		
		switch(wichfood) {
		
			case 0:
				foodname = "burger";
				break;
			case 1:
				foodname = "sandwitch";
				break;
			case 2:
				foodname = "salad";
				break;
						
		}
		
		CustomerQueues.enterCustomer(wichqueue, new Customer(IDs++, timetodecide, foodname));
		
		System.out.println("Customer #" + IDs + " enters " + (timecustomerenter/1000) + "seconds later to queue " + (wichqueue + 1));
		
	}
	
	public void end() {
		
		this.threadalive = false;
	}
	
}

class Attender extends Thread {
	
	private int wichqueue;
	private boolean threadalive = true;
	
	public Attender(int wichqueue) {
		
		this.wichqueue = wichqueue;
	}
	
	public void run() {
		
		int timetodecide = 0;
		Customer customer;
		
		while(this.threadalive) {
			
			customer = CustomerQueues.attendCustomer(this.wichqueue);
			
			if (customer != null) {
				
				try {
					
					this.sleep(timetodecide);
					this.attend(customer);
				
				} catch (InterruptedException e) {
					
					System.out.println("Attender Interrupted");
				}
			
			} else {
				
				try {
					
					this.sleep(500);
					
				} catch (InterruptedException e) {
					
					System.out.println("Attender Interrupted");
				}
				
			} 
		}
		
	}

	public void attend(Customer customer) {
		
		boolean sold = true;
		int wait = 0;
		
		while (sold) {
			
			switch (customer.desiredFood) {
				
				case "burger":
					if (FoodStock.cooksellburger("sell"))
						sold = false;
					break;
				case "sandwich":
					if (FoodStock.cooksellsandwitch("sell"))
						sold = false;
					break;
				case "salad":
					if(FoodStock.cooksellsalad("salad"))
						sold = false;
					break;
						
					
						
			}
			
			if (sold) {
				
				try {
					
					this.sleep(1000);
					wait++;
					
				} catch (InterruptedException e) {
					
					System.out.println("Attender Interrupted wait food");
				}
			}
		}
		
		System.out.println("Customer #" + (customer.id + 1) + " buy a " + customer.desiredFood + " and in " +(customer.timetodecide + 1000) + "seconds and wait for food " + wait + "seconds");
	}
		
	public void end() {
		
		this.threadalive = false;
	}
}