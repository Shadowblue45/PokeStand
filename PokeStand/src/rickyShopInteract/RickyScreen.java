package rickyShopInteract;

import guiTeacher.GUIApplication;

public class RickyScreen extends GUIApplication{
	
	private static final long serialVersionUID = 7184253047922088672L;
	private static RickyScreen runner;

	public RickyScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		setScreen(new RickyShop(getWidth(),getHeight()));
	}
	
	public static void main(String[] args) {
		new Thread(new RickyScreen(1280,720)).start();
	}

}
