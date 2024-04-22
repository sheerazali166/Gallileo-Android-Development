package branching_statement_continue;

public class Main {

	public static void main(String[] args) {
		
		int number = 1;
		int number2 = -1;
		
		String value = loopNumber(number);
		System.out.println(value);
		
		String value2 = loopNumber(number2);
		System.out.println(value2);
		
		

	}
	
	public static String loopNumber(int newNumber) {
		
		while (newNumber >= 0) {
			
			if (newNumber < 10) {
				
				newNumber++;
				continue;
				
			}
			
		 System.out.println(newNumber);
		 return "Done";
		 
			
		}
		
		return newNumber + " is negetive";
		
		
	}

}
