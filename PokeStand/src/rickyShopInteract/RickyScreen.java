package rickyShopInteract;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;

import guiTeacher.userInterfaces.FullFunctionScreen;

public class RickyScreen extends FullFunctionScreen {

	private ArrayList<String> itemsInShop;
	private ArrayList<String> itemDesc;
	private int dollars = 0;
	
	private static final long serialVersionUID = 5855860528658762993L;

	public RickyScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addItemsToArrayList();
		addBackgroundLabel(viewObjects);
		addImagestoShop(viewObjects);
		setPokemonFont(16);
		itemDescriptions(viewObjects);		
		addButtons(viewObjects);
	}
	
	public void addItemsToArrayList() {
		itemsInShop = new ArrayList<String>();
		
		itemsInShop.add("resources/ShopItems/Ether.png");
		itemsInShop.add("resources/ShopItems/FullHeal.png");
		itemsInShop.add("resources/ShopItems/FullRestore.png");		
		itemsInShop.add("resources/ShopItems/HyperPotion.png");
		
		itemsInShop.add("resources/ShopItems/MaxEther.png");
		itemsInShop.add("resources/ShopItems/MaxPotion.png");
		itemsInShop.add("resources/ShopItems/Potion.png");
		itemsInShop.add("resources/ShopItems/SuperPotion.png");
	}
	
	public void addImagestoShop(List<Visible> viewObjects) {
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Graphic a = new Graphic(60, 100 + i*100, 50, 50, itemsInShop.get(i));
			viewObjects.add(a);
		}
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Graphic b = new Graphic(665, -300 + i*100, 50, 50, itemsInShop.get(i));
			viewObjects.add(b);
		}
		Graphic a = new Graphic(1235,40,30,30,"resources/dollar.png");
		viewObjects.add(a);
		
	}
	
	public void itemDescriptions(List<Visible> viewObjects) {
		populateDescriptions();		
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			TextArea c = new TextArea(125, 100+ i*100, 250, 100, itemDesc.get(i));
			c.setCustomTextColor(Color.BLACK);
			viewObjects.add(c);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			TextArea d = new TextArea(730, -300 + i*100, 250, 100, itemDesc.get(i));
			d.setCustomTextColor(Color.BLACK);
			viewObjects.add(d);
		}
	}

	public void populateDescriptions() {
		itemDesc = new ArrayList<String>();
		
		itemDesc.add("Restores 10 PP of a single move of a Pok�mon");
		itemDesc.add("Fully heals any status problems that a Pok�mon holds");
		itemDesc.add("Fully restores the HP and heals any Status ailments of a Pok�mon");
		itemDesc.add("Heals a Pok�mon by 200 HP");
		itemDesc.add("Fully restores the PP of one of the player's selected Pok�mon's move");
		
		itemDesc.add("If used on a fainted Pok�mon, the Pok�mon will be revived and have its health restored");
		itemDesc.add("Fully restores the HP of a Pok�mon");
		itemDesc.add("Heals 20 HP of a Pok�mon");
		itemDesc.add("Revives your fainted Pok�mon by half of its HP");
		itemDesc.add("Heals 50 HP of a Pok�mon");
	}

	public void addBackgroundLabel(List<Visible> viewObjects) {
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			StyledComponent.setButtonOutline(true);
			Button b = new Button(50, 100 + i*100, 565, 100, "",null);
			b.setEnabled(false);
			b.setBackground(Color.ORANGE);
			b.update();
			viewObjects.add(b);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			StyledComponent.setButtonOutline(true);
			Button b = new Button(655, -300 + i*100, 565, 100, "",null);
			b.setEnabled(false);
			b.setBackground(Color.ORANGE);
			b.update();
			viewObjects.add(b);
		}
		StyledComponent.setButtonOutline(false);
		setPokemonFont(18);
		Button b = new Button(1175,25,100,50,Integer.toString(getDollars()),null);
		b.setEnabled(false);
		b.update();
		viewObjects.add(b);
	}
	
	public void addButtons(List<Visible> viewObjects) {
		for (int i = 0; i < itemsInShop.size()/2; i++) {
			Button b = new Button(375, 75 + i*100, 75, 75,"Buy",null);
			viewObjects.add(b);
		}
		
		for (int i = 0; i < itemsInShop.size()/2; i++) {
			Button b = new Button(500, 75 + i*100, 75, 75,"Sell",null);
			viewObjects.add(b);
		}
		
		for (int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Button b = new Button(980, -325 + i*100, 75, 75,"Buy", null);
			viewObjects.add(b);
		}
		
		for (int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Button b = new Button(1105, -325 + i*100, 75, 75,"Sell", null);
			viewObjects.add(b);
		}
	}
	
	public int getDollars() {
		return dollars;
	}

	public void setDollars(int dollars) {
		this.dollars = dollars;
	}

	public static void setPokemonFont(float f) {
		try {
			//File fontFile = new File("resources/Pokemon Solid.ttf");
			//Font font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/Pokemon Solid.ttf"));
			//Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/Pokemon Solid.ttf")).deriveFont(f);
			StyledComponent.setBaseFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/Pokemon Solid.ttf")).deriveFont(f));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

