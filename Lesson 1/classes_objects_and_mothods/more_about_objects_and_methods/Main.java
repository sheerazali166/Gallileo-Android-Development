package more_about_objects_and_methods;

public class Main {

	public static void main(String[] args) {
		
		Account alice = new Account("Alice", 100);
		Account bob = new Account("bob");
		
		System.out.println(alice);
		System.out.println(bob);
		
		System.out.println(alice.nextAccount);
		System.out.println(bob.nextAccount);
		System.out.println(Account.nextAccount);
		
		

	}

}
