package battle;

import java.awt.Color;
import java.util.List;

import fahadStartupandMenuScreen.CustomRect;
import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class BattleScreen extends FullFunctionScreen{
	
	private CustomRect currentHp;
	private TextLabel name;
	private Graphic userPokemon;
	private Graphic enemyPokemonSprite;
	private Pokemon enemyPokemon;
	
	public BattleScreen(int width, int height) {
		super(width, height);
	}

	public void startBattle() {
		String[] pokeNames = PokeStart.inventory.getNames();
		int index = PokeStart.inventory.pokemonIndex;
		enemyPokemon = PokeStart.selectionScreen.getEnemyPokemon();
		//enemyPokemon = new Pokemon("Suicune","Water",null,310,139,211,166,211,157,null);	
		Inventory.pokemon.setCurrentHp(Inventory.pokemon.getHp());
		int current = Inventory.pokemon.getCurrentHp();
		int hpSize = (int) (260*current)/(Inventory.pokemon.getHp());
		System.out.println("\nHp Size : " + hpSize);
		System.out.println(Inventory.pokemon.getHp());
		System.out.println("current HP is "+Inventory.pokemon.getCurrentHp());
		currentHp.setDimensions((int)(hpSize+1), 20);
		name.setText(pokeNames[index]);
		System.out.println("enemyName is "+ enemyPokemon.getName());
		userPokemon.loadImages("resources/pokebacks/"+pokeNames[index]+ " back.png", getWidth()/2,getHeight()/2);
		enemyPokemonSprite.loadImages("resources/pokefronts/"+ enemyPokemon.getName() + " front.png", getWidth()/2, getHeight()/2);
		
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		userPokemon = new Graphic(150,250,getWidth()/2,getHeight()/2,"resources/pokebacks/charmander back.png");
		enemyPokemonSprite = new Graphic(820,60,getWidth()/2,getHeight()/2,"resources/pokebacks/charmander back.png");
		Graphic box = new Graphic(0,500,getWidth(),500,"resources/Box.jpg");
		CustomRect totalHp = new CustomRect(925,402,260,20,Color.red);
		name = new TextLabel(910,350,300,50,"");
		currentHp = new CustomRect(925,402,1,20,Color.green);
		viewObjects.add(battle);
		viewObjects.add(enemyPokemonSprite);		
		viewObjects.add(userPokemon);
		viewObjects.add(box);
		viewObjects.add(totalHp);
		viewObjects.add(currentHp);
		viewObjects.add(name);
	}
}
