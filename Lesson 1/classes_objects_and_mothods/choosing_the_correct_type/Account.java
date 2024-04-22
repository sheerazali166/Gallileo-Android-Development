package choosing_the_correct_type;

public class Account {
	
	public static int nextAccount = 1;
	
	public String name;
	public int accountNumber;
	public short balance;
	
	
	public Account(String n) {
		
		name = new String(n);
		accountNumber = nextAccount;
		balance = 0;
		
		nextAccount++;
		
	}
	
	public Account(String n, short b) {
		
		name = new String(n);
		accountNumber = nextAccount;
		balance = b;
		
		nextAccount++;
		
	}
	
	public void deposit(short b) {
		
		balance = (short) (balance + b);
		
		
	}
	
	public String toString() {
		
		return "name: " + name + "\naccount number: " + accountNumber + "\nbalance: " + balance;
	}
	
	
	
	
	
	
	

}
