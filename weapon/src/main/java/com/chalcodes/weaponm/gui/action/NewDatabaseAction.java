package com.chalcodes.weaponm.gui.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.chalcodes.weaponm.database.Database;
import com.chalcodes.weaponm.database.DatabaseManager;
import com.chalcodes.weaponm.database.LoginOptions;
import com.chalcodes.weaponm.gui.Gui;
import com.chalcodes.weaponm.gui.LoginOptionsDialog;
import com.chalcodes.weaponm.gui.Strings;

public class NewDatabaseAction extends AbstractDatabaseAction {
	private static final long serialVersionUID = 1L;

	public NewDatabaseAction(Gui gui, DatabaseManager dbm) {
		super(gui, dbm);
		ActionManager.setText(this, "NEW_ACTION");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(interactiveClose()) {
			LoginOptions tempOptions = new LoginOptions();
			if(gui.showLoginOptionsDialog(tempOptions) == LoginOptionsDialog.OK_ACTION) {
				File file = gui.showDatabaseSaveDialog();
				if(file != null) {
					String filename = file.getPath();
					if(!filename.endsWith(".wmd")) {
						file = new File(filename + ".wmd");
					}
					if(interactiveClobber(file)) {
						try {
							Database db = dbm.create(file);
							LoginOptions dbOptions = db.getLoginOptions();
							dbOptions.setTitle(tempOptions.getTitle());
							dbOptions.setHost(tempOptions.getHost());
							dbOptions.setPort(tempOptions.getPort());
							dbOptions.setGame(tempOptions.getGame());
							dbOptions.setName(tempOptions.getName());
							dbOptions.setPassword(tempOptions.getPassword());
							dbOptions.setAutoLogin(tempOptions.isAutoLogin());
							dbm.save();
							// TODO fire events
						}
						catch(IOException ex) {
							log.error("error creating database", ex);
							gui.showMessageDialog(ex.getMessage(), Strings.getString("TITLE_DATABASE_ERROR"), JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
	}
}