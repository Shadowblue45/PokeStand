package rickyShopInteract;

import java.util.List;

import garrettPokemonTraining.Inventory;
import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
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
		displayPokemon(viewObjects);
		interact(viewObjects);
		
	}
	
	public void displayPokemon(List<Visible> viewObjects) {
		Graphic background = new Graphic(0,0,getWidth(),getHeight(),"resources/interact.png");
		String name = PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex];
		int h = getHeight()/2;
		int w = getWidth()/2;
		Graphic g = new Graphic(440, 200, 400, 400,"resources/" + PokeStart.inventory.getPokemon().getType1().toLowerCase() + "/" + name + ".png");
		viewObjects.add(background);
		viewObjects.add(g);
	}
	
	public void interact(List<Visible> viewObjects) {
		Graphic tb = new Graphic(440, 550, 500, 150,"resources/text box.png");
		PokeStart.setPokemonGBFont(14f);
		TextArea ta = new TextArea(455,575,425,150,"Would you like to \ninteract with your " +PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex] + "?");
		viewObjects.add(tb);
		
		viewObjects.add(ta);
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

