package fr.eni.morpion;

import java.util.Arrays;
import java.util.Scanner;

public class Morpion {
	public static void main(String[] args) {
		// String[][] tableauJeu = new String[3][3];
		String[][] tableauJeu = { { "X", "O", "X" }, { "O", "1", "O" }, { "X", "O", "X" } };
		char player = '1';
		System.out.println(Arrays.deepToString(tableauJeu));
		for (int i = 0; i < 8; i++) {
			String inputCross = posCrossInput();
			int[] positions = vericationsCrossPosition(inputCross);
			putACross(positions, tableauJeu);
			boolean win = checkVictory(player, tableauJeu);
			printWinner(player, win);
			player = togglePlayer(player);
			putANought(positions, tableauJeu);
			win = checkVictory(player, tableauJeu);
			printWinner(player, win);
			player = togglePlayer(player);
		}
	}

	public static String posCrossInput() {
		System.out.println("Entrer la ligne et la colonne de votre croix sous forme : no_ligne,no_colonne");
		Scanner posCross = new Scanner(System.in);
		String inputCross = posCross.nextLine();
		return inputCross;
	}

	public static int[] vericationsCrossPosition(String inputCross) {
		String separation[] = inputCross.split(",");
		if (separation.length != 2) {
			System.out.println("Erreur vous n'avez pas rentré le bon nombre de chiffres");
			posCrossInput();
		}

		int[] integerPositions = transformInputInInteger(separation);
		if (integerPositions[0] > 2 || integerPositions[0] < 0 || integerPositions[1] < 0 || integerPositions[1] > 2) {
			System.out.println("Erreur : vous souhaitez mettre une croix en dehors de la grille de morpion?!!");
			posCrossInput();
		}

		return new int[] { integerPositions[0], integerPositions[1] };
	}

	public static int[] transformInputInInteger(String[] separation) {
		int positionLine = Integer.parseInt(separation[0]) - 1;
		int positionColumn = Integer.parseInt(separation[1]) - 1;
		return new int[] { positionLine, positionColumn };
	}

	public static void putACross(int[] positions, String[][] tableauJeu) {
		int positionLine = positions[0];
		int positionColumn = positions[1];
		tableauJeu[positionLine][positionColumn] = "X";
		System.out.println(Arrays.deepToString(tableauJeu));
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
		int randomLine = (int) (Math.random() * 2);
		int randomColumn = (int) (Math.random() * 2);

		while (tableauJeu[randomLine][randomColumn] == "X" || tableauJeu[randomLine][randomColumn] == "O") {
			randomLine = (int) (Math.random() * 3);
			randomColumn = (int) (Math.random() * 3);

		}
		tableauJeu[randomLine][randomColumn] = "O";
		System.out.println(Arrays.deepToString(tableauJeu));
	}

	public static boolean checkVictoryLines(char player, String[][] tableauJeu) {
		for (int verifiedLine = 0; verifiedLine < 3; verifiedLine++) {
			if (tableauJeu[verifiedLine][0] == tableauJeu[verifiedLine][1]
					&& tableauJeu[verifiedLine][1] == tableauJeu[verifiedLine][2]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkVictoryColumns(char player, String[][] tableauJeu) {
		for (int verifiedColumn = 0; verifiedColumn < 3; verifiedColumn++) {
			if (tableauJeu[verifiedColumn][0] == tableauJeu[verifiedColumn][1]
					&& tableauJeu[verifiedColumn][1] == tableauJeu[verifiedColumn][2]) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkVictoryDiagonals(char player, String[][] tableauJeu) {
		if ((tableauJeu[0][0] == tableauJeu[1][1] && tableauJeu[1][1] == tableauJeu[2][2])
				|| (tableauJeu[0][2] == tableauJeu[1][1] && tableauJeu[1][1] == tableauJeu[2][0])) {
			return true;
		}
		return false;
	}
	
	public static boolean checkVictory(char player, String[][] tableauJeu) {
		boolean winline=checkVictoryLines(player, tableauJeu);
		boolean winColumn=checkVictoryColumns(player, tableauJeu);
		boolean winDiagonal=checkVictoryDiagonals(player, tableauJeu);
		if (winline==true ||winColumn==true ||winDiagonal==true) {
			return true;
		}
		return false;
	}

	public static void printWinner(char player, boolean win) {
		if (win == true) {
			System.out.println("Le joueur " + player + " a gagné!");
			System.exit(0);
		}
	}
}