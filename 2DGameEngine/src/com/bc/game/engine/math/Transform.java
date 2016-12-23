package com.bc.game.engine.math;

public class Transform {
	
	private Vector2 position;
	private Rotation rotation;
	
	public Transform(Vector2 position){
		this.position = position;
		this.rotation = new Rotation();
	}
	
	public Transform(){
		this(Vector2.Zero());
	}
	
	public void Set(Vector2 vector2){
		this.position = vector2;
	}
	
	public Vector2 GetPosition(){
		return this.position;
	}
	
	public Rotation GetRotation(){
		return this.rotation;
	}
	
	public void Translate(Vector2 value){
		this.position = this.position.Add(value);
	}
}
