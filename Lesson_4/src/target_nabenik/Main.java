package target_nabenik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

	public Main() {
		
	}
	
	public List generateRandomList() {
		
		List<Integer> numbersList = new ArrayList<Integer>();
		Random rGenerator = new Random(); 
		
		for (int i = 0;i < 20;i++) {
			
			numbersList.add(rGenerator.nextInt(255));
		}
		
		return numbersList;
	}
	
	public void oldSort() {
		
		List<Integer> unsortedList = this.generateRandomList();
		System.out.println("Old way");
		System.out.println(unsortedList);
		Collections.sort(unsortedList, (o1, o2) -> { return o1.compareTo(o2);});
		System.out.println(unsortedList);
	}
	
	public void lambdaSort() {
		
		List<Integer> theList = this.generateRandomList();
		System.out.println("Lambda way");
		System.out.println(theList);
		theList.sort((x, y) -> {
			return x.compareTo(y);
		});
		System.out.println(theList);
	}
	
	public void oldFilter() {
		
		List<Integer> unfilteredList = this.generateRandomList();
		System.out.println("Old way");
		List<Integer> filteredList = new ArrayList();
		Iterator var3 = unfilteredList.iterator();
		
		while (var3.hasNext()) {
			
			Integer number = (Integer)var3.next();
			
			if (number > 50) {
				
				filteredList.add(number);
			}
			
			
		}
		
		System.out.println(filteredList);
		
	}
	
	
	public void lambdaFilter() {
		
		System.out.println("Lambda way");
		List<Integer> unfilteredList = this.generateRandomList();
		List<Integer> filteredList = (List)unfilteredList.stream().filter((x) -> {
			
			return x > 50;
		}).collect(Collectors.toList());
		
		System.out.println(filteredList);
		

	}
	
	public static void main(String[] args) {
		

		Main mainInstance = new Main();
		mainInstance.oldSort();
		mainInstance.lambdaSort();
		mainInstance.oldFilter();
		mainInstance.lambdaFilter();

	}

}
