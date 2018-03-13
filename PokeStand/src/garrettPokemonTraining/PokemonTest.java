package garrettPokemonTraining;

import guiTeacher.GUIApplication;

public class PokemonTest extends GUIApplication {
	
	public static PokemonTest test;
	public static PokemonScreen screen;
	public static Inventory inventory;
	public static Pokemon pokemon;

	public PokemonTest(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new PokemonScreen(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		inventory = new Inventory();
		test = new PokemonTest(1280, 720);
		Thread go = new Thread(test);
		go.start();
	}

}
