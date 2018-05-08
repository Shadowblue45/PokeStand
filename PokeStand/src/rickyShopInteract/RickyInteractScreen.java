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
		if(PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex].equals("Charmander")) {
			Graphic g = new Graphic(0,0,getWidth(),getHeight(),"resources/interact/Charmander.gif");
		}
		else if (PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex].equals("Charmeleon")) {
			
		}
		else if (PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex].equals("Charizard")) {
		
		}
		else if (PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex].equals("")) {
			
		}
	}

}
