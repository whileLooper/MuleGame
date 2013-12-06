
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * This is the MP3 class used to play the background music
 * @author Team 30
 *
 */
public class MP3 {
    private String filename;
    private Player player;
    private Thread thread;
    private boolean cont = true;

    // constructor that takes the name of an MP3 file
    public MP3() {
        
    }
    
    public void setPiece(String filename){
    	this.filename = filename;
    }

    public void close() { if (player != null) player.close(); }

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        thread = new Thread() {
            public void run() {
            	while(cont){
					try {
						player.play();
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("play once");
					renew();
            	}
                
            	
            }
        };
        thread.start();
    }

    /**
     * Renew player for next play
     */
    private void renew(){
    	
		try {
			FileInputStream fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			
		}   
    }
    
    /**
     * Change the music to another one
     * @param file to change to
     */
    public void changeMusic(String file){
    	player.close();
    	filename = file;
    	renew();
    	play();
    }

    // test client
    public static void main(String[] args) {
        String filename = "CS.mp3";
        MP3 mp3 = new MP3();
        mp3.setPiece(filename);
        mp3.play();
        // do whatever computation you like, while music plays
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /**
        int N = 4000;
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += Math.sin(i + j);
            }
        }
        System.out.println(sum);
        */
        // when the computation is done, stop playing it
        //mp3.close();

        // play from the beginning
        
        
        //mp3 = new MP3("JY.mp3");
        //mp3.play();
        mp3.changeMusic("JY.mp3");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        mp3.changeMusic("CS.mp3");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /**
        mp3.changeMusic("JY.mp3");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        mp3.changeMusic("CS.mp3");
        */
        System.out.println("done");

    }

}
