package solid_example_of_solid_principles;

public class InterfaceSegregation {

	public static void main(String[] args) throws Exception {
		
		MaquilaFactory maquilaX = new MaquilaFactory();
		SodaFactory sodaX = new SodaFactory();
		CarFactory carX = new CarFactory();
		
		
		
	}
}

class MaquilaFactory implements ProductionDepartment, DeliveryDepartment{

	@Override
	public void logistics() {;}

	@Override
	public void distribution() {;}

	@Override
	public void manufacture() {;}

	@Override
	public void transformRawMaterial() {;}

	
	
}

class SodaFactory implements ProductionDepartment, AdministrativeDepartment, InvestigationDepartment {

	public void SodaFactory() {;}
	
	@Override
	public void craeteNewProduct() {;}

	@Override
	public void costReduction() {;}

	@Override
	public void administration() {;}

	@Override
	public void accountancy() {;}

	@Override
	public void manufacture() {;}

	@Override
	public void transformRawMaterial() {;}
	
}

class CarFactory implements ProductionDepartment, InvestigationDepartment {

	public CarFactory() {;}
	
	@Override
	public void craeteNewProduct() {;}

	@Override
	public void costReduction() {;}

	@Override
	public void manufacture() {;}

	@Override
	public void transformRawMaterial() {;}
	
}

//Bad Implementation
interface Factory {
	
	public void adminstration();
	public void manufacture();
	public void accountancy();
	public void transformRawMaterial();
	public void createNewProduct();
	public void costReduction();
	public void logistics();
	public void distribution();
	
	
}

//Better Implementation applying Interface Segregation
//Segregate Factory interface on Department interfaces
interface AdministrativeDepartment {
	
	public void administration();
	public void accountancy();
}


interface ProductionDepartment {
	
	public void manufacture();
	public void transformRawMaterial();
	
}

interface InvestigationDepartment {
	
	public void craeteNewProduct();
	public void costReduction();
}

interface DeliveryDepartment {
	
	public void logistics();
	public void distribution();
}


