package rickyShopInteract;

import guiTeacher.GUIApplication;

public class RickyUpgrades extends GUIApplication {

	public RickyUpgrades(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		setScreen(new RickyUpgradesScreen(getWidth(),getHeight()));			
	}

	public static void main(String[] args) {
		new Thread(new RickyUpgrades(1280,720)).start();
	}
	
}
