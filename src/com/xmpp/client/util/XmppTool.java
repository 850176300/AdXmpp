package com.xmpp.client.util;

import java.util.Collection;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

/**
 * @author Sam.Io
 * @time 2011/11/18
 * @project AdXmpp
 */
public class XmppTool {

	private static XMPPConnection con = null;
	
	private static void openConnection() {
		try {
			ConnectionConfiguration connConfig = new ConnectionConfiguration("talk.google.com",5222,"gmail.com");
			connConfig.setSASLAuthenticationEnabled(true);
			connConfig.setSecurityMode(ConnectionConfiguration.SecurityMode.enabled);
			con = new XMPPConnection(connConfig);
			con.connect();


		} catch (XMPPException xe) {
			xe.printStackTrace();
		}
	}

	public static XMPPConnection getConnection() {
		if (con == null) {
			openConnection();
		}
		return con;
	}

	public static void closeConnection() {
		con.disconnect();
		con = null;
	}
}
