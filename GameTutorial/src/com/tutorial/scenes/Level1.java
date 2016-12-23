package com.tutorial.scenes;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.Scene;
import com.bc.game.engine.SceneState;
import com.tutorial.gameobjects.Collectable_1;
import com.tutorial.gameobjects.Enemy_1;
import com.tutorial.gameobjects.Player;
import com.tutorial.gameobjects.ScoreText;
import com.tutorial.gameobjects.StartLevelText;
import com.tutorial.gameobjects.Wall;

public class Level1 extends Scene {

	private long nextEnemySpawn = 0;
	private long nextCollectableSpawn = 0;
	
	public Level1() {
		super("Level 1");
		
		this.addGameObject(new Player());
		for(GameObject item: createLevel()){
			this.addGameObject(item);
		}
		
		this.addGameObject(new StartLevelText(1));
		this.addGameObject(new ScoreText());
	}

	@Override
	public void tick(){
		if(this.getSceneState() == SceneState.Normal){
			this.SpawnEnemys();
			this.SpawnCollectables();
		}
		
		super.tick();
	}
	
	@Override
	public void Render(Graphics graphics){
		super.Render(graphics);
	}
	
	private LinkedList<GameObject> createLevel(){
		LinkedList<GameObject> levelItems = new LinkedList<GameObject>();
		
		Wall leftWall = new Wall();
		leftWall.setTag("leftwall");
		leftWall.getSize().setWidth(10);
		leftWall.getSize().setHeight(480);
		leftWall.getTransform().GetPosition().x = 0;
		leftWall.getTransform().GetPosition().y = 0;
		levelItems.add(leftWall);
		
		Wall rightWall = new Wall();
		rightWall.setTag("rightwall");
		rightWall.getSize().setWidth(10);
		rightWall.getSize().setHeight(480);
		rightWall.getTransform().GetPosition().x = 625;
		rightWall.getTransform().GetPosition().y = 0;
		levelItems.add(rightWall);
		
		return levelItems;
	}

	private void SpawnEnemys(){
		long currentTime = System.nanoTime();
		if(currentTime > this.nextEnemySpawn){
			this.nextEnemySpawn = currentTime + 1000000000;
			
			//Add Enemies
			Random ran = new Random();
			double xPos = ran.nextInt(600) + 20;
			Enemy_1 enemy = new Enemy_1();
			enemy.getTransform().GetPosition().x = xPos;
			this.addGameObject(enemy);
			
			System.out.println(this.getGameObjects().size());
		}
	}
	
	private void SpawnCollectables(){
		long currentTime = System.nanoTime();
		if(currentTime > this.nextCollectableSpawn){
			this.nextCollectableSpawn = currentTime + 1500000000;
			
			//Add Collectables
			Random ran = new Random();
			double xPos = ran.nextInt(600) + 20;
			Collectable_1 col = new Collectable_1();
			col.getTransform().GetPosition().x = xPos;
			this.addGameObject(col);			
		}
	}
}
