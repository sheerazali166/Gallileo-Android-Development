package Animal;

public class Animal {
	
	public boolean hasEaten;
	
	public Animal() {
		
		hasEaten = false;
		
	}
	
	
	public void eat() {
	
		System.out.println("The animal is eating...");
		hasEaten = true;
	}
	
	

}
