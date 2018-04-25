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
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;

import guiTeacher.userInterfaces.FullFunctionScreen;
 
public class RickyScreen extends FullFunctionScreen {

	private ArrayList<String> itemsInShop;
	private ArrayList<String> itemDesc;
	private int dollars;
	private ArrayList<Integer> priceAmount;
	private int[] itemQuantity;
	private ArrayList<Button> buttonList;
	public static Button z;
	
	private static final long serialVersionUID = 5855860528658762993L;

	public RickyScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		dollars = 2000;
		addImages();
		addBackgroundLabel(viewObjects);
		addImagestoShop(viewObjects);
		setPokemonFont(16);
		itemDescriptions(viewObjects);	
		instanitatingArray(viewObjects);
		addButtons(viewObjects);
		setPokemonGBFont(13);
		addPrices();
		addPrices(viewObjects);
		//addQuantityMarkers(viewObjects);
	}
	
	public void addImages() {
		itemsInShop = new ArrayList<String>();
		
		itemsInShop.add("resources/ShopItems/Ether.png");
		itemsInShop.add("resources/ShopItems/MaxEther.png");
		itemsInShop.add("resources/ShopItems/FullHeal.png");
		itemsInShop.add("resources/ShopItems/FullRestore.png");		
		
		itemsInShop.add("resources/ShopItems/Potion.png");
		itemsInShop.add("resources/ShopItems/SuperPotion.png");
		itemsInShop.add("resources/ShopItems/HyperPotion.png");		
		itemsInShop.add("resources/ShopItems/MaxPotion.png");
		itemQuantity = new int[itemsInShop.size()];
	}
	
	public void addImagestoShop(List<Visible> viewObjects) {
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Graphic a = new Graphic(60, 50 + i*150, 50, 50, itemsInShop.get(i));
			viewObjects.add(a);
		}
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Graphic b = new Graphic(665, -550 + i*150, 50, 50, itemsInShop.get(i));
			viewObjects.add(b);
		}
		Graphic a = new Graphic(1235,20,30,30,"resources/dollar.png");
		viewObjects.add(a);
		
	}
	
	public void itemDescriptions(List<Visible> viewObjects) {
		addDescriptions();		
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			TextArea c = new TextArea(125, 50 + i*150, 250, 150, itemDesc.get(i));
			c.setCustomTextColor(Color.BLACK);
			viewObjects.add(c);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			TextArea d = new TextArea(730, -550 + i*150, 250, 150, itemDesc.get(i));
			d.setCustomTextColor(Color.BLACK);
			viewObjects.add(d);
		}
	}

	public void addDescriptions() {
		itemDesc = new ArrayList<String>();
		
		itemDesc.add("Restores 10 PP of a single move of a Pokemon");
		itemDesc.add("Fully restores the PP of one of the player's selected Pokemon's move");
		itemDesc.add("Fully heals any status problems that a Pokemon holds");
		itemDesc.add("Fully restores the HP and heals any Status ailments of a Pokemon");
		
		itemDesc.add("Heals 20 HP of a Pokemon");
		itemDesc.add("Heals 50 HP of a Pokemon");
		itemDesc.add("Heals a Pokemon by 200 HP");		
		itemDesc.add("Fully restores the HP of a Pokemon");
	}

	public void addBackgroundLabel(List<Visible> viewObjects) {
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			StyledComponent.setButtonOutline(true);
			Button b = new Button(50, 50 + i*150, 565, 150, "",null);
			b.setEnabled(false);
			b.setBackground(Color.ORANGE);
			b.update();
			viewObjects.add(b);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			StyledComponent.setButtonOutline(true);
			Button b = new Button(655, -550 + i*150, 565, 150, "",null);
			b.setEnabled(false);
			b.setBackground(Color.ORANGE);
			b.update();
			viewObjects.add(b);
		}
		StyledComponent.setButtonOutline(false);
		setPokemonFont(18);
		z = new Button(1175,10,100,50,Integer.toString(getDollars()),null);
		z.setEnabled(false);
		viewObjects.add(z);
		z.update();
	}
	
	public void addButtons(List<Visible> viewObjects) {
		for (int i = 0; i < itemsInShop.size()/2; i++) {
			int j = i;
			Button b = new Button(375, 25 + i*150, 75, 125,"Buy",new Action() {

				@Override
				public void act() {
					if(getDollars() >= priceAmount.get(j)) {
						setDollars(getDollars() - priceAmount.get(j));
						//System.out.println(getDollars());
						itemQuantity[j]++;
						z.setText(Integer.toString(getDollars()));
						z.update();
						buttonList.get(j).setText(Integer.toString(itemQuantity[j]));
						buttonList.get(j).update();
						
					}
				}

			});
			viewObjects.add(b);
		}
		
		for (int i = 0; i < itemsInShop.size()/2; i++) {
			int j = i;
			Button b = new Button(500, 25 + i*150, 75, 125,"Sell",new Action() {	
				@Override
				public void act() {
					if(itemQuantity[j] >= 1) {
						setDollars(getDollars() + priceAmount.get(j)/2);
						itemQuantity[j]--;
						z.setText(Integer.toString(getDollars()));
						z.update();
						buttonList.get(j).setText(Integer.toString(itemQuantity[j]));
						buttonList.get(j).update();
						
					}
				}
			});
			viewObjects.add(b);
		}
		
		for (int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			int j = i;
			Button b = new Button(980, -575 + i*150, 75, 125,"Buy", new Action() {
				@Override
				public void act() {
					if(getDollars() >= priceAmount.get(j)) {
						setDollars(getDollars() - priceAmount.get(j));
						itemQuantity[j]++;
						z.setText(Integer.toString(getDollars()));
						z.update();
						buttonList.get(j).setText(Integer.toString(itemQuantity[j]));
						buttonList.get(j).update();
					}
				}
			});
			viewObjects.add(b);
		}
		
		for (int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			int j = i;
			Button b = new Button(1105, -575 + i*150, 75, 125,"Sell", new Action() {
				
				@Override
				public void act() {
					if(itemQuantity[j] >= 1) {
						setDollars(getDollars() + priceAmount.get(j)/2);
						itemQuantity[j]--;
						z.setText(Integer.toString(getDollars()));
						z.update();
						buttonList.get(j).setText(Integer.toString(itemQuantity[j]));
						buttonList.get(j).update();
					}
				}
			});
			viewObjects.add(b);
		}
	}
	
	public void addPrices() {
		priceAmount = new ArrayList<Integer>();
		
		priceAmount.add(1200);
		priceAmount.add(2000);
		priceAmount.add(600);
		priceAmount.add(3000);
		priceAmount.add(300);
		priceAmount.add(700);
		priceAmount.add(1200);
		priceAmount.add(2500);
		
	}
	
	public void addPrices(List<Visible> viewObjects) {
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Graphic c = new Graphic(425, 50 + i*150, 15, 15, "resources/dollar.png");
			viewObjects.add(c);
		}
		
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Graphic c = new Graphic(550, 50 + i*150, 15, 15, "resources/dollar.png");
			viewObjects.add(c);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Graphic c = new Graphic(1030, -550 + i*150, 15, 15, "resources/dollar.png");
			viewObjects.add(c);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Graphic c = new Graphic(1155, -550 + i*150, 15, 15, "resources/dollar.png");
			viewObjects.add(c);
		}
		
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Button d = new Button(300, i*150, 200, 125, Integer.toString(priceAmount.get(i)),null);
			d.setEnabled(false);
			d.update();
			viewObjects.add(d);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Button d = new Button(910,-600 + i*150, 200, 125, Integer.toString(priceAmount.get(i)),null);
			d.setEnabled(false);
			d.update();
			viewObjects.add(d);
		}
		
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			Button d = new Button(425, i*150, 200, 125, Integer.toString(priceAmount.get(i)/2),null);
			d.setEnabled(false);
			d.update();
			viewObjects.add(d);
		}
		
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			Button d = new Button(1025, -600 + i*150, 200, 125, Integer.toString(priceAmount.get(i)/2),null);
			d.setEnabled(false);
			d.update();
			viewObjects.add(d);
		}
	}

//	public void addQuantityMarkers(List<Visible> viewObjects) {
//		setPokemonGBFont(18);		 
//		 for(int i = 0; i < itemsInShop.size()/2; i++) {
//			 Button minus = new Button(375, 60 + i*150, 35, 125,"-",new Action() {
//
//			@Override
//			public void act() {
//				// TODO Auto-generated method stub
//				
//			}
//
//		});
//			viewObjects.add(minus);
//		}
//		 
//		 for(int i = 0; i < itemsInShop.size()/2; i++) {
//			 Button minus = new Button(1000, 60 + i*150, 35, 125,"-",new Action() {
//
//			@Override
//			public void act() {
//				// TODO Auto-generated method stub
//				
//			}
//
//		});
//			viewObjects.add(minus);
//		}  
//		 
//		 for(int i = 0; i < itemsInShop.size()/2; i++) {
//			 Button plus = new Button(475, 60 + i*150, 35, 125,"+",new Action() {
//
//			@Override
//			public void act() {
//				// TODO Auto-generated method stub
//				
//			}
//
//		});
//			viewObjects.add(plus);
//		}  
//		 
//		for(int i = 0; i < itemsInShop.size()/2; i++) {
//			 Button plus = new Button(1100, 60 + i*150, 35, 125,"+",new Action() {
//
//			@Override
//			public void act() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//			viewObjects.add(plus);
//		}   
//	}

	public void instanitatingArray(List<Visible> viewObjects){
		itemQuantity = new int[itemsInShop.size()]; 
		buttonList = new ArrayList<Button>();
		for(int i = 0; i < itemsInShop.size()/2; i++) {
			buttonList.add(new Button(410, 60 + i*150, 75, 125, Integer.toString(itemQuantity[i]), null));
			buttonList.get(i).setEnabled(false);
			viewObjects.add(buttonList.get(i));
		}
		for(int i = itemsInShop.size()/2; i < itemsInShop.size(); i++) {
			System.out.print(Integer.toString(itemQuantity[i]));
			buttonList.add(new Button(1030, -540 + i*150, 75, 125, "0", null));
			buttonList.get(i).setEnabled(false);
			viewObjects.add(buttonList.get(i));
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
	
	public static void setPokemonGBFont(float f) {
		try {
			StyledComponent.setBaseFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/Pokemon GB.ttf")).deriveFont(f));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
