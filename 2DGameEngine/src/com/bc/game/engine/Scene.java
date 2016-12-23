package com.bc.game.engine;

import java.awt.Graphics;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

import com.bc.game.engine.graphics.Renderer2D;

public abstract class Scene {
	
	private LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
	private String tag;
	private SceneState sceneState = SceneState.Normal;
	private BCEngine engine;
	
	public Scene(String _tag){
		tag = _tag;
	}
	
	protected void addGameObject(GameObject gameObject){
		gameObjects.add(gameObject);
	}
	
	protected void addGameObjects(Collection<GameObject> gameObjects){
		gameObjects.addAll(gameObjects);
	}
	
	public LinkedList<GameObject> getGameObjects(){
		return gameObjects;
	}
	
	public LinkedList<GameObject> getGameObjects(String tag){
		return gameObjects.stream().filter(t -> t.getTag() == tag)
				.collect(Collectors.toCollection(LinkedList::new));
	}
	
	public String GetSceneTag(){
		return tag;
	}
	
	public SceneState getSceneState(){
		return this.sceneState;
	}
	
	public void setSceneState(SceneState sceneState){
		this.sceneState = sceneState;
	}
	
	public void setEngine(BCEngine engine){
		this.engine = engine;
	}
	
	public BCEngine getEngine(){
		return this.engine;
	}
	
	public void tick(){
		for(int i = 0; i < gameObjects.size(); i++){
			GameObject g = gameObjects.get(i);
			g.SetScene(this);
			g.tick();
			g.monitorIntersections(gameObjects);									
		}
	}
	
	public void Render(Graphics graphics){
		for(int i = 0; i < gameObjects.size(); i++){
			GameObject g = gameObjects.get(i);
			if(!g.isRendererSet()){
				g.setRenderer(new Renderer2D());
			}
			g.getRenderer().SetGraphics(graphics, g);
			g.SetScene(this);
			g.render();
		}
	}
}
