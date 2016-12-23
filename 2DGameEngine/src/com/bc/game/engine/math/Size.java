package com.bc.game.engine.math;

public class Size {
	
	private double width = 0;
	private double height = 0;
	
	public Size(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public Size(){
		
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public void setWidth(double width){
		this.width = width;		
	}
	
	public void setHeight(double height){
		this.height = height;
	}
}
