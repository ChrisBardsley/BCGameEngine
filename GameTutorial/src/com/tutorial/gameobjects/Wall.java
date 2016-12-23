package com.tutorial.gameobjects;

import java.awt.Color;

import com.bc.game.engine.GameObject;

public class Wall extends GameObject {

	public Wall() {
		super("wall");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		this.getRenderer().DrawRectangle(Color.BLUE);		
	}

	@Override
	public void onCollision(GameObject entity) {
		// TODO Auto-generated method stub
		
	}

}
