package screencast_interfaces_inheritance_y_polymorphism;

public interface PlaySong {

	public default void PlaySong(String songName) {
		
		System.out.println("Playing " + songName);
	}
	
}
