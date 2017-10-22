package com.ims.Dreamers.Game;

public abstract class Sprite {
	protected int w;
	protected int xspeed;
	protected int yspeed;
	final int speed=4;
	protected int h;
	protected int x;
	protected boolean isVisible;
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	protected int y;
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getXspeed() {
		return xspeed;
	}
	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}
	public int getYspeed() {
		return yspeed;
	}
	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	
	

}
