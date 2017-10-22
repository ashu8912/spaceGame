package com.ims.Dreamers.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.ims.Dreamers.GameUtils.GameUtils;

public class Board extends JPanel implements IGameConstants{
	private Image backgroundImage;
	private Player player;
	private int count;
private int timerCount;
	private boolean play;
private boolean isGameOver;
int counter=0;
public boolean isGameOver() {
	return isGameOver;
}

public void setGameOver(boolean isGameOver) {
	this.isGameOver = isGameOver;
}
public void drawGameOver(Graphics g)
{isGameOver=true;
	for(Enemy enemy:enemies)
{
if(enemy.isVisible())
	{isGameOver=false;
	break;
	}
}if(isGameOver)
{g.setFont(new Font("Arial",Font.BOLD,50));
g.setColor(Color.RED);
	String val="GameOver";
g.drawString(val, GAME_WIDTH/2, GAME_HEIGHT/2);
play=false;
}
	
}
	private Enemy enemies[]=new Enemy[MAX_ENEMY]; 
	private Timer timer;
	int enemyBullet=0;
	static GameUtils g=new GameUtils(MAX_ENEMY);
	
	public void loadEnemies()
	{int x=0;
		for(int i=0;i<MAX_ENEMY;i++)
	{enemies[i]=new Enemy(x);
	x+=150;
	}
	}

	private void bindEvents()
	{
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e)
			{player.stop();
			}
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_UP)
				{
					player.up();
				}
				
				if(e.getKeyCode()==KeyEvent.VK_SPACE)
				{
					//player.addBullets();
					player.addBullets();
				
					
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					player.down();
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					player.right();
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT)
				{
					player.left();
				}
			}
			});
	}
	public void checkCollision()
	{
		for(Enemy enemy:enemies)
	{for(Bullets bullet:player.bullets)
		
			{if(enemy.getBounds().intersects(bullet.getBounds()))
			{
				count++;
			
            enemy.setVisible(false);
            
			}
			
			}
	
	}
		for(Enemy enemy:enemies)
		{
			for(Bullets bulletq:enemy.bullets)
			{
				if(bulletq.getBounds().intersects(player.getBounds()))
				{
					player.setVisible(false);
					//System.out.println(player.isVisible());
				}
			}
		}
	}
		
	
	
	
	private void loadImages()
{backgroundImage=new ImageIcon(Board.class.getResource("space.jpg")).getImage();
}
	private void gameLoop()
	{
		timer=new Timer(GAME_SPEED,(e)->{
			if(play)
			{
			repaint();
			checkCollision();		
			player.move();
			enemyBullet+=50;
			
			timerCount+=50;
			if(timerCount==500)
			{
				for(Enemy enemy:enemies)
				{
					enemy.move();
				}
			
			timerCount=0;
			}			//System.out.println(enemyBullet);
			if(enemyBullet==1000)
			{
			
				enemies[g.getRandomNumber()].addBullets();
			
			enemyBullet=0;
			}
			}
		});
		timer.start();
	}
	private void drawBackground(Graphics g)
	{g.drawImage(backgroundImage,0,0,GAME_WIDTH,GAME_HEIGHT,null);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	drawBackground(g);
	if(player.isVisible())
	{
	player.drawPlayer(g);
	}
	else
	{g.setFont(new Font("Arial",Font.BOLD,50));
g.setColor(Color.RED);
	String val1="YouLost";
g.drawString(val1, GAME_WIDTH/2, GAME_HEIGHT/2);
		play=false;
	}
	
	for(Enemy enemy:enemies)
	{if(!isGameOver())
		{if(enemy.isVisible())
		{enemy.draw(g);
		enemy.drawBullets(g);
	
		}
		
		}
}
	drawGameOver(g);
	
player.drawBullets(g);
		}
public Board()
	{setSize(GAME_WIDTH,GAME_HEIGHT);
	play=true;
	player=new Player();
	loadEnemies();
	loadImages();
	gameLoop();
	setFocusable(true);	
	bindEvents();
	
	}}
