package com.bc.game.engine.input;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.AbstractAction;

public class KeyInput extends AbstractAction{

	private static final long serialVersionUID = -3569677720070540558L;
	private static final LinkedList<String> activeCommands = new LinkedList<String>();
	
	private KeyEventType eventType;
	private String command;
	
	public KeyInput(KeyEventType eventType, String command){
		this.eventType = eventType;
		this.command = command;
	}
	
	public static boolean IsKeyCommandPressed(String command){
		return activeCommands.contains(command);
	}
	
	public static boolean IsKeyCommandTriggered(String command){
		boolean triggered = activeCommands.contains(command);
		if(triggered && activeCommands.contains(command)){
			activeCommands.remove(command);
		}
		return triggered;
	}
	
	public static void clearActiveCommands(){
		activeCommands.clear();
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(eventType == KeyEventType.PRESSED && !this.activeCommands.contains(command)){
			this.activeCommands.add(command);
		}
		else if(eventType == KeyEventType.RELEASED && this.activeCommands.contains(command)){
			this.activeCommands.remove(command);
		}
	}
}
