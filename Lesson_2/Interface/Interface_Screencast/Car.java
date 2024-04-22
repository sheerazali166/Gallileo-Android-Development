package Interface_Screencast;

public class Car implements Vehicle{

	public String transportType = "terrestrial";
	
	public int wheels;
	
	public Car(int wheels) {
		
		this.wheels = wheels;
	}
	


	@Override
	public String getTransportType() {
		// TODO Auto-generated method stub
		return this.transportType;
	}

	@Override
	public boolean hasWheels() {
		// TODO Auto-generated method stub
		return wheels > 0;
	}

	public int getNumberOfWheels() {
		
		return wheels;
	}
}
