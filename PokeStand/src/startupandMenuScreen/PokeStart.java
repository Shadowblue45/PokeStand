package startupandMenuScreen;

import guiTeacher.GUIApplication;   
import guiTeacher.userInterfaces.Screen;
import audioPlayer.AudioTest; 

public class PokeStart extends GUIApplication {
	
	public static Screen backScreen;
	public static PokeStart boss;

	public PokeStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		StartScreen s = new StartScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		boss = new PokeStart(1400, 780);
		Thread go = new Thread(boss);
		go.start();
		AudioTest.changeVolume(.6);
	}

}
