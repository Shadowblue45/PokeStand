package battle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fahadStartupandMenuScreen.CustomRect;
import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.Move;
import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class BattleScreen extends FullFunctionScreen{
	
	private CustomRect userCurrentHp;
	private TextLabel userName;
	private Graphic userPokemon;
	
	private Graphic enemyPokemonSprite;
	private Pokemon enemyPokemon;
	private TextLabel enemyName;
	private CustomRect enemyCurrentHp;
	private ArrayList<Move> moves;
	private Move currentAttack;
	
	public BattleScreen(int width, int height) {
		super(width, height);
	}

	public void startBattle() {
		String[] pokeNames = PokeStart.inventory.getNames();
		String[] actions = {"","",""};
		int index = PokeStart.inventory.pokemonIndex;
		enemyPokemon = PokeStart.selectionScreen.getEnemyPokemon();
		
		//Set user's pokemon's current stats to the current max
		Inventory.pokemon.setCurrentHp(Inventory.pokemon.getHp());
	
		//Set enemy pokemon's current stats to the current max
		enemyPokemon.setCurrentHp(enemyPokemon.getHp());
		
		int userCurrent = Inventory.pokemon.getCurrentHp();
		int userHpSize = (int) (260*userCurrent)/(Inventory.pokemon.getHp());
		
		int enemyCurrent = enemyPokemon.getCurrentHp();
		int enemyHpSize = (int) (260*enemyCurrent)/(enemyPokemon.getHp());
		
		//Test if these conditions are set
		System.out.println("\nHp Size : " + userHpSize);
		System.out.println("\nHp : " + Inventory.pokemon.getHp());
		System.out.println("current HP is "+Inventory.pokemon.getCurrentHp());
		
		System.out.println("\nEnemy hp Size : " + enemyHpSize);
		System.out.println("\nEnemy hp : "+enemyPokemon.getHp());
		System.out.println("current HP is "+enemyPokemon.getCurrentHp());
		
			
		//changing user graphics
		userCurrentHp.setDimensions((int)(userHpSize+1), 20);
		userName.setText(pokeNames[index]);
		userPokemon.loadImages("resources/pokebacks/"+pokeNames[index]+ " back.png", getWidth()/2,getHeight()/2);
		
		//changing enemy graphics
		enemyCurrentHp.setDimensions((int)(enemyHpSize+1), 20);
		enemyPokemonSprite.loadImages("resources/pokefronts/"+ enemyPokemon.getName() + " Front.png", getWidth()/3, getHeight()/3);
		enemyName.setText(enemyPokemon.getName());
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PokeStart.setPokemonTextFont(24f);
		//set background
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		Graphic box = new Graphic(0,500,getWidth(),500,"resources/Box.jpg");
		
		//set user pokemon, hp and name
		userPokemon = new Graphic(150,270,getWidth()/2,getHeight()/2,"resources/pokebacks/charmander back.png");
		CustomRect userTotalHp = new CustomRect(925,402,260,20,Color.red);
		userCurrentHp = new CustomRect(925,402,1,20,Color.green);
		userName = new TextLabel(890,350,500,100,"");
		
		//set enemy pokemon, hp and name
		enemyPokemonSprite = new Graphic(825,60,getWidth()/2,getHeight()/2,"resources/pokebacks/charmander back.png");
		enemyCurrentHp = new CustomRect(273,146,1,20,Color.green);
		CustomRect enemyTotalHp = new CustomRect(273,146,260,20,Color.red);
		enemyName = new TextLabel(265,95,500,100,"");
		
		//adding all objects to viewObjects
		viewObjects.add(battle);
		viewObjects.add(enemyPokemonSprite);		
		viewObjects.add(userPokemon);
		viewObjects.add(box);
		viewObjects.add(userTotalHp);
		viewObjects.add(userCurrentHp);
		viewObjects.add(enemyTotalHp);
		viewObjects.add(enemyCurrentHp);
		viewObjects.add(userName);
		viewObjects.add(enemyName);
	}
	
	public void setMoves() {
		this.moves = PokeStart.inventory.pokemon.getMoves();
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
		int chance = (int) Math.random();
		if(chance < .4) {
			currentAttack = enemyPokemon.moves.get(2);
		}
		else if(chance < .7){
			currentAttack = enemyPokemon.moves.get(0);
		}
		else if(chance < .9){
			currentAttack = enemyPokemon.moves.get(1);
		}
		else {
			currentAttack = enemyPokemon.moves.get(3);
		}
	}

	public void determineEnteiMove() {
		int chance = (int) Math.random();
		if(chance < .4) {
			currentAttack = moves.get(2);
		}
		else if(chance < .7){
			currentAttack = moves.get(0);
		}
		else if(chance < .9){
			currentAttack = moves.get(1);
		}
		else {
			currentAttack = moves.get(3);	
		}
	}

	public void determineRaikouMove() {
		int chance = (int) Math.random();
		if(chance < .4) {
			currentAttack = moves.get(1);
		}
		else if(chance < .7){
			currentAttack = moves.get(3);
		}
		else if(chance < .9){
			currentAttack = moves.get(0);
		}
		else {
			currentAttack = moves.get(3);
		}
		
	}
}
