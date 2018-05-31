
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
		setScreen(new RickyScreen(getWidth(),getHeight()));
	}
	
	public static void main(String[] args) {
		new Thread(new RickyShop(1280,720)).start();
	}

}
