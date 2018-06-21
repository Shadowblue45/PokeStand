package startGame;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;

import Credits.CreditsScreen;
import RestScreen.RestScreen;
import audioPlayer.AudioTest;
import battle.BattleScreen;
import displayAbilities.AbilityScreen;
import fahadStartupandMenuScreen.BattleItemScreen;
import fahadStartupandMenuScreen.LoadScreen;
import fahadStartupandMenuScreen.MainMenuScreen;
import fahadStartupandMenuScreen.StartScreen;
import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.StatTrainingScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import guiTeacher.userInterfaces.Screen;
import rickyShopInteract.RickyInteractScreen;
import rickyShopInteract.RickyScreen;
import selectionScreen.SelectionScreen; 

public class PokeStart extends GUIApplication {
	
	public static LoadScreen loadScreen;
	public static PokeStart start;
	public static StartScreen startScreen;
	public static StatTrainingScreen trainingScreen;
	public static SelectionScreen selectionScreen;
	public static BattleScreen battleScreen;
	public static RickyScreen shopScreen;
	public static Inventory inventory;
	public static MainMenuScreen mainMenuScreen;
	public static boolean mainScreen;
	public static AbilityScreen abilityScreen;
	public static RickyInteractScreen interactScreen;
	public static RestScreen restScreen;
	public static CreditsScreen creditScreen;
	public static BattleItemScreen itemScreen;
	public static int randomSound;

	public PokeStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		randomSound =  (int) (Math.random() * 3);
		try{    
		       setIconImage(ImageIO.read(new File("resources/icons/Legendary Dog " + PokeStart.randomSound + ".png")));   
		   }
		catch (Exception ex){
		       //do something
		   }
		inventory = new Inventory();
		PokeStart.inventory.fatigue = 0;
		loadScreen = new LoadScreen(getWidth(), getHeight());
		startScreen = new StartScreen(getWidth(), getHeight());
		shopScreen = new RickyScreen(getWidth(), getHeight());
		
		setScreen(startScreen);

	}

	public static void main(String[] args) {
		start = new PokeStart(1280, 720);
		Thread go = new Thread(start);
		go.start();
		AudioTest.changeVolume(.6);
		mainScreen = true;
	}
	
	public static Screen getScreen(int i) {
		Screen[] mainScreens = {trainingScreen,interactScreen, restScreen,abilityScreen,shopScreen,loadScreen};
		if(PokeStart.inventory.daysLeft == 0) {
			mainScreens[0] = battleScreen;
		}
		if (i < mainScreens.length) {
			return mainScreens[i];
		}
		return null;
	}
	
	public static void setPokemonGBFont(float f) {
		try {
		File fontFile = new File("resources/Fonts/Pokemon GB.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void setPokemonTextFont(float f) {
		try {
		File fontFile = new File("resources/Fonts/Pokemon Text.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void setPokemonFont(float f) {
		try {
		File fontFile = new File("resources/Fonts/Kanji_PA.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
//	public static void setPokemonHollowFont(float f) {
//		try {
//		File fontFile = new File("resources/Fonts/Pokemon Hollow.ttf");
//		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
//		Font baseFont=font.deriveFont(f);
//		StyledComponent.setBaseFont(baseFont);
//	} catch (Exception e) {
//		e.printStackTrace();
//		}
//	}
	
	public static void setPokemonSunFont(float f) {
		try {
		File fontFile = new File("resources/Fonts/Pokemon Sun.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
