package com.tutorial.gameobjects;

import java.awt.Color;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.input.KeyInput;
import com.bc.game.engine.math.Vector2;
import com.tutorial.scenes.Level1;

public class GameOverText extends GameObject{
	
	private static final String TAG = "gameovertext";
	private static final Vector2 STARTING_POSITION = Vector2.Create(250, 230);

	public GameOverText() {
		super(STARTING_POSITION, TAG);
	}

	@Override
	public void tick() {		
		if(KeyInput.IsKeyCommandTriggered("FIRE")){
			this.LoadScene(new Level1());
		}
	}

	@Override
	public void render() {
		this.getRenderer().drawText(Color.WHITE, 28, STARTING_POSITION, "Game Over!");
		this.getRenderer().drawText(Color.WHITE, 20, STARTING_POSITION.Subtract(Vector2.Create(40, -40)), "Press [Space] to Start Over");
	}

	@Override
	public void onCollision(GameObject entity) {
		// TODO Auto-generated method stub
		
	}

}
