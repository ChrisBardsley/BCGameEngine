package com.tutorial.main;

import com.bc.game.engine.BCEngine;
import com.tutorial.scenes.Level1;;

public class Main {

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;	
	public static BCEngine engine;	
	
	public static void main(String args[])
	{
		engine = new BCEngine(new Level1());
		engine.init();
		engine.startGame();
	}	
}
