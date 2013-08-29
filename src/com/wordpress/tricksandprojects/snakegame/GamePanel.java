package com.wordpress.tricksandprojects.snakegame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Snake snake;
	private Bait bait;
	private JLabel jlabel;
	protected static final int SQUARE_SIZE = 20;
	protected static final int SPACE_BETWEEN_SQUARES = 2;
	protected static final int WIDTH = 442;
	protected static final int HEIGHT = 442;
	private Thread t = new Thread();
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		snake = new Snake();
		bait = new Bait(WIDTH-SQUARE_SIZE, HEIGHT-SQUARE_SIZE);
		jlabel = new JLabel("Score: "+Bait.getNumberOfEatenBaits());
		this.add(jlabel);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(snake);
		this.setVisible(true);
	}
	public boolean go() throws InterruptedException{
		while(!snake.collisionWith(snake))// && !snake.collisionWith(map))
		{
			Thread.sleep(1000);
			if (snake.canEat(bait))
			{
				snake.eat();
				bait = new Bait(WIDTH-SQUARE_SIZE, HEIGHT-SQUARE_SIZE);
				jlabel.setText("Score: "+Bait.getNumberOfEatenBaits());
			}
			snake.nextMove();
			this.repaint();
		}
		return this.replay();
	}
	public boolean replay(){
		
		JOptionPane.showMessageDialog(this, "Game Over.");
		Object[] options = {"Yes, please",
                "No, thanks",};
		int n = JOptionPane.showOptionDialog(this,
											"Would you like to replay ?",
											"Try Again",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[1]);
		if (n==0)
		{
			Bait.resetNumberOfEatenBaits();
			return true;
		}
		return false;
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.GREEN);
		g.fillRect(bait.getPosXOfLeftTopCorner(), bait.getPosYOfLeftTopCorner(), SQUARE_SIZE, SQUARE_SIZE);
		g.setColor(Color.BLACK);
		for (Vertebra vertebra : snake.getBody())
			g.fillRect(vertebra.getPosXOfLeftTopCorner(), vertebra.getPosYOfLeftTopCorner(), SQUARE_SIZE, SQUARE_SIZE);
	}
}
