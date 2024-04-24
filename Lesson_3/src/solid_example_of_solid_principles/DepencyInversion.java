package solid_example_of_solid_principles;

public class DepencyInversion {

	public static void main(String[] args) throws Exception {
		
		//Graphic UserInterface
		UserInterface.getUserInput(new Graphic());
		UserInterface.sendToUserOutput(new Graphic());
		
		System.out.println();
		
		//Commmand Line or Terminal UserInterface
		UserInterface.getUserInput(new CommandLine());
		UserInterface.sendToUserOutput(new CommandLine());
		
	}

}

final class UserInterface {
	
	private UserInterface() {;}
	public static void getUserInput(Input in) {
	
		in.getInput();
		
	};
	
	public static void sendToUserOutput(Output out) {

		out.sendOutput();
		
	}
}


interface Input {

	public void getInput();
}

interface Output {
	
	public void sendOutput();
}

class Graphic implements Input, Output {

	public Graphic() {;}
	
	@Override
	public void sendOutput() {
		
		System.out.println("Show data graphically");
		
	}

	@Override
	public void getInput() {
		System.out.println("Get Mouse Clicks and Movement");
		
	}
	
	
}

class CommandLine implements Input, Output{

	public CommandLine() {;}
	
	@Override
	public void sendOutput() {
		// TODO Auto-generated method stub
		
		System.out.println("Print data to terminal");
		
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		
		System.out.println("Get Commands");
	}

	
}



