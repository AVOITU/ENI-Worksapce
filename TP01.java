package fr.eni.tp01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TP01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] motAleatoire = tirerMotAleatoirement();
		char[] motMelange = melanger(motAleatoire);
		afficher(motMelange);
		char[] arrayInputUser = askUser();
		boolean continueOrLoose = bonnesLettres(motMelange, arrayInputUser);
		System.out.println(continueOrLoose);
		boolean same=sontIdentiques(motAleatoire, arrayInputUser);
		System.out.println(same);
		end(continueOrLoose, same);
	}

	public static char[] tirerMotAleatoirement() {

		String[] tousLesMots = { "Clea" };
		// "Antoine","Aranud", "Pierre-Yves","Simon",
		// "Kevin","Tracy","délégué","Welles","abdication"
		int longueurTableau = tousLesMots.length;
		int indexAleatoire = new Random().nextInt(longueurTableau);

		String motAleatoire = tousLesMots[indexAleatoire];

		return motAleatoire.toCharArray();
	}

	public static char[] melanger(char[] motAleatoire) {

		char[] nouveauTableau = new char[motAleatoire.length];
		for (int i = 0; i < nouveauTableau.length; i++) {
			nouveauTableau[i] = motAleatoire[i];
		}
		System.out.println(nouveauTableau);

		for (int i = 0; i < 51; i++) {
			int indexAleatoire = new Random().nextInt(nouveauTableau.length);
			int indexAleatoire2 = new Random().nextInt(nouveauTableau.length);
			char temporaire = nouveauTableau[indexAleatoire];
			nouveauTableau[indexAleatoire] = nouveauTableau[indexAleatoire2];
			nouveauTableau[indexAleatoire2] = temporaire;
		}
		return nouveauTableau;
	}

	public static void afficher(char[] motMelange) {
		System.out.println(Arrays.toString(motMelange));
	}

	// question 5

	public static char[] askUser() {
		Scanner s = new Scanner(System.in);
		String inputUser = s.nextLine();
		char[] arrayInputUser = inputUser.toCharArray();
		return arrayInputUser;
	}

	public static boolean bonnesLettres(char[] motMelange, char[] arrayInputUser) {

		int[] comptage = creationVerificationArray(motMelange, arrayInputUser);
		boolean continueOrLoose = isLetterExistingMot(comptage);
		boolean continueorloose2 = alignLetters(motMelange, arrayInputUser);
		if (continueOrLoose==true || continueorloose2==true) {
			return true;
		}
		return false;

	}

	// question 5 existing letter
	public static int[] creationVerificationArray(char[] motMelange, char[] arrayInputUser) {
		int[] comptage = new int[arrayInputUser.length];
		for (int i = 0; i < arrayInputUser.length; i++) {
			for (int j = 0; j < arrayInputUser.length; j++) {
				if (arrayInputUser[i] == motMelange[j]) {
					comptage[i] = j + 1;
				}
			}
		}
		return comptage;
	}

	public static boolean isLetterExistingMot(int[] comptage) {
		for (int i = 0; i < comptage.length; i++) {
			if (comptage[i] == 0) {
				return true;
			}
		}
		return false;
	}

	// verification double letter

	public static boolean alignLetters(char[] motMelange, char[] arrayInputUser) {
		for (int i = 0; i < arrayInputUser.length; i++) {
			int temporaire = 0;
			int temporaireqqchose = 0;
			for (int j = 0; j < arrayInputUser.length; j++) {
				if (arrayInputUser[i] == arrayInputUser[j]) {
					temporaire++;
				}
			}
			for (int k = 0; k < arrayInputUser.length; k++) {
				if (arrayInputUser[i] == motMelange[k]) {
					temporaireqqchose++;
				}
			}
			if (temporaire != temporaireqqchose) {
				return false;
			}
		}
		return false;
	}
	
	// sontIdentiques()
	
	public static boolean sontIdentiques(char[] motAleatoire, char[] arrayInputUser) {
		for(int i=0; i<motAleatoire.length; i++) {
			if (motAleatoire[i]!=arrayInputUser[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void end(boolean continueOrLoose,boolean same) {
		if (continueOrLoose== false && same==true) {
			System.out.println("Vous avez gagné!");
		}else {
			System.out.println("Vous avez perdu!");
		}
	}
}