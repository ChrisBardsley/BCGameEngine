package com.tutorial.gameobjects;

import java.awt.Color;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.math.Vector2;

public class StartLevelText extends GameObject{
	
	private static final String TAG = "startleveltext";
	private static final Vector2 STARTING_POSITION = Vector2.Create(270, 230);
	private static final long DISPLAY_TIME = 2100000000;
	
	private int level;
	private long spawnTime = System.nanoTime();

	public StartLevelText(int level) {
		super(STARTING_POSITION, TAG);
		this.level = level;
	}

	@Override
	public void tick() {
		long currentTickTime = System.nanoTime();
		if(currentTickTime - spawnTime > DISPLAY_TIME){
			this.Destroy();
		}
		
	}

	@Override
	public void render() {
		this.getRenderer().drawText(Color.WHITE, 28, STARTING_POSITION, String.format("Level %s", this.level));
	}

	@Override
	public void onCollision(GameObject entity) {
		// TODO Auto-generated method stub
		
	}

}
