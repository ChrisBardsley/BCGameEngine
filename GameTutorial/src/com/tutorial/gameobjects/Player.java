package com.tutorial.gameobjects;

import java.awt.Color;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.SceneState;
import com.bc.game.engine.input.KeyInput;
import com.bc.game.engine.math.Size;
import com.bc.game.engine.math.Vector2;

public class Player extends GameObject {

    private static final double SPEED = 3.5;
    private static final String TAG = "box";
	private static final Vector2 STARTING_POSITION = Vector2.Create(400, 400);
	private static final Size SIZE = new Size(50d, 10d);
	
	private boolean canMoveLeft = true;
	private boolean canMoveRight = true;
	
	public Player() {
		super(STARTING_POSITION, SIZE, TAG);
	}

	@Override
	public void tick() {
		if(this.GetScene().getSceneState() != SceneState.Normal)
			return;
		
		if(KeyInput.IsKeyCommandPressed("MOVE_RIGHT") && this.canMoveRight){
			this.getTransform().Translate(Vector2.Right().Multiply(SPEED));
		}
		if(KeyInput.IsKeyCommandPressed("MOVE_LEFT") && this.canMoveLeft){
			this.getTransform().Translate(Vector2.Left().Multiply(SPEED));
		}
		
		this.canMoveLeft = true;
		this.canMoveRight = true;
	}

	@Override
	public void render() {
		this.getRenderer().DrawRectangle(Color.WHITE);
	}

	@Override
	public void onCollision(GameObject entity) {
		if(entity.getTag() == "leftwall"){
			this.canMoveLeft = false;
		}
		if(entity.getTag() == "rightwall"){
			this.canMoveRight = false;
		}
	}

}
