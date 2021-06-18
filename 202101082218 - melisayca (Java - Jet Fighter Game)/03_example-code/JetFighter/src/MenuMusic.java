import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
   

public class MenuMusic{
   
	boolean playing = true;
	private Clip clipMenu, clipExplosion, clipGame;
	private int option;
	public MenuMusic(int option) {
		this.option = option;
		try {
			
			if (option == 1) {
		    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("GameMusic.wav"));
		    	clipMenu = AudioSystem.getClip();
		    	
		    	clipMenu.open(audioIn);
		    	clipMenu.loop(Clip.LOOP_CONTINUOUSLY);
			}
	    	
			else if (option == 2) {
		    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("Explosion.wav"));
		    	clipExplosion = AudioSystem.getClip();
		    	
		    	clipExplosion.open(audioIn);
		    	clipExplosion.loop(0);
			}
			else if (option == 3) {
		    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("GameMusic.wav"));
		    	clipGame = AudioSystem.getClip();
		    	
		    	clipGame.open(audioIn);
		    	clipGame.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else {
			}
	


	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	      

   }
    public void stopMenuMusic(){
    	clipMenu.close();
    }
    public void stopGameMusic(){
    	clipGame.close();
    }
}