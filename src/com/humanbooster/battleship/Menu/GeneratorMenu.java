package com.humanbooster.battleship.Menu;

import com.humanbooster.battleship.Utility.Board;
import com.humanbooster.battleship.Utility.OtherUtility;

public class GeneratorMenu {
	public static void title() {
		System.out.println("============================");
		System.out.println("|        BattleShip        |");
		System.out.println("============================");
		System.out.println("| Options:                 |");
		System.out.println("|        1. Play           |");
		System.out.println("============================");
		System.out.println("       Select option: ");
		OtherUtility.readInt();
	}

	public static void PrintBoard(Board b) {
		for (int i = 0; i < b.getPlateau().length; i++) {
			for (int j = 0; j < b.getPlateau().length; j++) {
				if (j == 0)
					System.out.print("| ");
				if (j > 0 && (j < b.getPlateau().length + 2))
					System.out.print(" - ");
				System.out.print(b.getPlateau()[i][j]);
				if ((j + 2) > b.getPlateau().length)
					System.out.print(" |");

			}
			System.out.print(OtherUtility.newline);
		}
	}

	public static void PrintMemo(char[][] t) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				if (j == 0)
					System.out.print("| ");
				if (j > 0 && (j < t.length + 2))
					System.out.print(" - ");
				System.out.print(t[i][j]);
				if ((j + 2) > t.length)
					System.out.print(" |");

			}
			System.out.print(OtherUtility.newline);
		}
	}

	public static void PrintSave(Board b) {
		for (int i = 0; i < b.getSave().length; i++) {
			for (int j = 0; j < b.getSave()[i].length; j++) {
				if (j > 1 && j < 3)
					System.out.print(" - ");
				System.out.print(b.getSave()[i][j]);

			}
			System.out.print(OtherUtility.newline);
		}

	}

}
