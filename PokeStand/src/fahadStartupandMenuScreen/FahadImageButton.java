package fahadStartupandMenuScreen;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;

public class FahadImageButton extends Button {

	public FahadImageButton(int x, int y, int w, int h, Graphic g, String text, String link, Action action) {
		super(x, y, w, h, text, action);
		g = new Graphic(x, y, w, h, link);
	}

}
