package startupandMenuScreen;

import guiTeacher.GUIApplication;   
import guiTeacher.userInterfaces.Screen;
import audioPlayer.AudioTest; 

public class PokeStart extends GUIApplication {
	
	public static StartScreen startScreen;
	public static PokeStart start;
	protected static MainMenuScreen mainMenuScreen;

	public PokeStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		startScreen = new StartScreen(getWidth(), getHeight());
		mainMenuScreen = new MainMenuScreen(getWidth(), getHeight());
		
		setScreen(startScreen);

	}

	public static void main(String[] args) {
		start = new PokeStart(1280, 720);
		Thread go = new Thread(start);
		go.start();
		AudioTest.changeVolume(.6);
	}

}
