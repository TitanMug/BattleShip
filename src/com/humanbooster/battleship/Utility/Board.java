package com.humanbooster.battleship.Utility;

public class Board {
	private char[][] plateau;
	private int boatX;
	private int boatY;
	private int lengthiness;
	private Boolean axe;
	private int[][] save;

	public Board() {
		super();
	}

	public Board(char[][] P) {
		super();
		this.plateau = P;
		this.boatX = boatX;
		this.boatY = boatY;
		this.lengthiness = lengthiness;
		this.axe = axe;
		this.save = save;

	}

	public int[][] getSave() {
		return save;
	}

	public void setSave(int[][] save) {
		this.save = save;
	}

	public Boolean getAxe() {
		return axe;
	}

	public void setAxe(Boolean axe) {
		this.axe = axe;
	}

	public int getBoatX() {
		return boatX;
	}

	public void setBoatX(int boatX) {
		this.boatX = boatX;
	}

	public int getBoatY() {
		return boatY;
	}

	public void setBoatY(int boatY) {
		this.boatY = boatY;
	}

	public int getLengthiness() {
		return lengthiness;
	}

	public void setLengthiness(int lengthiness) {
		this.lengthiness = lengthiness;
	}

	public char[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(char[][] plateau) {
		this.plateau = plateau;
	}
}
