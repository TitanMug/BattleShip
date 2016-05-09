package com.humanbooster.battleship.Utility;

import com.humanbooster.battleship.Menu.GeneratorMenu;

public class Launch {

	public static void placing(Board b, int nbr) {
		int i = 0, j = 0;
		boolean done;
		while (i < nbr) {
			done = false;
			System.out.print("Veuilliez Saisir l'emplacement du bateau [ ");
			for (j = 2; j < (i + 4); j++)
				System.out.print("¤");
			System.out.print(" ]" + OtherUtility.newline);
			b.setLengthiness(i + 2);
			while (!done) {
				b.setBoatX((OtherUtility.writeX(b.getPlateau().length)) - 1);
				b.setBoatY((OtherUtility.writeY(b.getPlateau().length)) - 1);
				OtherUtility.axe(b);
				done = done(b.getPlateau().length, b.getSave(), i,
						b.getBoatX(), b.getBoatY(), b.getAxe());
				if (!done)
					System.out
							.println("Votre placement entre en collision avec un autre bateau !"
									+ OtherUtility.newline
									+ "Choisiez une autre position :");
			}
			OtherUtility.save(b, b.getBoatX(), b.getBoatY(), i);
			if (!b.getAxe()) {
				if (b.getBoatX() + b.getLengthiness() <= b.getPlateau().length) {
					// System.err.println("Null Pointer Execption " +
					// (b.getBoatX()+b.getLengthiness()) +" !" );
					for (j = 0; j < b.getLengthiness(); j++)
						b.getPlateau()[b.getBoatX() + j][b.getBoatY()] = '¤';
					OtherUtility.save(b, b.getBoatX() + (j - 1), b.getBoatY(),
							i);
				} else {
					for (j = 0; j < b.getLengthiness(); j++)
						b.getPlateau()[b.getBoatX() - j][b.getBoatY()] = '¤';
					OtherUtility.save(b, b.getBoatX() - (j - 1), b.getBoatY(),
							i);
				}

			} else {
				if (b.getBoatY() + b.getLengthiness() <= b.getPlateau().length) {
					// System.err.println("Null Pointer Execption " +
					// (b.getBoatY()+b.getLengthiness()) +" !" );
					for (j = 0; j < b.getLengthiness(); j++)
						b.getPlateau()[b.getBoatX()][b.getBoatY() + j] = '¤';
					OtherUtility.save(b, b.getBoatX(), b.getBoatY() + (j - 1),
							i);
				} else {
					for (j = 0; j < b.getLengthiness(); j++)
						b.getPlateau()[b.getBoatX()][b.getBoatY() - j] = '¤';
					OtherUtility.save(b, b.getBoatX(), b.getBoatY() - (j - 1),
							i);
				}

			}
			System.out.print("le bateau de taille " + (b.getLengthiness())
					+ " est a la position [" + (b.getBoatX() + 1) + "]["
					+ (b.getBoatY() + 1) + "] et sera de axe ");
			if (b.getAxe())
				System.out.print("HORIZONTAL " + OtherUtility.newline);
			else
				System.out.print("VERTICAL " + OtherUtility.newline);

			i++;

		}
		GeneratorMenu.PrintBoard(b);
	}

	public static Board writeNbrBoatSave(Board b, int x) {
		if (x != 0) {
			b.setSave(new int[x][4]);
		} else {
			System.out.print("Veuilliez saisir le nombre de bateau");
			System.out.print(OtherUtility.newline);
		}
		return b;
	}

	public static Board writeLenghtBoard(Board b, int x) {
		if (x != 0) {
			b.setPlateau(new char[x][x]);
		} else {
			System.out.print("Veuilliez saisir la taille du plateau");
			System.out.print(OtherUtility.newline);
		}
		return b;
	}

	public static boolean done(int t, int[][] s, int nBoat, int x, int y,
			boolean a) {
		if (s[0][0] == (-1))
			return true;
		else {
			if (!a) {
				if (x + nBoat >= t)
					x = x - (nBoat + 1);
			} else if (y + nBoat >= t)
				y = y - (nBoat + 1);
			for (int m = 0; m < nBoat; m++) {
				if (x == s[m][0])
					if (y == s[m][1])
						return false;
				for (int l = 0; l < (nBoat + 2); l++)
					if (!a) {
						if (x + l >= s[m][0] && x + l <= s[m][2])
							if (y >= s[m][1] && y <= s[m][3])
								return false;
					} else {
						if (x >= s[m][0] && x <= s[m][2])
							if (y + l >= s[m][1] && y + l <= s[m][3])
								return false;
					}
			}
		}
		return true;
	}

	public static boolean Finish(char[][] p) {
		for (int i = 0; i < p.length; i++)
			for (int j = 0; j < p.length; j++)
				if (p[i][j] == '¤')
					return false;
		return true;
	}

	public static void Warning(int x, int y, Board b, char[][] t) {
		System.out
				.println("Le missile part en direction de la trajectoire indique :");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				System.out.print(".");
			else
				System.out.print(" ");
			try {
				OtherUtility.pause();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(OtherUtility.newline);
		if (b.getPlateau()[x - 1][y - 1] == '¤') {
			System.out
					.println("Votre missile touche violament la coque d'un bateau !");
			t[x - 1][y - 1] = 'X';
			GeneratorMenu.PrintMemo(t);
			b.getPlateau()[x - 1][y - 1] = '§';
		} else {
			System.out
					.println("Votre missile s'enfonce silencement au fond des abysse !");
			t[x - 1][y - 1] = 'X';
			GeneratorMenu.PrintMemo(t);

		}
	}

	public static void Choise(Board b, char[][] t) {
		int x, y;
		System.out
				.println("A quelle coordonnée voulez-vous envoyer votre Missile : ");
		x = OtherUtility.writeX(b.getPlateau().length);
		y = OtherUtility.writeY(b.getPlateau().length);
		Warning(x, y, b, t);
	}

	public static void LaunchGame(Board jo1, char[][] mJo1, Board jo2,
			char[][] mJo2) {
		Launch.placing(jo1, jo1.getSave().length);
		Launch.placing(jo2, jo2.getSave().length);
		while (true) {
			Choise(jo2, mJo1);
			if (Finish(jo2.getPlateau())) {
				System.out
						.println("Toute la Flotte du 'joueur 2' a ete engloutie sous la supremacie tatique du 'joueur 1' ."
								+ OtherUtility.newline + "Fin de la partie");
				break;
			}
			Choise(jo1, mJo2);
			if (Finish(jo1.getPlateau())) {
				System.out
						.println("Toute la Flotte du 'joueur 1' a ete engloutie sous la supremacie tatique du 'joueur 2' ."
								+ OtherUtility.newline + "Fin de la partie");

				break;
			}

		}
	}
}
