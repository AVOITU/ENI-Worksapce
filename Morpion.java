package fr.eni.morpion;

import java.util.Arrays;
import java.util.Scanner;

public class Morpion {
	public static void main(String[] args) {
		String[][] tableauJeu = new String[3][3];
		tableauJeu = createGrid(tableauJeu);
		char player = '1';
		int i =0;
		do {
			System.out.println(i);
			printGrid(tableauJeu);
			String inputCross = posCrossInput();
			int[] positions = verificationsCrossPosition(inputCross, tableauJeu);
			putACross(positions, tableauJeu);
			boolean win = checkVictory(tableauJeu);
			printWinner(player, win,tableauJeu);
			i++;
			player = togglePlayer(player);
			printGrid(tableauJeu);
			putANought(positions, tableauJeu);
			win = checkVictory(tableauJeu);
			printWinner(player, win, tableauJeu);
			player = togglePlayer(player);
		}while (i<8);
		System.out.println("match nul");
	}

	public static String[][] createGrid(String[][] tableauJeu) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String line=String.valueOf(i+1);
				String column=String.valueOf(j+1);
				
				tableauJeu[i][j] = line + column;
			}
		}
		return tableauJeu;
	}

	public static void printGrid(String[][] Tableaujeu) {
		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(Tableaujeu[i]));
		}
	}

	public static String posCrossInput() {
		System.out.println("Entrer la ligne et la colonne de votre croix en tapant l'un des nombres possibles"
				+ "affiché dans la grille exple: 11 ou 32");
		Scanner posCross = new Scanner(System.in);
		String inputCross = posCross.nextLine();
		return inputCross;
	}

	public static int[] verificationsCrossPosition(String inputCross, String[][] tableauJeu) {

		String[] separation = separateCoordinate(inputCross, tableauJeu);
		int[] integerPositions = transformInputInInteger(separation);
		integerPositions =verificationLimitPositions(integerPositions, inputCross, tableauJeu);
		integerPositions =alreadyOnAPosition(integerPositions, inputCross, tableauJeu);

		return integerPositions;
	}

	public static String[] separateCoordinate(String inputCross, String[][] tableauJeu) {
		String separation[] = inputCross.split("");
		while (separation.length != 2) {
			System.out.println("Erreur vous n'avez pas rentré le bon nombre de chiffres");
			inputCross = posCrossInput();
			String []newSeparation=separateCoordinate(inputCross, tableauJeu);
			return newSeparation;
		}
		return separation;
	}

	public static int [] verificationLimitPositions(int[] integerPositions, String inputCross, String[][] tableauJeu) {
		while (integerPositions[0] > 2 || integerPositions[0] < 0 || integerPositions[1] < 0
				|| integerPositions[1] > 2) {
			System.out.println("Erreur : vous souhaitez mettre une croix en dehors de la grille de morpion?!!");
			inputCross = posCrossInput();
			int[] integerNewPositions=verificationsCrossPosition(inputCross, tableauJeu);
			return integerNewPositions;
		}
		return integerPositions;
	}

	public static int[] transformInputInInteger(String[] separation) {
		int positionLine = Integer.parseInt(separation[0]) - 1;
		int positionColumn = Integer.parseInt(separation[1]) - 1;
		return new int[] { positionLine, positionColumn };
	}

	public static int [] alreadyOnAPosition(int[] integerPositions, String inputCross, String[][] tableauJeu) {
		int row = integerPositions[0];
		int column = integerPositions[1];
		while (tableauJeu[row][column] == "X" || tableauJeu[row][column] == "O") {
			System.out.println("Les coordonnées sonr déjà prises par un autre élément" + " ressaissez les coordonées");
			inputCross = posCrossInput();
			int[] integerNewPositions= verificationsCrossPosition(inputCross, tableauJeu);
			return integerNewPositions;
		}
		return integerPositions;
	}

	public static void putACross(int[] positions, String[][] tableauJeu) {
		int positionLine = positions[0];
		int positionColumn = positions[1];
		tableauJeu[positionLine][positionColumn] = "X";
	}

	public static char togglePlayer(char player) {
		if (player == '1') {
			player = '2';
			System.out.println("Le joueur 2 dessine un rond");
		} else {
			player = '1';
			System.out.println("A votre tour");
		}

		return player;
	}

	public static void putANought(int[] positions, String[][] tableauJeu) {
		int randomLine = (int) (Math.random() * 3);
		int randomColumn = (int) (Math.random() * 3);

		while (tableauJeu[randomLine][randomColumn] == "X" || tableauJeu[randomLine][randomColumn] == "O") {
			randomLine = (int) (Math.random() * 3);
			randomColumn = (int) (Math.random() * 3);

		}
		tableauJeu[randomLine][randomColumn] = "O";
		System.out.println(Arrays.deepToString(tableauJeu));
	}

	public static boolean checkVictoryLines(String[][] tableauJeu) {
		for (int verifiedLine = 0; verifiedLine < 3; verifiedLine++) {
			if (tableauJeu[verifiedLine][0] == tableauJeu[verifiedLine][1]
					&& tableauJeu[verifiedLine][1] == tableauJeu[verifiedLine][2]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkVictoryColumns(String[][] tableauJeu) {
		for (int verifiedColumn = 0; verifiedColumn < 3; verifiedColumn++) {
			if (tableauJeu[0][verifiedColumn] == tableauJeu[1][verifiedColumn]
					&& tableauJeu[1][verifiedColumn] == tableauJeu[2][verifiedColumn]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkVictoryDiagonals(String[][] tableauJeu) {
		if ((tableauJeu[0][0] == tableauJeu[1][1] && tableauJeu[1][1] == tableauJeu[2][2])
				|| tableauJeu[0][2] == tableauJeu[1][1] && tableauJeu[1][1] == tableauJeu[2][0]) {
			return true;
		}
		return false;
	}

	public static boolean checkVictory(String[][] tableauJeu) {
		boolean winline = checkVictoryLines(tableauJeu);
		boolean winColumn = checkVictoryColumns(tableauJeu);
		boolean winDiagonal = checkVictoryDiagonals(tableauJeu);
		if (winline == true || winColumn == true || winDiagonal == true) {
			return true;
		}
		return false;
	}

	public static void printWinner(char player, boolean win,String[][] tableauJeu) {
		if (win == true) {
			System.out.println("Le joueur " + player + " a gagné!");
			printGrid(tableauJeu);
			System.exit(0);
		}
	}
}