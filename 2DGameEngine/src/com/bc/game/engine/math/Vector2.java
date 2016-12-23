package com.bc.game.engine.math;

public class Vector2 {
	
	public double x = 0;
	public double y = 0;
	
	public Vector2(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2(){
		this(0, 0);
	}
	
	public Vector2 Add(Vector2 vector2){
		return new Vector2(x + vector2.x, y + vector2.y);
	}
	
	public Vector2 Add(double num){
		return new Vector2(x + num, y + num);
	}
	
	public Vector2 Subtract(Vector2 vector2){
		return new Vector2(x - vector2.x, y - vector2.y);		
	}
	
	public Vector2 Subtract(double num){
		return new Vector2(x - num, y - num);		
	}
	
	public Vector2 Multiply(Vector2 vector2){
		return new Vector2(x * vector2.x, y * vector2.y);
	}
	
	public Vector2 Multiply(double num){
		return new Vector2(x * num, y * num);
	}
	
	public static Vector2 Create(double _x, double _y){
		return new Vector2(_x, _y);
	}
	
	public static Vector2 Zero(){
		return new Vector2();
	}
	
	public static Vector2 Up(){
		return new Vector2(0, -1);
	}
	
	public static Vector2 Down(){
		return new Vector2(0, 1);
	}
	
	public static Vector2 Left(){
		return new Vector2(-1, 0);
	}
	
	public static Vector2 Right(){
		return new Vector2(1, 0);
	}
}
