package com.chalcodes.weaponm.event;

/**
 * Event type constants.
 * 
 * @see WeaponEvent
 *
 * @author <a href="mailto:kjkrum@gmail.com">Kevin Krumwiede</a>
 */
public enum EventType {
	// ******************** TEXT STUFF ********************
	
	/**
	 * The complete content of a network read.  Scripts cannot register for
	 * this event.  It is intended only for terminal and log output.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>null</td></tr>
	 * <tr><td>newValue</td><td>String</td></tr>
	 * </table>
	 */
	TEXT_RECEIVED,
	
	/**
	 * Text that was matched and consumed by the data parser.  Scripts can use
	 * this to detect minor events that are not recognized by the data parser.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>null</td></tr>
	 * <tr><td>newValue</td><td>String</td></tr>
	 * </table>
	 */
	TEXT_MATCHED,
	
	/**
	 * Text that was typed or pasted into the terminal.  Use this only for
	 * output that should <em>not</em> be retried if the network is locked.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>null</td></tr>
	 * <tr><td>newValue</td><td>String</td></tr>
	 * </table>
	 */
	TEXT_TYPED,
	
	// ******************** DATABASE STUFF ********************
	
	/**
	 * The database loaded status.  Scripts cannot register for this event,
	 * since script lifecycles are bounded by the database lifecycle.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>null</td></tr>
	 * <tr><td>newValue</td><td>Boolean</td></tr>
	 * </table>
	 */
	DATABASE_OPEN,
	
	/**
	 * Fired when the database is modified or saved.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>null</td></tr>
	 * <tr><td>newValue</td><td>Boolean</td></tr>
	 * </table>
	 */
	DATABASE_DIRTY,
	
	/**
	 * Fired when the database title is loaded or set.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>null</td></tr>
	 * <tr><td>newValue</td><td>String</td></tr>
	 * </table>
	 */
	DATABASE_TITLE,
	
	// ******************** NETWORK STUFF ********************
	
	/**
	 * The network connection status.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>{@link NetworkStatus}</td></tr>
	 * <tr><td>newValue</td><td>{@link NetworkStatus}</td></tr>
	 * </table>
	 */
	NETWORK_STATUS,

	/**
	 * Details of an error in the network thread.
	 * <p>
	 * <table border="1">
	 * <tr><td>source</td><td>null</td></tr>
	 * <tr><td>oldValue</td><td>null</td></tr>
	 * <tr><td>newValue</td><td>Throwable</td></tr>
	 * </table>
	 */
	NETWORK_ERROR

}
