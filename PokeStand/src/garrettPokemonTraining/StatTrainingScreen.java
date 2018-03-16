package garrettPokemonTraining;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.SimpleTable;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import startupandMenuScreen.CustomRect;

public class StatTrainingScreen extends FullFunctionScreen {

	private SimpleTable stats;
	private Graphic target;
	private Button start;

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
		target = new Graphic(880, 115, 200, 200,"resources/Sandbag.png");
		viewObjects.add(target);
		viewObjects.add(rect);
		start = new Button(630,390,100,50,"Start",new Action() {

			@Override
			public void act() {
				viewObjects.remove(rect);
				viewObjects.remove(start);
			}

		});
		start.setBackground(Color.WHITE);
		start.update();
		viewObjects.add(start);
	}

}
