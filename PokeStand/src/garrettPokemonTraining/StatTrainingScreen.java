package garrettPokemonTraining;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.SimpleTable;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startupandMenuScreen.CustomRect;

public class StatTrainingScreen extends FullFunctionScreen {

	private SimpleTable stats;
	private Graphic target;
	private Button start;
	private Button evolveButton;
	private Button saveButton;
	private TextArea info;
	private Graphic poke;
	private Pokemon p;

	public StatTrainingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		PokemonTest.setPokemonFont(20);
		CustomRect rect = new CustomRect(0,0,getWidth(),getHeight(),new Color(0,0,0,200));
		Graphic battle = new Graphic(0,0,getWidth(),getHeight(),"resources/pokebattle.jpg");
		viewObjects.add(battle);
		p = PokemonTest.inventory.getPokemon();
		poke = new Graphic(625, 105, 300, 300,p.getImage());
		viewObjects.add(poke);
		target = new Graphic(880, 115, 200, 200,"resources/Sandbag.png");
		viewObjects.add(target);
		viewObjects.add(rect);
		start = new Button(630,390,100,50,"Start",new Action() {

			@Override
			public void act() {
				viewObjects.remove(rect);
				viewObjects.remove(start);
				start.setEnabled(false);
			}

		});
		start.setBackground(Color.WHITE);
		start.update();
		viewObjects.add(start);
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
				poke = new Graphic(625, 105, 300, 300,p.getImage());
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
		Button test = new Button(200,200,50,50,"Test",new Action() {

			@Override
			public void act() {
				PokemonTest.inventory.getPokemonImages();
			}
			
		});
		viewObjects.add(test);
	}

}
