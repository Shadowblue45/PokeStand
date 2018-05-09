package rickyShopInteract;

import java.util.List;

import garrettPokemonTraining.Inventory;
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
		changeFatigue();
	}
	
	public void displayGif(List<Visible> viewObjects) {
		String name = PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex];
		Graphic g = new Graphic(0,0,getWidth(),getHeight(),"resources/interact/" + name + ".gif");
		viewObjects.add(g);
	}
	
	public void changeFatigue() {
		if(PokeStart.inventory.fatigue > 10) { 
			PokeStart.inventory.fatigue -= 10;
		}	
		else PokeStart.inventory.fatigue = 0;
	}
	
	public void changeStats() {
		GarrettPokemonTraining.Pokemon.setHP(getHP() + 1);
		GarrettPokemonTraining.Pokemon.setAtk(getAtk() + 1);
		GarrettPokemonTraining.Pokemon.setDef(getDef() + 1);
		GarrettPokemonTraining.Pokemon.setsAtk(getsAtk() + 1);
		GarrettPokemonTraining.Pokemon.setsDef(getsDef() + 1);
		GarrettPokemonTraining.Pokemon.setSpd(getSpd() + 1);
	}
	
	}

