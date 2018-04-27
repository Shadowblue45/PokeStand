package fahadStartupandMenuScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

import audioPlayer.AudioTest;
import battle.BattleScreen;
import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.Pokemon;
import garrettPokemonTraining.StatTrainingScreen;
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
	public static TextArea info;
	public static Pokemon p;
	public static Graphic pokemon;
	public static TextArea name;

	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		update();
		System.out.println(PokeStart.inventory.pokemonImages[0]);
		PokeStart.trainingScreen = new StatTrainingScreen(getWidth(), getHeight());
		resetCoordinates();
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.white);
	
		//temp setters=======================================

		String[] names = {"Training", "Interact", "Rest", "Abilities", "Upgrades", "Shop"};
		String[] pokeNames = PokeStart.inventory.getNames();
		String[] pokeLink = PokeStart.inventory.getPokemonImages();
		int index = PokeStart.inventory.pokemonIndex;
		int days = PokeStart.inventory.daysLeft;
		
		//===================================================
		
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Pokemon Arena.jpg");
		Button batttttleButton = new Button (900, 500, 200,70,"Battle",new Action() {

			public void act() {
				
				PokeStart.start.setScreen(PokeStart.battleScreen);
				PokeStart.battleScreen.startBattle();
				
			}
		});
		pokemon = new Graphic(440, 200, 400, 400, pokeLink[index]);
		PokeStart.setPokemonSunFont(100f);
		TextArea daysNum = new TextArea(1050,10, 500, 300, Integer.toString(days));
		PokeStart.setPokemonTextFont(26f);
		name = new TextArea(10,20, 500, 300, pokeNames[index]);
		TextArea daysRemaining = new TextArea(1000,110, 500, 300, "Days Left");
		
		//====================================================================
		PokeStart.setPokemonSunFont(18f);
		p = PokeStart.inventory.getPokemon();

		info = new TextArea(10,60,500,360,"Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n");
		
		//====================================================================
		
		viewObjects.add(background);
		viewObjects.add(pokemon);
		createBlackBackground(viewObjects);
		fatigueBarDesign(viewObjects);
		viewObjects.add(name);
		viewObjects.add(info);
		viewObjects.add(daysNum);
		viewObjects.add(daysRemaining);
		viewObjects.add(batttttleButton);
		daysNum.setCustomTextColor(Color.white);
		daysRemaining.setCustomTextColor(Color.white);
		name.setCustomTextColor(Color.white);
		info.setCustomTextColor(Color.white);
		setMenuButtons(names, viewObjects);
		pokemon.update();
		StyledComponent.setButtonOutline(false);
	}
	
	public void fatigueBarDesign(List<Visible> viewObjects) {
		PokeStart.setPokemonTextFont(26f);
		TextArea fatigue = new TextArea(270,20, 500, 300, "Fatigue");
		CustomRect rect = new CustomRect(270,70,400,40,Color.gray);
		CustomRect fatigueBar = new CustomRect(270,70,(100-PokeStart.inventory.fatigue)*4,40,Color.green);
		viewObjects.add(rect);
		viewObjects.add(fatigue);
		viewObjects.add(fatigueBar);
		fatigue.setCustomTextColor(Color.white);
	}

	public void setMenuButtons(String[] names, List<Visible> viewObjects) {
		PokeStart.setPokemonTextFont(24f);
		initButtons(names, viewObjects);
		resetCoordinates();
		PokeStart.setPokemonTextFont(32f);
	}
	
	public void createBlackBackground(List<Visible> viewObjects) {
		CustomRect rect = new CustomRect(0,yCord-20,getWidth(),120);
		//CustomRect square = new CustomRect(980,0,300,200);
		CustomRect textArea = new CustomRect(0,0,250,300);
		CustomRect fatigueArea = new CustomRect(250,0,1030,150);
		viewObjects.add(rect);
		//viewObjects.add(square);
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

}
