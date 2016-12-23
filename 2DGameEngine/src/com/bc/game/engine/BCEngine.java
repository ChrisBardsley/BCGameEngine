package com.bc.game.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.bc.game.engine.input.KeyBindings;
import com.bc.game.engine.listeners.WindowStateHook;

public class BCEngine extends Canvas implements Runnable {

	private static final long serialVersionUID = 4137130684553411861L;
	private JFrame _frame;
	private Dimension _windowDimensions;
	private Thread _thread = null;
	private Scene _currentScene = null;
	
	private double _fps = 60;
	
	private boolean _initialized = false;
	private boolean _running = false;

	public BCEngine(int windowWidth, int windowHeight, String windowTitle, Scene scene){		
		_windowDimensions = new Dimension(windowWidth, windowHeight);
		_frame = new JFrame(windowTitle);
		//_frame.addKeyListener(new KeyInput());
		_frame.addWindowFocusListener(new WindowStateHook());
		_frame.setPreferredSize(_windowDimensions);
		_frame.setMaximumSize(_windowDimensions);
		_frame.setMinimumSize(_windowDimensions);
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setResizable(false);
		_frame.setLocationRelativeTo(null);
		_frame.setVisible(true);
		_frame.setFocusable(true);
		
		new KeyBindings(_frame.getRootPane());
		
		_currentScene = scene;
		_currentScene.setEngine(this);
	}
	
	public BCEngine(String windowTitle, Scene scene){
		this(640, 480, windowTitle, scene);
	}
	
	public BCEngine(Scene scene){
		this("Window Title", scene);
	}
	
	public JFrame getWindow(){
		return _frame;
	}
	
	public void UpdateScene(Scene scene){
		this._currentScene = scene;
		_currentScene.setEngine(this);
	}
	
	public boolean isRunning(){
		return _running;
	}
	
	public boolean isInitialized(){
		return _initialized;
	}
	
	public void init(){
		if(!_initialized){
			_frame.add(this);
		}
	}
	
	public synchronized void startGame(){
		if(!_running && _thread == null){
			_thread = new Thread(this);
			_thread.start();
			_running = true;
		}
	}
	
	public synchronized void stopGame(){
		try{
			if(_running && _thread != null){
				_thread.join();
				_running = false;
				_thread = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = _fps;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while(_running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
		    lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(_running){
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stopGame();
	}
	
	private void tick()
	{
		_currentScene.tick();
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, _frame.getWidth(), _frame.getHeight());
		
		_currentScene.Render(g);
		
		g.dispose();
		bs.show();
	}
}
