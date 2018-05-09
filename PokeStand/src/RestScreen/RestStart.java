package RestScreen;

import displayAbilities.AbilityScreen;
import displayAbilities.AbilityStart;
import guiTeacher.GUIApplication;

public class RestStart extends GUIApplication {
	
	public static RestStart rest;
	public static RestScreen restS;


	public RestStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		restS = new RestScreen(getWidth(), getHeight());
		setScreen(restS);
		
	}
	
	public static void main(String[] args) {
		rest = new RestStart(1280, 720);
		Thread go = new Thread(rest);
		go.start();
	}


}
