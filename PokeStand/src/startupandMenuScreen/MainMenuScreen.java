package startupandMenuScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

import audioPlayer.AudioTest;
import garrettPokemonTraining.Inventory;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import startGame.PokeStart;

public class MainMenuScreen extends FullFunctionScreen {

	private int xCord;
	private int yCord;
	private Graphics2D g;
	private int temp;
	public static Graphic pokemon;
	public static TextArea name;

	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		System.out.println(PokeStart.inventory.pokemonImages[0]);
		resetCoordinates();
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.white);
		
		String[] pokeNames = PokeStart.inventory.getNames();
		String[] pokeLink = PokeStart.inventory.getPokemonImages();
		
		int nameLength = pokeNames[0].length();
		
		//setImages(viewObjects);
		
		String[] names = {"Training", "Interact", "Rest", "Abilities", "Upgrades", "Shop"};
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Pokemon Arena.jpg");
		pokemon = new Graphic(880, 200, 400, 400, pokeLink[0]);
		PokeStart.setPokemonGBFont(100f);
		TextArea daysNum = new TextArea(1050,40, 500, 300, "30");
		PokeStart.setPokemonTextFont(24f);
		name = new TextArea(10,20, 500, 300, pokeNames[0]);
		TextArea daysRemaining = new TextArea(1000,140, 500, 300, "Days Left");
		viewObjects.add(background);
		viewObjects.add(pokemon);
		createBlackBackground(viewObjects);
		viewObjects.add(name);
		viewObjects.add(daysNum);
		viewObjects.add(daysRemaining);
		daysNum.setCustomTextColor(Color.white);
		daysRemaining.setCustomTextColor(Color.white);
		name.setCustomTextColor(Color.white);
		setMenuButtons(names, viewObjects);
		pokemon.update();
	}

	public void setMenuButtons(String[] names, List<Visible> viewObjects) {
		PokeStart.setPokemonTextFont(24f);
		initButtons(names, viewObjects);
		resetCoordinates();
		PokeStart.setPokemonTextFont(32f);
	}
	
	public void createBlackBackground(List<Visible> viewObjects) {
		CustomRect rect = new CustomRect(0,yCord-20,getWidth(),120);
		CustomRect square = new CustomRect(980,0,300,200);
		CustomRect textArea = new CustomRect(0,0,250,400);
		CustomRect fatigueArea = new CustomRect(250,0,730,150);
		viewObjects.add(rect);
		viewObjects.add(square);
		viewObjects.add(textArea);
		viewObjects.add(fatigueArea);
	}

	public void resetCoordinates() {
		xCord = 10;
		yCord = 600;
		temp = 0;
	}

	public void initButtons(String[] names, List<Visible> viewObjects) {
		for(int i = 0; i < names.length; i++) {
			final int temp = i;
			Button button = new Button (xCord, yCord, 200,70,names[i],new Action() {

				public void act() {
					PokeStart.start.setScreen(PokeStart.getScreen(temp));
					PokeStart.mainScreen =! PokeStart.mainScreen;
				}
			});
			xCord += 210;
			viewObjects.add(button);
			button.setBackground(new Color(0,0,0,140));
			button.update();
			button.setForeground(Color.white);
		}
	}
	
	public void setImages(List<Visible> viewObjects) {
		String[] images = PokeStart.inventory.getPokemonImages();
		Graphic pokemon = new Graphic(880, 200, 400, 400, images[0]);
		viewObjects.add(pokemon);
	}

}
