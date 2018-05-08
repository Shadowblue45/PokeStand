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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		displayGif(viewObjects);
		changeFatigue();
	}
	
	public void displayGif(List<Visible> viewObjects) {
		String name = PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex];
		Graphic g = new Graphic(0,0,getWidth(),getHeight(),"resources/interact/" + name + ".gif");
	}
	
	public void changeFatigue() {
		if(PokeStart.inventory.fatigue > 10) { 
			PokeStart.inventory.fatigue -= 10;
		}	
		else PokeStart.inventory.fatigue = 0;
	}
	
	}

