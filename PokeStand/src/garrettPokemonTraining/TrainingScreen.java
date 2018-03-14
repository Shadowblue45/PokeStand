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
	private Graphic poke;
	private Pokemon p;

	public TrainingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		p = PokemonTest.inventory.getPokemon();
		poke = new Graphic(625, 105, 300, 300,"resources/" + p.getType1().toLowerCase() + "/" + PokemonTest.inventory.getPokemon().getName() + ".png");
		viewObjects.add(poke);
		info = new TextArea(400,200,200,500,"Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
				"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
				"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
				"Special Atk: " + p.getsAtk() + "\n" + "Special Def: " + p.getsDef() + "\n" +
				"Spd: " + p.getSpd() + "\n");
		viewObjects.add(info);
		evolveButton = new Button(100,100,50,50,"Evolve", new Action() {

			@Override
			public void act() {
				p.evolve();
				info.setText("Name: " + p.getName() + "\n" + "Type1: " + p.getType1() + "\n" +
						"Type2: " + p.getType2() + "\n" + "HP: " + p.getHp() + "\n" + 
						"Atk: " + p.getAtk() + "\n" + "Def: " + p.getDef() + "\n" +
						"Special Atk: " + p.getsAtk() + "\n" + "Special Def: " + p.getsDef() + "\n" +
						"Spd: " + p.getSpd() + "\n");
				viewObjects.remove(poke);
				poke = new Graphic(625, 105, 300, 300,"resources/" + p.getType1().toLowerCase() + "/" + PokemonTest.inventory.getPokemon().getName() + ".png");
				viewObjects.add(poke);
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
