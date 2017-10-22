package com.ims.Dreamers.Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Rect;

public class Player extends Sprite implements IGameConstants{
	private Image playerImage;
	//private Bullets bullet=new Bullets(this.x,this.y);
	ArrayList<Bullets> bullets=new ArrayList<>();
	
	public void addBullets()
	{
		Bullets bullet =new Bullets(this.x+(w/2)-7,this.y-10);
		bullets.add(bullet);
	
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,w,h);
		} 
	
	public boolean isCollision(Bullets bullet,Enemy enemy) {
		System.out.println("enemy y"+enemy.y);
	return Math.abs(bullet.y-enemy.y)<=enemy.h && 
			Math.abs(enemy.x-bullet.x)<=enemy.w && bullet.x>=enemy.x;
	}
	
	public void drawBullets(Graphics g)
	{for(Bullets bullet:bullets)
	{if(bullet.y>25)
		bullet.drawBullet(g,1);}}
	
	public void up()
	{
		yspeed=-speed;
	}
	public void down()
	{
		yspeed=speed;
	}
	public void left()
	{
		xspeed=-speed;
	}
	public void right()
	{
		xspeed=speed;
	}
	public void move()
	{
		x+=xspeed;
		y+=yspeed;
	}
	public void stop()
	{
		xspeed=0;
		yspeed=0;
	}
	public Player()
	{isVisible=true;
playerImage=new ImageIcon(Player.class.getResource("rocket.gif")).getImage();		
		w=h=100;
		x=(GAME_WIDTH/2)-(w/2);
		y=(GAME_HEIGHT/2)+(h+50);
		xspeed=0;
		yspeed=0;
		
	}
	public void drawPlayer(Graphics g)
{g.drawImage(playerImage, x,y,w ,h ,null);
	}
}
   