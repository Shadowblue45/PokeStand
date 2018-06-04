package rickyShopInteract;

import guiTeacher.GUIApplication;

public class RickyUpgrades extends GUIApplication {

	public RickyUpgrades(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Thread(new RickyUpgrades(1280,720)).start();
	}
	
}
