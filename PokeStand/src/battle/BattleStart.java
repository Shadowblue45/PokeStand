package battle;

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

public class BattleStart extends GUIApplication {
	
	public static LoadScreen loadScreen;
	public static BattleStart start;
	public static StartScreen startScreen;
	public static TrainingScreen trainingScreen;
	public static SelectionScreen selectionScreen;
	public static MainMenuScreen mainMenuScreen;
	public static BattleScreen battleScreen;

	public BattleStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		battleScreen = new BattleScreen(getWidth(), getHeight());
		
		setScreen(battleScreen);

	}

	public static void main(String[] args) {
		start = new BattleStart(1280, 720);
		Thread go = new Thread(start);
		go.start();
		
	}
}