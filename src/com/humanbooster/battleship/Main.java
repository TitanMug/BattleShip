package com.humanbooster.battleship;

import com.humanbooster.battleship.Menu.GeneratorMenu;
import com.humanbooster.battleship.Utility.Board;
import com.humanbooster.battleship.Utility.Launch;
import com.humanbooster.battleship.Utility.OtherUtility;

/**
 * @author hb
 *
 */
public class Main {

	public static void main(String[] args) {
		int taille = 5;
		int nbrBateau = 1;
		GeneratorMenu.title();
		Board carteJ1 = new Board();
		Board memoJ1 = new Board();
		Board carteJ2 = new Board();
		Board memoJ2 = new Board();
		OtherUtility.fillBoard(Launch.writeLenghtBoard(carteJ1, taille));
		OtherUtility.fillBoard(Launch.writeLenghtBoard(memoJ1, taille));
		OtherUtility.fillSave(Launch.writeNbrBoatSave(carteJ1, nbrBateau));
		OtherUtility.fillBoard(Launch.writeLenghtBoard(carteJ2, taille));
		OtherUtility.fillBoard(Launch.writeLenghtBoard(memoJ2, taille));
		OtherUtility.fillSave(Launch.writeNbrBoatSave(carteJ2, nbrBateau));

		Launch.LaunchGame(carteJ1, memoJ1.getPlateau(), carteJ2,
				memoJ2.getPlateau());

	}
}
