package startupandMenuScreen;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainMenuScreen extends FullFunctionScreen {
	
	private String[] resourceLinks;
	private int xCord;
	private int yCord;
	private Button button;

	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		initAllValues();
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/Pokemon Arena.jpg");
		viewObjects.add(background);
		initButtons(viewObjects);
	}
	
	public void initAllValues() {
		xCord = 40;
		yCord = 600;
		resourceLinks[0] = "resources/Pokemon Arena.jpg";
	}

	public void initButtons(List<Visible> viewObjects) {
		for(int i = 0; i < resourceLinks.length; i++) {
			button = new Button(xCord, yCord, 100,100,links[i],null);
			xCord = xCord + 120;
			viewObjects.add(button);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
