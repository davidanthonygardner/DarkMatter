package com.chalcodes.weaponm.gui.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.chalcodes.weaponm.gui.Gui;

class ExitAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	private final Gui gui;
	
	ExitAction(Gui gui) {
		this.gui = gui;
		ActionManager.setText(this, "ACTION_EXIT");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gui.interactiveShutdown();		
	}

}