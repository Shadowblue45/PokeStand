package startGame;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import guiTeacher.userInterfaces.Screen;
import selectionScreen.SelectionScreen;
import startupandMenuScreen.MainMenuScreen;
import startupandMenuScreen.StartScreen;
import startupandMenuScreen.TrainingScreen;
import startupandMenuScreen.LoadScreen;

import java.awt.Font;
import java.io.File;

import audioPlayer.AudioTest;
import battle.BattleScreen; 

public class PokeStart extends GUIApplication {
	
	public static LoadScreen loadScreen;
	public static PokeStart start;
	public static StartScreen startScreen;
	public static TrainingScreen trainingScreen;
	public static SelectionScreen selectionScreen;
	public static MainMenuScreen mainMenuScreen;
	public static BattleScreen battleScreen;

	public PokeStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		loadScreen = new LoadScreen(getWidth(), getHeight());
		trainingScreen = new TrainingScreen(getWidth(), getHeight());
		startScreen = new StartScreen(getWidth(), getHeight());
		selectionScreen = new SelectionScreen(getWidth(), getHeight());
		mainMenuScreen = new MainMenuScreen(getWidth(), getHeight());
		battleScreen = new BattleScreen(getWidth(), getHeight());
		
		setScreen(startScreen);

	}

	public static void main(String[] args) {
		start = new PokeStart(1280, 720);
		Thread go = new Thread(start);
		go.start();
		AudioTest.changeVolume(.6);
	}
	
	public static void setPokemonGBFont(float f) {
		try {
		File fontFile = new File("resources/Pokemon GB.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static Screen getScreen(int i) {
		Screen[] screens = {trainingScreen, loadScreen,null,null,null,null};
		if (i < screens.length) {
		return screens[i];
		}
		return null;
	}
	
	public static void setPokemonTextFont(float f) {
		try {
		File fontFile = new File("resources/Pokemon Text.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void setPokemonFont(float f) {
		try {
		File fontFile = new File("resources/Pokemon Solid.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void setPokemonHollowFont(float f) {
		try {
		File fontFile = new File("resources/Pokemon Hollow.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
