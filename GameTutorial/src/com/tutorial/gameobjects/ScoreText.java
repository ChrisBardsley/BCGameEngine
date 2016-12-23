package com.tutorial.gameobjects;

import java.awt.Color;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.math.Vector2;

public class ScoreText extends GameObject{
	
	private static final String TAG = "scoretext";
	private static final Vector2 STARTING_POSITION = Vector2.Create(530, 20);
	
	private int score;

	public ScoreText() {
		super(STARTING_POSITION, TAG);
	}
	
	public void updateScore(int value){
		this.score += value;
	}
	
	public int getScore(){
		return this.score;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render() {
		this.getRenderer().drawText(Color.WHITE, 16, STARTING_POSITION, String.format("Score (%s)", this.score));
	}

	@Override
	public void onCollision(GameObject entity) {
		// TODO Auto-generated method stub
		
	}

}
