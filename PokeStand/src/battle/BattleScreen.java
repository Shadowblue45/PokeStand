package battle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fahadStartupandMenuScreen.CustomRect;
import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.Move;
import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class BattleScreen extends FullFunctionScreen{
	
	private CustomRect userCurrentHp;
	private TextLabel userName;
	private Graphic userPokemonSprite;
	
	private Graphic enemyPokemonSprite;
	private Button[] buttonArr;
	
	private Pokemon enemyPokemon;
	public static Pokemon userPokemon;
	private TextLabel enemyName;
	private CustomRect enemyCurrentHp;
	private Move currentAttack;
	private List<Visible> viewObjects;
	private TextArea info;
	
	private AnimatedComponent enemyAnimation;
	
	public BattleScreen(int width, int height) {
		super(width, height);
	}
	
	public void startBattle() {
		PokeStart.setPokemonGBFont(28f);
		info.setBackground(Color.WHITE);
		String[] pokeNames = PokeStart.inventory.getNames();
		int index = PokeStart.inventory.pokemonIndex;
		userPokemon = Inventory.pokemon;
		enemyPokemon = PokeStart.selectionScreen.getEnemyPokemon();
		userPokemon.setHpBar(userCurrentHp);
		enemyPokemon.setHpBar(enemyCurrentHp);
		
		//Set user's pokemon's current stats to the current max
		userPokemon.setCurrentHp(userPokemon.getHp());
	
		//Set enemy pokemon's current stats to the current max
		enemyPokemon.setCurrentHp(enemyPokemon.getHp());
		
		
		//Test if these conditions are set
//		System.out.println("\nHp Size : " + userHpSize);
//		System.out.println("\nHp : " + Inventory.pokemon.getHp());
//		System.out.println("current HP is "+Inventory.pokemon.getCurrentHp());
		
			
		//changing user graphics
		userName.setText(pokeNames[index]);
		userPokemonSprite.loadImages("resources/pokebacks/"+pokeNames[index]+ " back.png", getWidth()/2,getHeight()/2);
		
		//changing enemy graphics
		userPokemon.setHpBar(userCurrentHp);
		//enemyPokemonSprite.loadImages("resources/pokefronts/"+ enemyPokemon.getName() + " Front.png", getWidth()/3, getHeight()/3);
		enemyName.setText(enemyPokemon.getName());
		
		setEnemyAnimation(enemyPokemon.getName());
		Thread run = new Thread(enemyAnimation);
		run.start();
		viewObjects.add(enemyAnimation);
		int i = 0;
		for(Button b : buttonArr) {
			final int temp = i;
		
			b.setAction(new Action() {
				
				@Override
				public void act() {
					turn(temp);
				}
			});
			i++;
		}
	}
	
	public void setInfoText(String text) {
		info.setText(text);
		info.update();
	}
	
	public void endBattle(Pokemon loser) {
		removeMoves();
		if(loser == userPokemon) {
			viewObjects.remove(userCurrentHp);
		}else {
			viewObjects.remove(enemyCurrentHp);
		}
		setInfoText(loser.getName() + " has fainted.");
	}
	
	public void turn(int temp) {
		Thread turn = new Thread(new Runnable() {
			
			
			private void pause(int seconds) {
				try {
					Thread.sleep(seconds*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			public void run() {
				//System.out.println("Removing moves");
				removeMoves();
				if(enemyPokemon.getSpd() *(int)(enemyPokemon.getMultipliers()[enemyPokemon.getStageSpd()]) > userPokemon.getSpd() *(int)(userPokemon.getMultipliers()[userPokemon.getStageSpd()])) {
					System.out.println("Enemy goes first.");
					determinePokemonMove();
					currentAttack.attack(userPokemon,enemyPokemon);
					System.out.println(currentAttack.getName());
					pause(2);
					setInfoText("");
					if(!userPokemon.isAlive()) {
						System.out.println("User Fainted");
						endBattle(userPokemon);
					}else {
						Inventory.pokemon.getMoves().get(temp).attack(enemyPokemon, PokeStart.inventory.getPokemon());
						pause(2);
						setInfoText("");
						if(!enemyPokemon.isAlive()) {
							endBattle(enemyPokemon);
						}else {
							addMoves();
						}
					}
				}else {
					System.out.println("User goes first.");
					Inventory.pokemon.getMoves().get(temp).attack(enemyPokemon, PokeStart.inventory.getPokemon());
					pause(2);
					if(!enemyPokemon.isAlive()) {
						System.out.println("Enemy Fainted");
						endBattle(enemyPokemon);
					}else {
						determinePokemonMove();
						currentAttack.attack(userPokemon,enemyPokemon);
						System.out.println(currentAttack.getName());
						pause(2);
						setInfoText("");
						if(!userPokemon.isAlive()) {
							endBattle(userPokemon);
						}else {
							addMoves();
						}
					}
				}
				
			}
		});
		turn.start();
	
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PokeStart.setPokemonTextFont(24f);
		this.viewObjects = viewObjects;
		
	
		//set background
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		Graphic box = new Graphic(0,500,getWidth(),500,"resources/Box.jpg");
		
		//set user pokemon, hp and name
		info = new TextArea(90,530,getWidth(),getHeight(),"");
		userPokemonSprite = new Graphic(150,270,getWidth()/2,getHeight()/2,"resources/pokebacks/charmander back.png");
		CustomRect userTotalHp = new CustomRect(925,403,261,20,Color.red);
		userCurrentHp = new CustomRect(925,403,1,20,Color.green);
		userName = new TextLabel(890,350,500,100,"");
		
		//set enemy pokemon, hp and name
		//enemyPokemonSprite = new Graphic(825,60,getWidth()/2,getHeight()/2,"resources/pokebacks/charmander back.png");
		enemyCurrentHp = new CustomRect(273,146,1,20,Color.green);
		CustomRect enemyTotalHp = new CustomRect(273,146,261,20,Color.red);
		enemyName = new TextLabel(265,95,500,100,"");
		//TextArea userLevel = new TextArea(780,350,100,50,Integer.toString(userPokemon.getLevel()));
		//adding all objects to viewObjects
		viewObjects.add(battle);
		//viewObjects.add(enemyPokemonSprite);		
		viewObjects.add(userPokemonSprite);
		viewObjects.add(box);
		viewObjects.add(userTotalHp);
		viewObjects.add(userCurrentHp);
		viewObjects.add(enemyTotalHp);
		viewObjects.add(enemyCurrentHp);
		viewObjects.add(userName);
		viewObjects.add(enemyName);	
		viewObjects.add(info);
		//viewObjects.add(userLevel);
		setMoves(viewObjects);
	}
	
	public void removeMoves() {
		for(int i = 0 ; i < 4 ; i++) {
			if(buttonArr[i] != null) {
			viewObjects.remove(buttonArr[i]);
			//System.out.println("Removed moves");
			buttonArr[i].setEnabled(false);
			buttonArr[i].update();
			}
		}
	}
	
	public void addMoves() {
		for(int i = 0 ; i < 4 ; i++) {
			viewObjects.add(buttonArr[i]);
			PokeStart.setPokemonSunFont(36f);
			buttonArr[i].setText(Inventory.pokemon.getMoves().get(i).getName() + " " + Inventory.pokemon.getMoves().get(i).getCurrentPp() + "/" + Inventory.pokemon.getMoves().get(i).getPp());
			//System.out.println("Adding moves");
			if(userPokemon.getMoves().get(i) != null) {
				buttonArr[i].setEnabled(true);
			}else {
				buttonArr[i].setEnabled(false);
			}
			buttonArr[i].update();
		}
	}
	
	public void setMoves(List<Visible> viewObjects) {
		PokeStart.setPokemonSunFont(36f);
		int x = 125;
		int y = 530;
		buttonArr = new Button[4];
		for(int i = 0 ; i < 4 ; i++) {
			final int temp = i;
			if(i == 2) {
				x = 125;
				y = 620;
			}
			//System.out.println(Inventory.pokemon.getMoves().get(temp));
			if(Inventory.pokemon.getMoves().get(temp) != null) {
				Button button = new Button(x,y,500,65,Inventory.pokemon.getMoves().get(temp).getName() + " " + Inventory.pokemon.getMoves().get(temp).getCurrentPp() + "/" + Inventory.pokemon.getMoves().get(temp).getPp(), null);
				x+= 520;
				viewObjects.add(button);
				button.setBackground(new Color(0,0,0,140));
				button.update();
				button.setForeground(Color.white);
				this.buttonArr[i] = button;
			}else {
				Button button = new Button(x,y,500,65,"", null);
				x+= 520;
				viewObjects.add(button);
				button.setBackground(new Color(0,0,0,140));
				button.update();
				button.setForeground(Color.white);
				this.buttonArr[i] = button;
				buttonArr[temp].setEnabled(false);
			}
		}
	}

	public void determinePokemonMove() {
		if(enemyName.equals("Suicune")) {
			determineSuicuneMove();
		}
		else if(enemyName.equals("Entei")) {
			determineEnteiMove();
		}
		else {
			determineRaikouMove();
		}
	}

	public void determineSuicuneMove() {
		double chance = Math.random();
		if(chance < .4) {
			currentAttack = enemyPokemon.getMoves().get(2);
		}
		else if(chance < .7){
			currentAttack = enemyPokemon.getMoves().get(0);
		}
		else if(chance < .9){
			currentAttack = enemyPokemon.getMoves().get(1);
		}
		else {
			currentAttack = enemyPokemon.getMoves().get(3);
		}
	}

	public void determineEnteiMove() {
		double chance =  Math.random();
		if(chance < .4) {
			currentAttack = enemyPokemon.getMoves().get(2);
		}
		else if(chance < .7){
			currentAttack = enemyPokemon.getMoves().get(0);
		}
		else if(chance < .9){
			currentAttack = enemyPokemon.getMoves().get(1);
		}
		else {
			currentAttack = enemyPokemon.getMoves().get(3);	
		}
	}

	public void determineRaikouMove() {
		double chance =  Math.random();
		if(chance < .4) {
			currentAttack = enemyPokemon.getMoves().get(1);
		}
		else if(chance < .7){
			currentAttack = enemyPokemon.getMoves().get(3);
		}
		else if(chance < .9){
			currentAttack = enemyPokemon.getMoves().get(0);
		}
		else {
			currentAttack = enemyPokemon.getMoves().get(3);
		}
		
	}
	
	public void setEnemyAnimation(String str) {
		if(str.equals("Suicune")) {
			enemyAnimation = new AnimatedComponent(800,60,350,250);
			for(int i = 0; i < 4; i++) {
				enemyAnimation.addSequence("resources/spritesheets/Suicune Animated.png", 100, 0, 5, 85, 69, 10);
				enemyAnimation.addSequence("resources/spritesheets/Suicune Animated.png", 100, 0, 75, 85, 70, 6);
			}
			enemyAnimation.addSequence("resources/spritesheets/Suicune Animated.png", 100, 0, 148, 85, 70, 10);
			enemyAnimation.addSequence("resources/spritesheets/Suicune Animated.png", 100, 0, 221, 85, 72, 6);
		}
		else if(str.equals("Entei")) {
			enemyAnimation = new AnimatedComponent(800,60,350,250);
			for(int i = 0; i < 4; i++) {
				enemyAnimation.addSequence("resources/spritesheets/Entei Animated.png", 150, 1, 1, 78, 71, 7);
			}
			enemyAnimation.addSequence("resources/spritesheets/Entei Animated.png", 150, 1, 73, 78, 71, 10);
			enemyAnimation.addSequence("resources/spritesheets/Entei Animated.png", 150, 0, 148, 77, 71, 4);
		}
		else if(str.equals("Raikou")) {
			enemyAnimation = new AnimatedComponent(800,60,350,250);
			for(int i = 0; i < 4; i++) {
				enemyAnimation.addSequence("resources/spritesheets/Raikou Animated.png", 150, 0, 1, 86, 71, 9);
			}
			enemyAnimation.addSequence("resources/spritesheets/Raikou Animated.png", 150, 0, 74, 86, 71, 1);
			enemyAnimation.addSequence("resources/spritesheets/Raikou Animated.png", 150, 82, 74, 86, 71, 9);
			enemyAnimation.addSequence("resources/spritesheets/Raikou Animated.png", 150, 1, 148, 86, 71, 10);
			//enemyAnimation.addSequence("resources/spritesheets/Raikou Animated.png", 150, 82, 148, 86, 71, 9);
		}
	}
}