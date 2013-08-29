package com.wordpress.tricksandprojects.snakegame;

public enum Direction {
	North,
	South,
	East,
	West;
	private Direction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public boolean isOpposed(Direction other){
		if (this == Direction.East && other == Direction.West)
			return true;
		if (this == Direction.West && other == Direction.East)
			return true;
		if (this == Direction.North && other == Direction.South)
			return true;
		if (this == Direction.South && other == Direction.North)
			return true;
		return false;
	}
}
