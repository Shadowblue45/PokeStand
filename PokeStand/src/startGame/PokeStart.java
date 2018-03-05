package startGame;

import guiTeacher.GUIApplication;   
import guiTeacher.userInterfaces.Screen;
import startupandMenuScreen.MainMenuScreen;
import startupandMenuScreen.StartScreen;
import startupandMenuScreen.LoadScreen;
import audioPlayer.AudioTest; 

public class PokeStart extends GUIApplication {
	
	public static LoadScreen loadScreen;
	public static PokeStart start;
	public static MainMenuScreen mainMenuScreen;
	public static StartScreen startScreen;

	public PokeStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		loadScreen = new LoadScreen(getWidth(), getHeight());
		mainMenuScreen = new MainMenuScreen(getWidth(), getHeight());
		startScreen = new StartScreen(getWidth(), getHeight());
		
		setScreen(startScreen);

	}

	public static void main(String[] args) {
		start = new PokeStart(1280, 720);
		Thread go = new Thread(start);
		go.start();
		AudioTest.changeVolume(.6);
	}

}
