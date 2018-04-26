package fahadStartupandMenuScreen;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class CustomRect extends Component {
	
	private Color color;

	public CustomRect(int x, int y, int w, int h, Color color) {
		super(x, y, w, h);
		this.color = color;
		update();
	}

	public CustomRect(int x, int y, int w, int h) {
		super(x, y, w, h);
		color = new Color(0,0,0,140);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(color);
		//g.fillRect(0, 0, getWidth(), getHeight());
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 12,12);
	}

}
