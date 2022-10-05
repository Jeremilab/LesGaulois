package histoire;

import personnages.*;

public class Scenario {

	public static void main(String[] args) {
		Gaulois Asterix = new Gaulois("Asterix", 8);
		Romain Minus = new Romain("Minus", 6);
		Asterix.parler("Bonjour a tous");
		Minus.parler("UN GAU...UN GAUGAU...");
		Asterix.frapper(Minus);
		Asterix.frapper(Minus);
		Asterix.frapper(Minus);
	}

}
