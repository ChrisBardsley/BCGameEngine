package com.bc.game.engine;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

import com.bc.game.engine.graphics.Renderer2D;
import com.bc.game.engine.math.Size;
import com.bc.game.engine.math.Transform;
import com.bc.game.engine.math.Vector2;

public abstract class GameObject {
	
	private Scene scene;
	private Transform transform;
	private Size size;
	private String tag;
	private Renderer2D renderer;
	private boolean destroyed = false;
	
	public GameObject(Transform transform, Size size, String tag){
		this.transform = transform;
		this.size = size;
		this.tag = tag;
	}
	
	public GameObject(Transform transform, String tag){
		this(transform, new Size(50d, 50d), tag);
	}
	
	public GameObject(Vector2 position, Size size, String tag){
		this(new Transform(position), size, tag);
	}
	
	public GameObject(Vector2 position, String tag){
		this(new Transform(position), tag);
	}
	
	public GameObject(String _tag){
		this(new Transform(), _tag);
	}
	
	public abstract void tick();
	public abstract void render();
	public abstract void onCollision(GameObject entity);
	
	public void SetScene(Scene scene){
		this.scene = scene;
	}
	
	public boolean isRendererSet(){
		return this.renderer != null;
	}
	
	public void setRenderer(Renderer2D renderer){
		this.renderer = renderer;
	}
	
	public void monitorIntersections(LinkedList<GameObject> objects){
		Rectangle2D thisRec = new Rectangle();
		thisRec.setRect(this.transform.GetPosition().x, this.transform.GetPosition().y, this.size.getWidth(), this.size.getHeight());
		
		for(GameObject go: objects.toArray(new GameObject[objects.size()])){
			if(go != this && !go.destroyed){
				Rectangle2D otherRec = new Rectangle();
				otherRec.setRect(go.getTransform().GetPosition().x, go.getTransform().GetPosition().y, go.getSize().getWidth(), go.getSize().getHeight());
				if(thisRec.intersects(otherRec)){
					this.onCollision(go);					
				}
			}
		}
	}
	
	public Transform getTransform(){
		return this.transform;
	}
	
	public Size getSize(){
		return this.size;
	}
	
	protected Renderer2D getRenderer(){
		return this.renderer;
	}
	
	protected Scene GetScene(){
		return this.scene;
	}
	
	protected void LoadScene(Scene scene){
		this.GetScene().getEngine().UpdateScene(scene);
	}
	
	public String getTag(){
		return this.tag;
	}
	
	public void setTag(String tag){
		this.tag = tag;
	}
	
	public void Destroy(){
		if(this.scene.getGameObjects().contains(this)){
			this.scene.getGameObjects().remove(this);
			this.destroyed = true;
		}
	}
}
