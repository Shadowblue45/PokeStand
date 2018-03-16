package garrettPokemonTraining;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class PokemonTest extends GUIApplication {
	
	public static PokemonTest test;
	public static PokemonScreen screen;
	public static StatTrainingScreen screen2;
	public static Inventory inventory;
	public static Pokemon pokemon;

	public PokemonTest(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		//screen = new PokemonScreen(getWidth(),getHeight());
		//setScreen(screen);
		screen2 = new StatTrainingScreen(getWidth(),getHeight());
		setScreen(screen2);
		
	}

	public static void main(String[] args) {
		inventory = new Inventory();
		test = new PokemonTest(1280, 720);
		Thread go = new Thread(test);
		go.start();
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
