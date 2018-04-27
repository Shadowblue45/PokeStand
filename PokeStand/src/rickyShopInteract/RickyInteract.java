package rickyShopInteract;

import guiTeacher.GUIApplication;

public class RickyInteract extends GUIApplication {

	public RickyInteract(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		setScreen(new RickyInteractScreen(getWidth(),getHeight()));		
	}
	
	public static void main(String[] args) {
		new Thread(new RickyInteract(1280,720)).start();
	}

}
