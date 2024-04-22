package more_about_using_inheritance_and_polymorphism.Animal;

import Animal.Animal;
import Animal.PolarBear;

public class Main {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		Animal bear = new PolarBear();
		
		animal.eat();
		bear.eat();
		
		//System.out.println(animal.hasEaten);
		//System.out.println(bear.color);

	}

}
