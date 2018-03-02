package audioPlayer;

import java.io.*; 
import javax.sound.sampled.*;
public class AudioTest {

	private static int songSize;
	public static Clip sound;
	public static void main(String[] args) {
	}
	
	public static void playSound(String file) {
		try {
			   File song = new File(file);
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(song));
			   sound = clip;
			   clip.start();
			  songSize = (int) (clip.getMicrosecondLength()/1000);
		  } catch (Exception e) {
			   System.err.println(e.getMessage());
			  }
	}
	
	public static Clip getClip() {
		return sound;
	}
	
	public static void changeVolume(double num) {
		FloatControl gainControl = (FloatControl) getClip().getControl(FloatControl.Type.MASTER_GAIN);
		 double gain = num; // number between 0 and 1 (loudest)
		    float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
		    gainControl.setValue(dB);
	}
	
	public static void stopSound(Clip clip) {
		clip.stop();
	}
}
