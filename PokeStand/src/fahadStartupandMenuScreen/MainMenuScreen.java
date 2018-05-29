package fahadStartupandMenuScreen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import RestScreen.RestScreen;
import audioPlayer.AudioTest;
import battle.BattleScreen;
import displayAbilities.AbilityScreen;
import garrettPokemonTraining.Pokemon;
import garrettPokemonTraining.StatTrainingScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import rickyShopInteract.RickyInteractScreen;
import startGame.PokeStart;

public class MainMenuScreen extends FullFunctionScreen {

	private int xCord;
	private int yCord;
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
		AudioTest.playSound("resources/Music/Pokemon MainMenu.wav");
//		System.out.println(PokeStart.inventory.pokemonImages[0]);
		resetCoordinates();
	
		//temp setters=======================================

		String[] names = {"Training", "Interact", "Rest", "Abilities", "Upgrades", "Shop"};
		String[] pokeNames = PokeStart.inventory.getNames();
		String[] pokeLink = PokeStart.inventory.getPokemonImages();
		int index = PokeStart.inventory.pokemonIndex;
		int days = PokeStart.inventory.daysLeft;

		if(PokeStart.inventory.daysLeft == 0) {
			names[0] = "Battle";
			PokeStart.battleScreen = new BattleScreen(getWidth(), getHeight());
		}
		PokeStart.abilityScreen = new AbilityScreen(getWidth(), getHeight());
		PokeStart.interactScreen = new RickyInteractScreen(getWidth(), getHeight());
		PokeStart.restScreen = new RestScreen(getWidth(), getHeight());
		PokeStart.trainingScreen = new StatTrainingScreen(getWidth(), getHeight());
		
		//===================================================
		
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/field.jpg");
		
		//To be deleted later once testing is over
		Button battleButton = new Button (900, 500, 200,70,"Battle",new Action() {

			public void act() {

				AudioTest.stopSound(AudioTest.sound);
				PokeStart.inventory.daysLeft =  0;
				PokeStart.mainMenuScreen = new MainMenuScreen(getWidth(), getHeight());
				update();
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				
			}
		});
		pokemon = new Graphic(440, 200, 400, 400, pokeLink[index]);
		PokeStart.setPokemonSunFont(100f);
		TextArea daysNum = new TextArea(20,10, 500, 300, Integer.toString(days));
		PokeStart.setPokemonTextFont(26f);
		name = new TextArea(1020,20, 500, 300, pokeNames[index]);
		TextArea daysRemaining = new TextArea(20,110, 500, 300, "Days Left");
		
		//====================================================================
		PokeStart.setPokemonSunFont(18f);
		p = PokeStart.inventory.getPokemon();

		info = new TextArea(1020,60,500,360,"Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Sp. Atk: " + p.getsAtk() + "\n" + "Sp. Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n");
		
		//====================================================================
		
		viewObjects.add(background);
		createBlackBackground(viewObjects);
		fatigueBarDesign(viewObjects);
		viewObjects.add(daysNum);
		viewObjects.add(daysRemaining);
		viewObjects.add(battleButton);
		setMenuButtons(names, viewObjects);
		viewObjects.add(pokemon);
		viewObjects.add(name);
		viewObjects.add(info);
		daysNum.setCustomTextColor(Color.white);
		daysRemaining.setCustomTextColor(Color.white);
		name.setCustomTextColor(Color.white);
		info.setCustomTextColor(Color.white);
		pokemon.update();
		battleButton.setForeground(Color.white);
		StyledComponent.setButtonOutline(false);
	}
	
	public void fatigueBarDesign(List<Visible> viewObjects) {
		PokeStart.setPokemonTextFont(26f);
		TextArea fatigue = new TextArea(270,20, 500, 300, "Fatigue");
		CustomRect border = new CustomRect(265,65,410,50,Color.white);
		CustomRect rect = new CustomRect(270,70,400,40,Color.gray);
		CustomRect fatigueBar = new CustomRect(270,70,(100-PokeStart.inventory.fatigue)*4+ 1,40,Color.green);
		viewObjects.add(border);
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
		CustomRect botRect = new CustomRect(0,yCord-15,getWidth(),115);
		//CustomRect square = new CustomRect(980,0,300,200);
		CustomRect textArea = new CustomRect(1010,0,270,300);
		CustomRect fatigueArea = new CustomRect(0,0,1010,150);
		viewObjects.add(botRect);
		//viewObjects.add(square);
		viewObjects.add(textArea);
		viewObjects.add(fatigueArea);
	}

	public void resetCoordinates() {
		xCord = 10;
		yCord = 620;
	}

	public void initButtons(String[] names, List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.white);
		for(int i = 0; i < names.length; i++) {
			final int temp = i;
			Button button = new Button (xCord, yCord, 200,70,names[i],new Action() {

				public void act() {
					AudioTest.stopSound(AudioTest.sound);
					if(names[temp].equals("Training")) {
						AudioTest.playSound("resources/Music/Pokemon Training.wav");
					}
					PokeStart.start.setScreen(PokeStart.getScreen(temp));
					if(names[temp].equals("Battle")) {
						PokeStart.battleScreen.startBattle();
						AudioTest.playSound("resources/Music/Pokemon Battle.wav");
					}
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
