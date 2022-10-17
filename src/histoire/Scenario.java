package histoire;

import personnages.*;

public class Scenario {

	public static void main(String[] args) {
		personnages.Gaulois asterix = new personnages.Gaulois("Asterix", 8);
		personnages.Romain minus = new personnages.Romain("Minus", 6);
		personnages.Druide panoramix = new personnages.Druide("Panoramix", 5, 10);
		personnages.Gaulois obelix = new personnages.Gaulois("Ob�lix", 20);
		panoramix.parler("Je vais aller pr�parer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par B�l�nos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Merci Druide, je sens que ma force est 6 fois d�cupl�e.");
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		for (int i = 0; i <3; i++) {
			asterix.frapper(minus);
		}
	}
}
