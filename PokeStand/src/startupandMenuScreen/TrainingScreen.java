package startupandMenuScreen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import startGame.PokeStart;

public class TrainingScreen extends FullFunctionScreen {

	private int xCord;
	private int yCord;

	public TrainingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		resetCoordinates();
		StyledComponent.setButtonOutline(true);
		StyledComponent.setActiveBorderColor(Color.white);
		Screen[] screens = {PokeStart.mainMenuScreen, PokeStart.loadScreen,null,null,null,null};
		String[] names = {"Back", "Train ATK", "Train DEF", "Train SATK", "Train SDEF", "Train SPD"};
		CustomRect rect = new CustomRect(0,yCord-20,getWidth(),120);
		CustomRect square = new CustomRect(980,0,300,200);
		resetCoordinates();
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Pokemon Arena.jpg");
		PokeStart.setPokemonGBFont(100f);
		TextArea daysNum = new TextArea(1050,40, 500, 300, "30");
		PokeStart.setPokemonTextFont(32f);
		TextArea daysRemaining = new TextArea(1000,140, 500, 300, "Days Left");
		viewObjects.add(background);
		viewObjects.add(rect);
		viewObjects.add(square);
		viewObjects.add(daysNum);
		viewObjects.add(daysRemaining);
		daysNum.setCustomTextColor(Color.white);
		daysRemaining.setCustomTextColor(Color.white);
		setMenuButtons(names, viewObjects, screens);
	}
	
	public void setMenuButtons(String[] names, List<Visible> viewObjects, Screen[] screens) {
		PokeStart.setPokemonTextFont(24f);
		initButtons(names, viewObjects, screens);
		resetCoordinates();
		PokeStart.setPokemonTextFont(32f);
	}

	public void resetCoordinates() {
		xCord = 10;
		yCord = 600;
	}

	public void initButtons(String[] names, List<Visible> viewObjects, Screen[] screens) {
		for(int i = 0; i < names.length; i++) {
			Screen temp = screens[i];
			Button button = new Button (xCord, yCord, 200,70,names[i],new Action() {
				
				public void act() {
					PokeStart.start.setScreen(temp);
				}
			});
			xCord += 210;
			viewObjects.add(button);
			button.setBackground(new Color(0,0,0,140));
			button.update();
			button.setForeground(Color.white);
		}
	}
}
