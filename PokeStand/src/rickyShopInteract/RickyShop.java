package rickyShopInteract;

import guiTeacher.GUIApplication;

public class RickyShop extends GUIApplication{
	
	private static final long serialVersionUID = 7184253047922088672L;
	private static RickyShop runner;

	public RickyShop(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		RickyScreen Rs = new RickyScreen(getWidth(),getHeight());
		setScreen(Rs);
	}
	
	public static void main(String[] args) {
		runner = new RickyShop(1280,720);
		Thread go = new Thread(runner);
		go.start();
	}

}
