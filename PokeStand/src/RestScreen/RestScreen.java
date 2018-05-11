package RestScreen;

import java.util.List;

import audioPlayer.AudioTest;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class RestScreen extends FullFunctionScreen {

	Graphic background;
	int i =0;

	public RestScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
	    background = new Graphic(0, 0, getWidth(),getHeight(), "resources/HealAnimation/0.jpg");
		viewObjects.add(background);		
		
		
		Button test = new Button(175,200,100,100,"Yes",new Action() {
			
			@Override
			public void act() {
				AudioTest.playSound("resources/Music/rest.wav");
				
				background.loadImages("resources/HealAnimation/"+i+".jpg", getWidth(), getHeight());
				background.update();
				i++;
				System.out.println(i);
				
			}
		});
		viewObjects.add(test);		
		
				
		
	}

}
