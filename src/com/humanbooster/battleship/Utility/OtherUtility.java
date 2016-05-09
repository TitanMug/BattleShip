package com.humanbooster.battleship.Utility;

import java.io.IOException;
import java.util.Scanner;

public class OtherUtility {
	public static final Scanner SC = new Scanner(System.in);
	public final static String LINE = "-----------------------------";
	public static String newline = System.getProperty("line.separator");

	public static void fillBoard(Board b) {
		for (int i = 0; i < b.getPlateau().length; i++)
			// for (char[] x : b.getPlateau()) à reflechir
			for (int j = 0; j < b.getPlateau().length; j++)
				b.getPlateau()[i][j] = '§';

	}

	public static void pause() throws InterruptedException {
		Thread.sleep(500);
	}

	public static void fillSave(Board b) {
		for (int i = 0; i < b.getSave().length; i++)
			for (int j = 0; j < b.getSave()[i].length; j++)
				b.getSave()[i][j] = (-1);
	}

	public int write() {
		System.out.print(newline);
		return SC.nextInt();
	}

	public static int axe() {
		int data = (-1);
		System.out.print(newline);
		while (data < 1 || data > 2) {
			System.out.println("Choisir entre 1 ou 2 : ");
			data = SC.nextInt();
		}

		return data;
	}

	public static int writeX(int t) {
		int data = (-1);
		while (data < 1 || data > t) {
			System.out.print("Entre la valeur de X ( Entre [1] & [" + t
					+ "] ) : ");
			System.out.print(newline);
			data = SC.nextInt();
		}
		return data;
	}

	public static int writeY(int t) {
		int data = (-1);
		while (data < 1 || data > t) {
			System.out.print("Entre la valeur de Y ( Entre [1] & [" + t
					+ "] ) : ");
			System.out.print(newline);
			data = SC.nextInt();
		}
		return data;
	}

	public static void axe(Board b) {
		int data;
		System.out.print(" Quelle sera l'axe du bateau");
		System.out.print(OtherUtility.newline);
		System.out.println(" 1 - HORIZONTAL");
		System.out.println(" 2 - VERTICAL");
		System.out.println(OtherUtility.LINE);
		data = OtherUtility.axe();
		switch (data) {
		case 1:
			b.setAxe(true);
			break;
		case 2:
			b.setAxe(false);
			break;
		}
	}

	public static void save(Board b, int x, int y, int i) {
		int j = 0;
		int g;
		while (b.getSave()[i][j] != (-1))
			j++;
		b.getSave()[i][j] = x;
		j++;
		b.getSave()[i][j] = y;

		if (b.getSave()[i][3] != (-1)) {
			if (b.getSave()[i][0] > b.getSave()[i][2]) {
				g = b.getSave()[i][0];
				b.getSave()[i][0] = b.getSave()[i][2];
				b.getSave()[i][2] = g;
			}
			if (b.getSave()[i][1] > b.getSave()[i][3]) {
				g = b.getSave()[i][1];
				b.getSave()[i][1] = b.getSave()[i][3];
				b.getSave()[i][3] = g;
			}

		}

	}

	public static void readInt() {
		int value;
		boolean done;
		do {
			done = false;
			try {
				byte[] buffer = new byte[512];
				System.in.read(buffer);
				String s = new String(buffer);
				s = s.trim();
				value = Integer.parseInt(s);

			} catch (IOException e) {
				System.out
						.println(" Votre Entrée est trop Grande veilliez saisir un autre nombre :");
				done = true;
			} catch (NumberFormatException n) {
				System.out
						.println(" Votre Entrée est incorrect veilliez saisir un autre nombre :");
				done = true;
			}
		} while (done);
	}
}