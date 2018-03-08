package rickyShopInteract;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class RickyShop extends FullFunctionScreen {

	private ArrayList<String> itemsInShop;
	private ArrayList<String> itemDesc;
	
	private static final long serialVersionUID = 5855860528658762993L;

	public RickyShop(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addItemsToArrayList();
		//System.out.println(itemsInShop);
		addImagestoShop(viewObjects);
		itemDescriptions(viewObjects);
		
	}
	
	public void addItemsToArrayList() {
		itemsInShop = new ArrayList<String>();
		itemsInShop.add("resources/ShopItems/Ether.png");
		itemsInShop.add("resources/ShopItems/FullHeal.png");
		itemsInShop.add("resources/ShopItems/FullRestore.png");
		itemsInShop.add("resources/ShopItems/HyperPotion.png");
		itemsInShop.add("resources/ShopItems/MaxEther.png");
		
		itemsInShop.add("resources/ShopItems/MaxPotion.png");
		itemsInShop.add("resources/ShopItems/MaxRevive.png"); //Max Revives CANNOT BE BOUGHT//
		itemsInShop.add("resources/ShopItems/Potion.png");
		itemsInShop.add("resources/ShopItems/Revive.png");
		itemsInShop.add("resources/ShopItems/SuperPotion.png");
	}
	
	public void addImagestoShop(List<Visible> viewObjects) {
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Graphic a = new Graphic(50, 100+ i*100, 50, 50, itemsInShop.get(i));
			viewObjects.add(a);
		}
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Graphic b = new Graphic(650, -400 + i*100, 50, 50, itemsInShop.get(i));
			viewObjects.add(b);
		}
	}
	
	public void itemDescriptions(List<Visible> viewObjects) {
		System.out.println("About to launch populateDescriptions");
		populateDescriptions();
		System.out.println("Finished launching populateDescriptions");
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			TextArea c = new TextArea(200, 100+ i*100, 250, 100, itemDesc.get(i));
			c.setCustomTextColor(Color.BLACK);
			viewObjects.add(c);
		}
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			TextArea d = new TextArea(800, -400 + i*100, 250, 100, itemDesc.get(i));
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
		
		itemDesc.add("Fully restores the HP of a Pok�mon");
		itemDesc.add("If used on a fainted Pok�mon, the Pok�mon will be revived as well as have its health fully restored");
		itemDesc.add("Heals 20 HP of a Pok�mon");
		itemDesc.add("Revives your fainted Pok�mon by half of its HP");
		itemDesc.add("Heals 50 HP of a Pok�mon");
	}
	
	
	 public void addBackgroundLabel(List<Visible> viewObjects) {
	 
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			new TextLabel(50, 100+ i*100, 300, 100, "");
		}
		
		//for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			
		//}
	}
	
}
