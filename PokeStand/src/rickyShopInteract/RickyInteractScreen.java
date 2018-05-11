package rickyShopInteract;

import java.util.List;

import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class RickyInteractScreen extends FullFunctionScreen {

	private static final long serialVersionUID = -9057104999011157193L;

	public RickyInteractScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		displayGif(viewObjects);
//		changeFatigue();
//		changeStats();
	}
	
	public void displayGif(List<Visible> viewObjects) {
		String name = PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex];
		Graphic g = new Graphic(0,0,getWidth(),getHeight(),"resources/" + PokeStart.inventory.getPokemon().getType1().toLowerCase() + "/" + name + ".png");
		viewObjects.add(g);
	}
	
	public void changeFatigue() {
		if(PokeStart.inventory.fatigue > 10) { 
			PokeStart.inventory.fatigue -= 10;
		}	
		else PokeStart.inventory.fatigue = 0;
	}
	
	public void changeStats() {
		Pokemon pocketmonster = PokeStart.inventory.getPokemon();
		
		pocketmonster.setHp(PokeStart.inventory.getPokemon().getHp() + 1);
		pocketmonster.setAtk(pocketmonster.getAtk() + 1);
		pocketmonster.setDef(pocketmonster.getDef() + 1);
		pocketmonster.setsAtk(pocketmonster.getsAtk() + 1);
		pocketmonster.setsDef(pocketmonster.getsDef() + 1);
		pocketmonster.setSpd(pocketmonster.getSpd() + 1);
	}	
}

