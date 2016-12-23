package com.bc.game.engine.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import com.bc.game.engine.GameObject;
import com.bc.game.engine.math.Rotation;
import com.bc.game.engine.math.Size;
import com.bc.game.engine.math.Vector2;

public class Renderer2D {
	
	private Graphics2D graphics;
	private GameObject gameObject;
	
	public void SetGraphics(Graphics graphics, GameObject gameObject){
		this.graphics = (Graphics2D)graphics;
		this.gameObject = gameObject;
	}
	
	public void DrawRectangle(Color color, Vector2 position, Size size, Rotation rotation){
		graphics.setColor(color);
		Rectangle2D rec = new Rectangle2D.Double
				(
						position.x, 
						position.y, 
						size.getWidth(), 
						size.getHeight()
						);
		AffineTransform trans = AffineTransform.getRotateInstance
				(
						rotation.getDegrees(), 
						rotation.getAnchorX(), 
						rotation.getAnchorY()
						);
		Shape ns = trans.createTransformedShape(rec);
		((Graphics2D)graphics).fill(ns);
	}
	
	public void DrawRectangle(Color color){
		this.DrawRectangle
		(
				color, 
				gameObject.getTransform().GetPosition(), 
				gameObject.getSize(), 
				gameObject.getTransform().GetRotation()
				);
	}
	
	public void drawEllipse(Color color, Vector2 position, Size size){
		graphics.setColor(color);
		Ellipse2D ellip = new Ellipse2D.Double(position.x, position.y, size.getWidth(), size.getHeight());
		graphics.fill(ellip);
	}
	
	public void drawEllipse(Color color){
		this.drawEllipse(color, gameObject.getTransform().GetPosition(), gameObject.getSize());
	}
	
	public void drawText(Color color, Font font, Vector2 position, String text){
		graphics.setColor(color);
		graphics.setFont(font);
		graphics.drawChars(text.toCharArray(), 0, text.toCharArray().length, (int)position.x, (int)position.y);
	}
	
	public void drawText(Color color, int fontSize, Vector2 position, String text){
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, fontSize);
		this.drawText(color, f, position, text);
	}
}
