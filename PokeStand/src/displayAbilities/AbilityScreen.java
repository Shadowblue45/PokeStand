package displayAbilities;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class AbilityScreen extends FullFunctionScreen {

	public AbilityScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		Graphic background = new Graphic(100, 0, getWidth(),getHeight(), "resources/good.png");
		viewObjects.add(background);
		
	}

}
