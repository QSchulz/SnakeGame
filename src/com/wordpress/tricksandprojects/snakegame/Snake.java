package com.wordpress.tricksandprojects.snakegame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;


public class Snake implements KeyListener{
	/**
	 * 
	 */
	private static final int STARTING_SIZE = 3;
	private LinkedList<Vertebra> body;

	public Snake() {
		// TODO Auto-generated constructor stub
		super();
		body = new LinkedList<Vertebra>();
		body.add(new Vertebra(GamePanel.SPACE_BETWEEN_SQUARES,420, Direction.East));
		for (int count=1; count<STARTING_SIZE; count++)
			this.addVertebra(body.getLast());
	}
	private void addVertebra(Vertebra lastVertebra){
		if (lastVertebra.getNextMoveDirection() == Direction.East)
			body.add(new Vertebra(body.getLast().getPosXOfLeftTopCorner()-GamePanel.SQUARE_SIZE-GamePanel.SPACE_BETWEEN_SQUARES, body.getLast().getPosYOfLeftTopCorner(), Direction.East));
		else if (lastVertebra.getNextMoveDirection() == Direction.West)
			body.add(new Vertebra(body.getLast().getPosXOfLeftTopCorner()+GamePanel.SQUARE_SIZE+GamePanel.SPACE_BETWEEN_SQUARES, body.getLast().getPosYOfLeftTopCorner(), Direction.West));
		else if (lastVertebra.getNextMoveDirection() == Direction.South)
			body.add(new Vertebra(body.getLast().getPosXOfLeftTopCorner(), body.getLast().getPosYOfLeftTopCorner()-GamePanel.SQUARE_SIZE-GamePanel.SPACE_BETWEEN_SQUARES, Direction.South));
		else
			body.add(new Vertebra(body.getLast().getPosXOfLeftTopCorner(), body.getLast().getPosYOfLeftTopCorner()+GamePanel.SQUARE_SIZE+GamePanel.SPACE_BETWEEN_SQUARES, Direction.North));
	}
	public void eat(){
		this.addVertebra(body.getLast());
	}
	public void nextMove(){
		for (Vertebra vertebra : body)
		{
			if (vertebra.getNextMoveDirection() == Direction.East)
			{
				if (vertebra.getPosXOfLeftTopCorner() + GamePanel.SQUARE_SIZE + GamePanel.SPACE_BETWEEN_SQUARES<GamePanel.WIDTH)
					vertebra.setPosXOfLeftTopCorner(vertebra.getPosXOfLeftTopCorner() + GamePanel.SQUARE_SIZE + GamePanel.SPACE_BETWEEN_SQUARES);
				else
					vertebra.setPosXOfLeftTopCorner(GamePanel.SPACE_BETWEEN_SQUARES);
			}					
			else if (vertebra.getNextMoveDirection() == Direction.West)
			{
				if (vertebra.getPosXOfLeftTopCorner() - GamePanel.SPACE_BETWEEN_SQUARES>0)
					vertebra.setPosXOfLeftTopCorner(vertebra.getPosXOfLeftTopCorner() - GamePanel.SQUARE_SIZE - GamePanel.SPACE_BETWEEN_SQUARES);
				else
					vertebra.setPosXOfLeftTopCorner(GamePanel.WIDTH-GamePanel.SQUARE_SIZE - GamePanel.SPACE_BETWEEN_SQUARES);
			}
			else if (vertebra.getNextMoveDirection() == Direction.South)
			{
				if (vertebra.getPosYOfLeftTopCorner() + GamePanel.SQUARE_SIZE + GamePanel.SPACE_BETWEEN_SQUARES<GamePanel.HEIGHT)
					vertebra.setPosYOfLeftTopCorner(vertebra.getPosYOfLeftTopCorner() + GamePanel.SQUARE_SIZE + GamePanel.SPACE_BETWEEN_SQUARES);
				else
					vertebra.setPosYOfLeftTopCorner(GamePanel.SPACE_BETWEEN_SQUARES);
			}
			else
			{
				if (vertebra.getPosYOfLeftTopCorner() - GamePanel.SPACE_BETWEEN_SQUARES>0)
					vertebra.setPosYOfLeftTopCorner(vertebra.getPosYOfLeftTopCorner() - GamePanel.SQUARE_SIZE - GamePanel.SPACE_BETWEEN_SQUARES);
				else
					vertebra.setPosYOfLeftTopCorner(GamePanel.HEIGHT - GamePanel.SQUARE_SIZE - GamePanel.SPACE_BETWEEN_SQUARES);
			}
		}
		for (int count=body.size()-1; count>=1; count--)
			body.get(count).setNextMoveDirection(body.get(count-1).getNextMoveDirection());
	}
	public void setNextMoveDirection(Direction newDirection){
		Direction currentDirection = body.getFirst().getNextMoveDirection();
		if (!currentDirection.isOpposed(newDirection))
			body.getFirst().setNextMoveDirection(newDirection);
	}
	
	public boolean collisionWith(Snake snake) {
		// TODO Auto-generated method stub
		for (int count=body.size()-1; count>=1; count--)
			if (body.getFirst().getPosXOfLeftTopCorner()==body.get(count).getPosXOfLeftTopCorner() &&
					body.getFirst().getPosYOfLeftTopCorner()==body.get(count).getPosYOfLeftTopCorner())
				return true;
		return false;
	}
//	public boolean collisionWith(Map map){
//		
//	}
	public LinkedList<Vertebra> getBody() {
		return body;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
			case 37:this.setNextMoveDirection(Direction.West);break;
			case 38:this.setNextMoveDirection(Direction.North);break;
			case 39:this.setNextMoveDirection(Direction.East);break;
			case 40:this.setNextMoveDirection(Direction.South);break;
		};
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public boolean canEat(Bait bait) {
		// TODO Auto-generated method stub
		if (body.getFirst().getPosXOfLeftTopCorner() == bait.getPosXOfLeftTopCorner() && 
				body.getFirst().getPosYOfLeftTopCorner() == bait.getPosYOfLeftTopCorner())
			return true;
		return false;
	}
}
