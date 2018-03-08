package garrettPokemonTraining;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TrainingScreen extends FullFunctionScreen {
	
	private Button evolveButton;
	private Button saveButton;
	private TextArea info;

	public TrainingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		Graphic poke = new Graphic(125, 105, 300, 300,"resources/fire/Charmander.png");
		viewObjects.add(poke);
		info = new TextArea(400,200,200,500,"Name: " + PokemonTest.inventory.getPokemon().getName() + "\n" + "Type1: " + PokemonTest.inventory.getPokemon().getType1() + "\n" +
				"Type2: " + PokemonTest.inventory.getPokemon().getType2() + "\n" + "HP: " + PokemonTest.inventory.getPokemon().getHp() + "\n" + 
				"Atk: " + PokemonTest.inventory.getPokemon().getAtk() + "\n" + "Def: " + PokemonTest.inventory.getPokemon().getDef() + "\n" +
				"Special Atk: " + PokemonTest.inventory.getPokemon().getsAtk() + "\n" + "Special Def: " + PokemonTest.inventory.getPokemon().getsDef() + "\n" +
				"Spd: " + PokemonTest.inventory.getPokemon().getSpd() + "\n");
		viewObjects.add(info);
		evolveButton = new Button(100,100,50,50,"Evolve", new Action() {

			@Override
			public void act() {
				PokemonTest.inventory.getPokemon().evolve();
				info.setText("Name: " + PokemonTest.inventory.getPokemon().getName() + "\n" + "Type1: " + PokemonTest.inventory.getPokemon().getType1() + "\n" +
						"Type2: " + PokemonTest.inventory.getPokemon().getType2() + "\n" + "HP: " + PokemonTest.inventory.getPokemon().getHp() + "\n" + 
						"Atk: " + PokemonTest.inventory.getPokemon().getAtk() + "\n" + "Def: " + PokemonTest.inventory.getPokemon().getDef() + "\n" +
						"Special Atk: " + PokemonTest.inventory.getPokemon().getsAtk() + "\n" + "Special Def: " + PokemonTest.inventory.getPokemon().getsDef() + "\n" +
						"Spd: " + PokemonTest.inventory.getPokemon().getSpd() + "\n");
				
			}
			
		});
		viewObjects.add(evolveButton);
		saveButton = new Button(100,200,50,50,"Save", new Action() {

			@Override
			public void act() {
				PokemonTest.inventory.save();
			}
			
		});
		viewObjects.add(saveButton);
		
	}

}
