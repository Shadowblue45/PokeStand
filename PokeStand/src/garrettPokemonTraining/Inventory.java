package garrettPokemonTraining;

import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import startGame.PokeStart;

public class Inventory {

	public static Pokemon pokemon;
	public static String[] pokemonForms = new String[3];
	public static String[] pokemonImages = new String[3];
	public int uPoints;
	public int fatigue;
	public int pokemonIndex;
	public int daysLeft;

	public Inventory() {

	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("resources/pokemon.csv");
			fw.write(pokemon.getName()+","+ pokemon.getType1() +","+pokemon.getType2()+
					","+Integer.toString(pokemon.getHp())+","+Integer.toString(pokemon.getAtk())+","+Integer.toString(pokemon.getDef())
					+","+Integer.toString(pokemon.getsAtk())+","+Integer.toString(pokemon.getsDef())+","+Integer.toString(pokemon.getSpd())+","+pokemon.getImage()+"\n");
			for(Move m: pokemon.getMoves()){
				fw.write(m+"\n");    	
			}
			fw.write(Integer.toString(pokemonIndex) + "," + Integer.toString(daysLeft) + "," + Integer.toString(fatigue) + "," + Integer.toString(uPoints) + "\n");
			for(int i = 0; i < PokeStart.shopScreen.getItemQuantity().length; i++) {
				fw.write(Integer.toString(PokeStart.shopScreen.getItemQuantity()[i]) + ",");
			}
			fw.write("\n");
			fw.close();    
			System.out.println("Success! File \"pokemon.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	public boolean read(File f) {
		try{
			FileReader fileReader = new FileReader(f);
			String line = "";
			//a BufferedReader enables us to read the file one line at a time
			BufferedReader br = new BufferedReader(fileReader);
			while ((line = br.readLine()) != null) {



				String[] param = line.split(",");
				if(param.length == 10) {
					setPokemon(param[0],param[1],param[2],Integer.parseInt(param[3]),Integer.parseInt(param[4]),Integer.parseInt(param[5]),Integer.parseInt(param[6]),
							Integer.parseInt(param[7]),Integer.parseInt(param[8]),param[9]);
					pokemon.emptyMoves();
				}
				else if(param.length == 8){
					pokemon.getMoves().add(new Move(param[0],param[1],Integer.parseInt(param[2]),Integer.parseInt(param[3]),
							Integer.parseInt(param[4]),Boolean.getBoolean(param[5]),Integer.parseInt(param[6]),Integer.parseInt(param[7])));
				}else if(param.length == 4) {
					pokemonIndex = Integer.parseInt(param[0]);
					daysLeft = Integer.parseInt(param[1]);
					fatigue = Integer.parseInt(param[2]);
					uPoints = Integer.parseInt(param[3]);
				}
			}
			br.close();
			return true;
		}catch(Exception e){
			System.out.println("The file name you specified does not exist.");
			return false;
		}
	}

	public void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){

			fileName = "resources/pokemon.csv";
			opened = read(new File(fileName));

		}
	}

	public String[] getNames() {
		// TODO Auto-generated method stub
		return pokemonForms;
	}

	public int getNameIndex() {
		for(int i = 0; i < pokemonForms.length; i++) {
			if(pokemon.getName().equals(pokemonForms[i])) {
				return i;
			}
		}
		return -1;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(String name, String type1, String type2, int hp, int atk, int def, int sAtk, int sDef, int spd, String url) {
		pokemon = new Pokemon(name, type1, type2, hp, atk, def, sAtk, sDef, spd, url);
	}

	public String[] getPokemonImages() {
		return pokemonImages;
	}

	public void setImages(String[] pics) {
		for(int i = 0; i < pics.length; i++) {
			pokemonImages[i] = pics[i];
		}
	}

	public void setNames(String[] names) {
		for(int i = 0; i < names.length; i++) {
			pokemonForms[i] = names[i];
		}
	}
	
	public String[] generateNames(String name) {
		String[] names = new String[3];
		if(name.equals("Charmander") || name.equals("Charmeleon") || name.equals("Charizard")) {
			names[0] = "Charmander";
			names[1] = "Charmeleon";
			names[2] = "Charizard";
		}
		if(name.equals("Chimchar") || name.equals("Monferno") || name.equals("Infernape")) {
			names[0] = "Chimchar";
			names[1] = "Monferno";
			names[2] = "Infernape";
		}
		if(name.equals("Cyndaquil") || name.equals("Quilava") || name.equals("Typhlosion")) {
			names[0] = "Cyndaquil";
			names[1] = "Quilava";
			names[2] = "Typhlosion";
		}
		if(name.equals("Turtwig") || name.equals("Grotle") || name.equals("Torterra")) {
			names[0] = "Turtwig";
			names[1] = "Grotle";
			names[2] = "Torterra";
		}
		if(name.equals("Treecko") || name.equals("Grovyle") || name.equals("Sceptile")) {
			names[0] = "Treecko";
			names[1] = "Grovyle";
			names[2] = "Sceptile";
		}
		if(name.equals("Snivy") || name.equals("Servine") || name.equals("Serperior")) {
			names[0] = "Snivy";
			names[1] = "Servine";
			names[2] = "Serperior";
		}
		if(name.equals("Mudkip") || name.equals("Marshtomp") || name.equals("Swampert")) {
			names[0] = "Mudkip";
			names[1] = "Marshtomp";
			names[2] = "Swampert";
		}
		if(name.equals("Froakie") || name.equals("Frogadier") || name.equals("Greninja")) {
			names[0] = "Froakie";
			names[1] = "Frogadier";
			names[2] = "Greninja";
		}
		if(name.equals("Popplio") || name.equals("Brionne") || name.equals("Primarina")) {
			names[0] = "Popplio";
			names[1] = "Brionne";
			names[2] = "Primarina";
		}
		return names;
	}
	
	public String[] generateImages(String name) {
		String[] images = new String[3];
		if(name.equals("Charmander") || name.equals("Charmeleon") || name.equals("Charizard")) {
			images[0] = "resources/fire/Charmander.png";
			images[1] = "resources/fire/Charmeleon.png";
			images[2] = "resources/fire/Charizard.png";
		}
		if(name.equals("Chimchar") || name.equals("Monferno") || name.equals("Infernape")) {
			images[0] = "resources/fire/Chimchar.png";
			images[1] = "resources/fire/Monferno.png";
			images[2] = "resources/fire/Infernape.png";
		}
		if(name.equals("Cyndaquil") || name.equals("Quilava") || name.equals("Typhlosion")) {
			images[0] = "resources/fire/Cyndaquil.png";
			images[1] = "resources/fire/Quilava.png";
			images[2] = "resources/fire/Typhlosion.png";
		}
		if(name.equals("Turtwig") || name.equals("Grotle") || name.equals("Torterra")) {
			images[0] = "resources/grass/Turtwig.png";
			images[1] = "resources/grass/Grotle.png";
			images[2] = "resources/grass/Torterra.png";
		}
		if(name.equals("Treecko") || name.equals("Grovyle") || name.equals("Sceptile")) {
			images[0] = "resources/grass/Treecko.png";
			images[1] = "resources/grass/Grovyle.png";
			images[2] = "resources/grass/Sceptile.png";
		}
		if(name.equals("Snivy") || name.equals("Servine") || name.equals("Serperior")) {
			images[0] = "resources/grass/Snivy.png";
			images[1] = "resources/grass/Servine.png";
			images[2] = "resources/grass/Serperior.png";
		}
		if(name.equals("Mudkip") || name.equals("Marshtomp") || name.equals("Swampert")) {
			images[0] = "resources/water/Mudkip.png";
			images[1] = "resources/water/Marshtomp.png";
			images[2] = "resources/water/Swampert.png";
		}
		if(name.equals("Froakie") || name.equals("Frogadier") || name.equals("Greninja")) {
			images[0] = "resources/water/Froakie.png";
			images[1] = "resources/water/Frogadier.png";
			images[2] = "resources/water/Greninja.png";
		}
		if(name.equals("Popplio") || name.equals("Brionne") || name.equals("Primarina")) {
			images[0] = "resources/water/Popplio.png";
			images[1] = "resources/water/Brionne.png";
			images[2] = "resources/water/Primarina	.png";
		}
		return images;
	}

}
