package de.mgm.websocketdemo;


import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import de.mgm.websocketdemo.socket.ChatWebSocket;


public class WebSocketChatServlet extends WebSocketServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void configure(WebSocketServletFactory factory) {
		 factory.register(ChatWebSocket.class);

	}

}

