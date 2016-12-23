package com.bc.game.engine.listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import com.bc.game.engine.input.KeyInput;

public class WindowStateHook implements WindowFocusListener {

	@Override
	public void windowGainedFocus(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		KeyInput.clearActiveCommands();
	}

}
