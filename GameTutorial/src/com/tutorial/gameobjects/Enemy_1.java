package com.tutorial.gameobjects;

import java.awt.Color;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.SceneState;
import com.bc.game.engine.math.Size;
import com.bc.game.engine.math.Vector2;

public class Enemy_1 extends GameObject {

	private static final double SPEED = 4.5;
	private static final String TAG = "enemy_1";
	private static final Vector2 STARTING_POSITION = Vector2.Create(100, 0);
	private static final Size SIZE = new Size(10d, 10d);
	
	private boolean enemyCollisionTriggered = false;
	
	public Enemy_1() {
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
		this.getRenderer().drawEllipse(Color.RED);		
	}

	@Override
	public void onCollision(GameObject entity) {
		if(entity.getTag() == "box" && !this.enemyCollisionTriggered){
			this.GetScene().setSceneState(SceneState.GameOver);
			this.GetScene().getGameObjects().add(new GameOverText());
			this.enemyCollisionTriggered = true;
		}
		
	}

}
