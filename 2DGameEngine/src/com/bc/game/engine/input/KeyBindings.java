package com.bc.game.engine.input;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class KeyBindings {

	private Map<String, int[]> keyTriggers = new HashMap<String, int[]>(); 
	
	public KeyBindings(JRootPane rootPane){
		keyTriggers.put("MOVE_UP", new int[]{ KeyEvent.VK_W, KeyEvent.VK_UP });
		keyTriggers.put("MOVE_LEFT", new int[]{ KeyEvent.VK_A, KeyEvent.VK_LEFT });
		keyTriggers.put("MOVE_RIGHT", new int[]{ KeyEvent.VK_D, KeyEvent.VK_RIGHT });
		keyTriggers.put("MOVE_DOWN", new int[]{ KeyEvent.VK_S, KeyEvent.VK_DOWN });
		keyTriggers.put("FIRE", new int[]{ KeyEvent.VK_SPACE });
		
		this.setInputMaps(rootPane);
		this.SetActionMaps(rootPane);		
	}
	
	private void setInputMaps(JRootPane rootPane){
		for(Map.Entry<String, int[]> entry : keyTriggers.entrySet()){
			for(int key : entry.getValue()){
				rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0), String.format("%s_%s", entry.getKey(), KeyEventType.PRESSED.toString()));
				rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0, true), String.format("%s_%s", entry.getKey(), KeyEventType.RELEASED.toString()));
			}
		}
	}
	
	private void SetActionMaps(JRootPane rootPane){
		for(Map.Entry<String, int[]> entry : keyTriggers.entrySet()){
			rootPane.getActionMap().put(String.format("%s_%s", entry.getKey(), KeyEventType.PRESSED.toString()), new KeyInput(KeyEventType.PRESSED, entry.getKey()));
			rootPane.getActionMap().put(String.format("%s_%s", entry.getKey(), KeyEventType.RELEASED.toString()), new KeyInput(KeyEventType.RELEASED, entry.getKey()));
		}
	}
	
}
