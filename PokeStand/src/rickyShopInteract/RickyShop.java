package rickyShopInteract;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class RickyShop extends FullFunctionScreen {

	private ArrayList<String> itemsInShop;
	
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
		itemsInShop.add("resources/ShopItems/Antidote.png");
		itemsInShop.add("resources/ShopItems/Awakening.png");
		itemsInShop.add("resources/ShopItems/BurnHeal.png");
		itemsInShop.add("resources/ShopItems/Ether.png");
		itemsInShop.add("resources/ShopItems/FullHeal.png");
		itemsInShop.add("resources/ShopItems/FullRestore.png");
		itemsInShop.add("resources/ShopItems/HyperPotion.png");
		itemsInShop.add("resources/ShopItems/IceHeal.png");
		itemsInShop.add("resources/ShopItems/MaxEther.png");
		itemsInShop.add("resources/ShopItems/MaxPotion.png");
		itemsInShop.add("resources/ShopItems/MaxRevive.png");
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
			Graphic b = new Graphic(650, -600 + i*100, 50, 50, itemsInShop.get(i));
			viewObjects.add(b);
		}
	}
	
	public void itemDescriptions(List<Visible> viewObjects) {
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			TextArea c = new TextArea(200, 100+ i*100, 100, 100, "SampleText");
			c.setCustomTextColor(Color.MAGENTA);
			viewObjects.add(c);
			c.setText("Changed Text");
		}
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			TextArea d = new TextArea(800, -600 + i*100, 100, 100, "SampleText");
			d.setCustomTextColor(Color.MAGENTA);
			viewObjects.add(d);
		}
	}
}
