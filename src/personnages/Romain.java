package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement =0;
	private Equipement[] equipements;
	private String texte;

	
	public Romain(String nom, int force) {
		assert(force>0):"force négative";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
//	public void recevoirCoup(int forceCoup) {
//		assert(force>0):"force négative";
//		int force_avant=force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aîe");
//		} 
//		else {
//			parler("J'abandonne...");
//		}
//		assert(force_avant>force):"force n'a pas diminué";
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
		parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
			}
			// post condition la force à diminuer
			assert force < oldForce;
			return equipementEjecte;
			}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de"
	+ forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa "
				+ "force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipements[i] != null &&
		equipements[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + 
		"s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
				} else {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
				}
				return equipementEjecte;
				}

	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
				case 2: {
					System.out.println("Le soldat " + nom + " est deja bien protégé !");
					break;
				}
				case 1: {
					if (equipements[0] == equipement) {
						System.out.println("Le soldat " + nom + " possede déjà un " + 
								equipement + ".");
						break;
					} else {
						equipement(equipement);
						break;
					}
				}
				default : {
					equipement(equipement);
					break;
				}
			}
		}
		
		private void equipement(Equipement equipement) {
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'equipe d'un " + 
					equipement + ".");
		}
	
		public static void main(String[] args) {
			Romain cesar = new Romain("Cesar", 20);
			System.out.println(cesar.getForce());
			System.out.println(cesar.prendreParole());
			cesar.parler("Bonjour");
			cesar.recevoirCoup(10);
			cesar.recevoirCoup(10);
			System.out.println(cesar.getForce());
			System.out.println(Equipement.BOUCLIER);
			System.out.println(Equipement.CASQUE);
			cesar.sEquiper(Equipement.CASQUE);
			cesar.sEquiper(Equipement.CASQUE);
			cesar.sEquiper(Equipement.BOUCLIER);
			cesar.sEquiper(Equipement.CASQUE);
		}
	}

