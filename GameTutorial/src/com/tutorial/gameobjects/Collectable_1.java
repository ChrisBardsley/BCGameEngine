package com.tutorial.gameobjects;

import java.awt.Color;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.math.Size;
import com.bc.game.engine.math.Vector2;

public class Collectable_1 extends GameObject {

	private static final double SPEED = 4.5;
	private static final int SCORE_VALUE = 10;
	private static final String TAG = "collectable_1";
	private static final Vector2 STARTING_POSITION = Vector2.Create(100, 0);
	private static final Size SIZE = new Size(10d, 10d);
	
	private boolean scoreAdded = false;
	
	public Collectable_1() {
		super(STARTING_POSITION, SIZE, TAG);
	}

	@Override
	public void tick() {
		this.getTransform().Translate(Vector2.Down().Multiply(SPEED));
		if(this.getTransform().GetPosition().y > 500){
			this.Destroy();
		}
	}

	@Override
	public void render() {
		this.getRenderer().drawEllipse(Color.GREEN);		
	}

	@Override
	public void onCollision(GameObject entity) {
		if(entity.getTag() == "box" && !scoreAdded){
			ScoreText score = (ScoreText)this.GetScene().getGameObjects("scoretext").get(0);
			score.updateScore(SCORE_VALUE);
			this.scoreAdded = true;
			this.Destroy();
		}
		
	}

}
