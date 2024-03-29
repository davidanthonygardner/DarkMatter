package com.chalcodes.weaponm.event;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EventSupport extends PropertyChangeSupport {
	private static final long serialVersionUID = 1L;

	public EventSupport() {
		super("");
	}

	public void addPropertyChangeListener(EventType type, PropertyChangeListener listener) {
		super.addPropertyChangeListener(type.name(), listener);
	}
	
	public void removePropertyChangeListener(EventType type, PropertyChangeListener listener) {
		super.removePropertyChangeListener(type.name(), listener);
	}
	
	public void fireEvent(Object source, EventType type, Object oldValue, Object newValue) {
		WeaponEvent event = new WeaponEvent(source, type, oldValue, newValue);
		super.firePropertyChange(event);
	}

}
