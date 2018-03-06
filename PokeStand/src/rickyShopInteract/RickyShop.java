package rickyShopInteract;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Graphic;
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
		System.out.println(itemsInShop);
		addImagestoShop(viewObjects);
		
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
		/*
		Graphic antidote = new Graphic(100,100,20,20,itemsInShop.get(0));
		viewObjects.add(antidote);
		Graphic awakening = new Graphic(100,150,20,20,itemsInShop.get(1));
		viewObjects.add(awakening);
		*/
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Graphic a = new Graphic(100+ i*50 , 50 ,20,20,itemsInShop.get(i));
			viewObjects.add(a);
		}

	}
}
