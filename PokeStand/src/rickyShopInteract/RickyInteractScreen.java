package rickyShopInteract;

import java.util.List;

import garrettPokemonTraining.Pokemon;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startGame.PokeStart;

public class RickyInteractScreen extends FullFunctionScreen {
	
	private Button backButton;

	private static final long serialVersionUID = -9057104999011157193L;

	public RickyInteractScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(false);
		displayPokemon(viewObjects);
		interact(viewObjects);
		addBackButton(viewObjects);	

	}
	
	public void displayPokemon(List<Visible> viewObjects) {
		Graphic background = new Graphic(0,0,getWidth(),getHeight(),"resources/interact background.png");
		String name = PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex];
		Graphic g = new Graphic(440, 200, 400, 400,"resources/" + PokeStart.inventory.getPokemon().getType1().toLowerCase() + "/" + name + ".png");
		viewObjects.add(background);
		Graphic h = new Graphic(640,360,getWidth()/2,getHeight()/2,"resources/" + PokeStart.inventory.getPokemon().getType1().toLowerCase() + "/" + name + ".png");
		viewObjects.add(h);
		viewObjects.add(g);
	}
	
	public void interact(List<Visible> viewObjects) {
		Graphic tb = new Graphic(440, 550, 500, 150,"resources/text box.png");
		PokeStart.setPokemonGBFont(16f);
		TextArea ta = new TextArea(455,575,425,150,"Would you like to \ninteract with your " +PokeStart.inventory.pokemonForms[PokeStart.inventory.pokemonIndex] + "?");
//		TextArea yes = new TextArea()
//		TextArea no = new TextArea()
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
	
	public void addBackButton(List<Visible> viewObjects) {
		backButton = new Button(50,625,100,100, "Back", new Action() {
			@Override
			public void act() {
				PokeStart.start.setScreen(PokeStart.mainMenuScreen);
				PokeStart.mainScreen =! PokeStart.mainScreen;
			}
		});
		viewObjects.add(backButton);
	}
}

