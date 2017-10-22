package com.ims.Dreamers.Game;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements IGameConstants {
	Board board=new Board();
	public GameFrame()
	{
	setSize(GAME_WIDTH,GAME_HEIGHT);
	setLocationRelativeTo(null);
	setResizable(false);
	
	setVisible(true);
	add(board);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame=new GameFrame();

	}

}
