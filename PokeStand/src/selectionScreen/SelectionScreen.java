package selectionScreen;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SelectionScreen extends FullFunctionScreen {
	
	AnimatedComponent charmander;
	AnimatedComponent chimchar;
	AnimatedComponent cyndaquil;
	AnimatedComponent froakie;
	AnimatedComponent mudkip;
	AnimatedComponent popplio;
	AnimatedComponent snivy;
	AnimatedComponent treecko;
	AnimatedComponent turtwig;

	public SelectionScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "resources/selectionbgrnd.jpg");
		viewObjects.add(background);
		
		setPokemon();
		
		TextArea title = new TextArea(350,10,600,50,"CHOOSE YOUR STARTER");
		title.setCustomTextColor(Color.WHITE);
		viewObjects.add(title);
		
		
		charmander = new AnimatedComponent(250, 265, 75, 75);
		charmander.addSequence("resources/spritesheetsTrans/charmander sprite.png", 150, 0, 0, 40, 39, 3);
		Thread run = new Thread(charmander);
		run.start();
		viewObjects.add(charmander);
		
		chimchar = new AnimatedComponent(250, 350, 75, 75);
		chimchar.addSequence("resources/spritesheetsTrans/chimchar sprite.png", 150, 11,54, 56, 49, 10);
		Thread run2 = new Thread(chimchar);
		run2.start();
		viewObjects.add(chimchar);
		
		cyndaquil = new AnimatedComponent(250, 450, 75, 75);
		cyndaquil.addSequence("resources/spritesheetsTrans/cyndaquil sprite.png", 150, 0, 0,49, 38, 10);
		Thread run3 = new Thread(cyndaquil);
		run3.start();
		viewObjects.add(cyndaquil);
		
		froakie = new AnimatedComponent(450, 265, 75, 75);
		froakie.addSequence("resources/spritesheetsTrans/froakie sprite sheet.png", 150, 8, 25, 62, 41, 4);
		Thread run4 = new Thread(froakie);
		run4.start();
		viewObjects.add(froakie);
		
		popplio = new AnimatedComponent(450, 350, 75, 75);
		popplio.addSequence("resources/spritesheetsTrans/popplio sprite.png", 150, 2,3, 62, 50, 4);
		Thread run5= new Thread(popplio);
		run5.start();
		viewObjects.add(popplio);
		
		mudkip = new AnimatedComponent(450, 450, 75, 75);
		mudkip.addSequence("resources/spritesheetsTrans/mudkip sprite.png", 150, 0, 0,49, 38, 3);
		Thread run6 = new Thread(mudkip);
		run6.start();
		viewObjects.add(mudkip);
		
		
		
		
	}
	
	public void setPokemon() {
		try {
		File fontFile = new File("resources/Pokemon Text.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		Font baseFont=font.deriveFont(35f);
		StyledComponent.setBaseFont(baseFont);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
