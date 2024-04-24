package practice_of_the_theory_of_array_video_4;

import java.util.ArrayList;

public class Dynamic {

	public static void main(String[] args) {
		
		System.out.println("----Dynamic Structures----\n");
		
		//ArrayList
		System.out.println("Empty ArrayList:");
		ArrayList<String> dynamiclist = new ArrayList<String>();
		System.out.println(dynamiclist);
		
		
		System.out.println("\nAdd an element to the ArrayList:");
		dynamiclist.add("I'm Dynamic");
		System.out.println(dynamiclist);
		System.out.println("My size: " + dynamiclist.size());
		
		System.out.println("\nAdd a second element to the ArrayList:");
		dynamiclist.add("I'm Growing");
		System.out.println("My size: " + dynamiclist.size());
		
		
		//String Pool
		System.out.println("\n\nCreating String I'm Growing and another one");
		String grow = "I'm Growing", other = "other";
		System.out.println("== compare the direction (pointer) of a Project");
		System.out.println(grow == dynamiclist.get(1));
		System.out.println(other == dynamiclist.get(1));
		System.out.println("The two strings has the same value so, \nthe String pool of JVM assign the same direction to both strings\n\n\n\n");
		
		

	}

}
