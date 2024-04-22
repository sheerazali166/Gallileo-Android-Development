package classes_objects_and_mothods_video1;

public class Main {

	public static void main(String[] args) {
		
		Dog dog = new Dog(9, "Tommy");
		
		System.out.println(dog.name);
		System.out.println(dog.size);
		
		dog.bark();
		dog.bark2();
		dog.printName("Charlie");
		

		Person person = new Person();
		person.printData("XYZ", "Unknown", 23);
		System.out.println(person.getName("Unkown", "Identity"));
		
		

	}

}
