package selectionScreen;

import guiTeacher.GUIApplication;   
import guiTeacher.userInterfaces.Screen;
import audioPlayer.AudioTest; 

public class SelectionStart extends GUIApplication {
	
	public static SelectionStart select;
	public static SelectionScreen selectS;

	public SelectionStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		selectS = new SelectionScreen(getWidth(), getHeight());
		setScreen(selectS);

	}

	public static void main(String[] args) {
		select = new SelectionStart(1280, 720);
		Thread go = new Thread(select);
		go.start();
	}

}
