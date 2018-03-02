package audioPlayer;

import java.io.File;  
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import startupandMenuScreen.PokeStart;

public class AudioPlayer {

	private boolean pause;
	private boolean cancel;

	public AudioPlayer() {
		pause = false;
		cancel = false;
	}

	Long audioPosition;
	private Clip audioLine;

	public void play(String audioFilePath) {
		File audioFile = new File(audioFilePath);
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

			audioLine = AudioSystem.getClip();
			audioLine.open(audioStream);

			audioLine.start();

			while(!cancel) {
				sleep(0);
				if(pause) {
					long clipTime = audioLine.getMicrosecondPosition();
					audioLine.stop();
					while(pause) {
						sleep(0);
					}
					audioLine.setMicrosecondPosition(clipTime);
					if(!cancel) {
						audioLine.start();
					}
				}
			}

			audioLine.flush();
			audioLine.close();
			audioStream.close();

		} catch (UnsupportedAudioFileException ex) {
			System.out.println("The specified audio file is not supported.");
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			System.out.println("Audio line for playing back is unavailable.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error playing the audio file.");
			ex.printStackTrace();
		}      
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String audioFilePath = "resources/Pokemon.wav";
		AudioPlayer player = new AudioPlayer();
		player.play(audioFilePath);
	}
}
