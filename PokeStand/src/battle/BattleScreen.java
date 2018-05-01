package battle;

import java.awt.Color;
import java.util.List;

import fahadStartupandMenuScreen.CustomRect;
import garrettPokemonTraining.Inventory;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class BattleScreen extends FullFunctionScreen{
	
	CustomRect currentHp;
	TextLabel name;
	Graphic userPokemon;
	
	public BattleScreen(int width, int height) {
		super(width, height);
	}

	public void startBattle() {
		String[] pokeNames = PokeStart.inventory.getNames();
		int index = PokeStart.inventory.pokemonIndex;
		Inventory.pokemon.setCurrentHp(Inventory.pokemon.getHp());
		int current = Inventory.pokemon.getCurrentHp();
		int hpSize = (int) (265*current)/(Inventory.pokemon.getHp());
		System.out.println("\nHp Size : " + hpSize);
		System.out.println(Inventory.pokemon.getHp());
		System.out.println("current HP is "+Inventory.pokemon.getCurrentHp());
		currentHp.setDimensions((int)(hpSize+1), 20);
		name.setText(pokeNames[index]);
		
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		userPokemon = new Graphic(150,250,getWidth()/2,getHeight()/2,"resources/pokebacks/charmander back.png");
		Graphic box = new Graphic(0,500,getWidth(),500,"resources/Box.jpg");
		CustomRect totalHp = new CustomRect(925,400,265,20,Color.red);
		name = new TextLabel(910,350,300,50,"");
		currentHp = new CustomRect(925,400,1,20,Color.green);
		viewObjects.add(battle);
		viewObjects.add(userPokemon);
		viewObjects.add(box);
		viewObjects.add(totalHp);
		viewObjects.add(currentHp);
		viewObjects.add(name);
	}
}
