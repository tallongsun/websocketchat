package de.mgm.websocketdemo.socket;


import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;



/**
 * The "onTextMessage" Socket , there is also ControllMessage and BinaryMessage 
 * 
 * @author cbelka
 *
 */
public class ChatWebSocket implements WebSocketListener {
	
	private Session  connection;
	
	private static Set<ChatWebSocket> users = new CopyOnWriteArraySet<ChatWebSocket>();


	public void onWebSocketClose(int closeCode, String message) {
		users.remove(this);
	}

	public void onWebSocketConnect(Session connection) {
		this.connection = connection;
		users.add(this);
		
	}


	public void onWebSocketText(String data) {
		for (ChatWebSocket user : users) {
			try {
				user.connection.getRemote().sendString(data);
			} catch (Exception e) {
			}
		}
	}

	public void onWebSocketBinary(byte[] arg0, int arg1, int arg2) {
		
	}

	public void onWebSocketError(Throwable arg0) {
		
	}

}
