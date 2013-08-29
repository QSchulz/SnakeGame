package com.wordpress.tricksandprojects.snakegame;
import javax.swing.JFrame;


public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	GamePanel gamePanel;
////	Map map;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameWindow();
	}
	public GameWindow() {
		// TODO Auto-generated constructor stub
		gamePanel = new GamePanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(gamePanel);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		try {
			boolean newGame = gamePanel.go();
			if (newGame)
			{
				this.dispose();
				new GameWindow();
			}
			else
				System.exit(NORMAL);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
