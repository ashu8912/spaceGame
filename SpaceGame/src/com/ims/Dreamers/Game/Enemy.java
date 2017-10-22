package com.ims.Dreamers.Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.ims.Dreamers.GameUtils.GameUtils;

public class Enemy extends Sprite implements IGameConstants {
private Image enemyImage;
Player player=new Player();

public Image getEnemyImage() {
	return enemyImage;
}
public void setEnemyImage(Image enemyImage) {
	this.enemyImage = enemyImage;
}
ArrayList<Bullets> bullets =new ArrayList<>();
public void move()
{
	y=y+speed;
}
public Rectangle getBounds()
{
	return new Rectangle(x, y, w, h);
}
public Enemy(int x)
{this.x=x;
y=10;
w=h=100;
enemyImage=new ImageIcon(Enemy.class.getResource("alien2.gif")).getImage();
isVisible=true;
}
public void addBullets()
{Bullets bullet=new Bullets(this.x+(this.w)/2,this.y+this.h);
	bullets.add(bullet);
}
public void draw(Graphics g)
{g.drawImage(enemyImage, x, y, w, h,null);
}
public void drawBullets(Graphics g)
{for(Bullets bullet:bullets)
{if(bullet.y<GAME_HEIGHT-player.h)
{
	bullet.drawBullet(g, 2);
}
//if(bullet.y==GAME_HEIGHT/2)
//{bullet.setVisible(false);
//
//}

	
}
	
}
}
