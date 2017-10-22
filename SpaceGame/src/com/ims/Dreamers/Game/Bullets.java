package com.ims.Dreamers.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullets extends Sprite implements IGameConstants {

	public Bullets(int x,int y)
	{w=h=10;
		this.x=x;
		this.y=y;
		yspeed=-10;
	isVisible=true;
	}
	public Rectangle getBounds()
	{return new Rectangle(x, y, w, h);
		
	}
	public void move()
	{
		y+=yspeed;
	}
	public void move1()
	{
		y+=10;
	}
	public void drawBullet(Graphics g,int Owner)
	{if(Owner==1)
	{
		g.setColor(Color.GREEN);
		move();	
	}
	if(Owner==2)
	{
	g.setColor(Color.RED);
	move1();
	}
	g.fillOval(this.x, this.y, w, h);
	

	}
	
		
}
