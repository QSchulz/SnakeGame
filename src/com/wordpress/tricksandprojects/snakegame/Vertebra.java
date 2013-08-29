package com.wordpress.tricksandprojects.snakegame;


public class Vertebra{
	/**
	 * 
	 */
	private Direction nextMoveDirection;
	private int posXOfLeftTopCorner;
	private int posYOfLeftTopCorner;
	
	public Vertebra(int posXOfLeftTopCorner, int posYOfLeftTopCorner, Direction direction) {
		// TODO Auto-generated constructor stub
		this.posXOfLeftTopCorner = new Integer(posXOfLeftTopCorner);
		this.posYOfLeftTopCorner = new Integer(posYOfLeftTopCorner);
		this.nextMoveDirection = direction;
	}
	public void setNextMoveDirection(Direction direction){
		nextMoveDirection = direction;
	}
	public void setPosXOfLeftTopCorner(int posXOfLeftTopCorner) {
		this.posXOfLeftTopCorner = posXOfLeftTopCorner;
	}
	public int getPosXOfLeftTopCorner() {
		return posXOfLeftTopCorner;
	}
	public Direction getNextMoveDirection() {
		return nextMoveDirection;
	}
	public int getPosYOfLeftTopCorner() {
		return posYOfLeftTopCorner;
	}
	public void setPosYOfLeftTopCorner(int posYOfLeftTopCorner) {
		this.posYOfLeftTopCorner = posYOfLeftTopCorner;
	}
}
