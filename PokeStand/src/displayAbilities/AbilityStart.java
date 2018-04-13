package displayAbilities;

import guiTeacher.GUIApplication;
import selectionScreen.SelectionScreen;
import selectionScreen.SelectionStart;

public class AbilityStart extends GUIApplication{
	public static AbilityStart ability;
	public static AbilityScreen abilityS;

	public AbilityStart(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		abilityS = new AbilityScreen(getWidth(), getHeight());
		setScreen(abilityS);

	}

	public static void main(String[] args) {
		ability = new AbilityStart(1280, 720);
		Thread go = new Thread(ability);
		go.start();
	}

}

