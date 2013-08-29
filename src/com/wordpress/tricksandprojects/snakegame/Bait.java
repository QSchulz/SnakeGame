package com.wordpress.tricksandprojects.snakegame;

import java.util.Random;

public class Bait {
	private int posXOfLeftTopCorner;
	private int posYOfLeftTopCorner;
	private static int numberOfEatenBaits = -1;
	private Random random = new Random();
	
	public Bait(int posXOfLeftTopCorner, int posYOfLeftTopCorner) {
		// TODO Auto-generated constructor stub
		this.posXOfLeftTopCorner = random.nextInt(posXOfLeftTopCorner)/22*22+2;
		this.posYOfLeftTopCorner = random.nextInt(posYOfLeftTopCorner)/22*22+2;
		++numberOfEatenBaits;
	}
	public int getPosXOfLeftTopCorner() {
		return posXOfLeftTopCorner;
	}
	public int getPosYOfLeftTopCorner() {
		return posYOfLeftTopCorner;
	}
	public void setPosXOfLeftTopCorner(int posXOfLeftTopCorner) {
		this.posXOfLeftTopCorner = posXOfLeftTopCorner;
	}
	public void setPosYOfLeftTopCorner(int posYOfLeftTopCorner) {
		this.posYOfLeftTopCorner = posYOfLeftTopCorner;
	}
	public static int getNumberOfEatenBaits() {
		return numberOfEatenBaits;
	}
	public static void resetNumberOfEatenBaits() {
		// TODO Auto-generated method stub
		numberOfEatenBaits = -1;
	}
}
