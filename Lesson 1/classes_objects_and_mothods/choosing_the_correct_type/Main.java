package choosing_the_correct_type;

public class Main {

	public static void main(String[] args) {
		
		Account alice = new Account("Alice", (short) 100);
		System.out.println(alice);
		
		alice.deposit((short) 100);
		System.out.println(alice);
		
		alice.deposit((short) 40000);
		System.out.println(alice);
		

	}

}
