package com.bc.game.engine.math;

import java.awt.Shape;

public class Rotation {
	private double degrees;
	private double anchorX;
	private double anchorY;
	
	public Rotation(){
		
	}
	
	public void setDegrees(double degrees){
		this.degrees = degrees;
	}
	
	public void setAnchorX(double anchorX){
		this.anchorX = anchorX;
	}
	
	public void setAnchorY(double anchorY){
		this.anchorY = anchorY;
	}
	
	public double getDegrees(){
		return this.degrees;
	}
	
	public double getAnchorX(){
		return this.anchorX;
	}
	
	public double getAnchorY(){
		return this.anchorY;
	}
	
	public void rotate(double degrees){
		this.degrees = Math.toRadians(degrees);
	}
	
	public void rotateAroundAxis(double degrees, Vector2 axis){
		this.degrees = Math.toRadians(degrees);
		this.anchorX = axis.x;
		this.anchorY = axis.y;
	}
	
	public void rotateAroundCenterAxis(double degrees, Shape shape){
		this.degrees = Math.toRadians(degrees);
		this.anchorX = shape.getBounds2D().getWidth() + shape.getBounds2D().getWidth() / 2;
		this.anchorY = shape.getBounds2D().getHeight() + shape.getBounds2D().getHeight() / 2;
	}
}
