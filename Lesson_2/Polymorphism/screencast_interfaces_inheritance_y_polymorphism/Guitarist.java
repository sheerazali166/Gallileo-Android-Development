package screencast_interfaces_inheritance_y_polymorphism;

public interface Guitarist extends PlaySong {

	public default void playfavouriteSong() {

		System.out.println("Playing my favourite song");
		PlaySong("My First Song");
		
		
	} 
}
