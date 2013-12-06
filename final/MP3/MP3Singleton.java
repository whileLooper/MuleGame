/**
 * This is the singleton class for MP3
 * @author Team 30
 *
 */
public class MP3Singleton {

	private static MP3 mp3 = null;
	
	/**
	 * This private constructor for the static class
	 */
	private MP3Singleton(){
		
	}
	
	/**
	 * The get instance method to get the mp3 instance
	 * @return the player
	 */
	public static MP3 getInstance(){
		if(mp3 == null){
			mp3 = new MP3();
			return mp3;
		}
		return mp3;
	}
}
