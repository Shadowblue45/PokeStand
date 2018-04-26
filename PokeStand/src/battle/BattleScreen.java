package battle;

import java.util.List;

import garrettPokemonTraining.Inventory;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen{
	
	private String name = Inventory.pokemon.getName();
	
	public BattleScreen(int width, int height) {
		super(width, height);
		Graphic userPokemon = new Graphic(150,250,getWidth()/2,getHeight()/2,"resources/pokebacks/ "+ name +" back.png");
		addObject(userPokemon);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		System.out.println(name);
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		viewObjects.add(battle);
		Graphic box = new Graphic(0,500,getWidth(),500,"resources/Box.jpg");
		viewObjects.add(box);
	}

}
