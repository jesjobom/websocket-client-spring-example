package com.jesjobom.websocket.handler;

import java.lang.reflect.Type;
import javax.swing.JTextArea;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.util.StringUtils;

/**
 * Handles websocket responses and decide how to present them to the user.
 * Also handles other messages.
 *
 * @author jesjobom
 */
public class WebsocketResponseHandler implements StompFrameHandler {

	protected final JTextArea outTextArea;

	public WebsocketResponseHandler(JTextArea outTextArea) {
		this.outTextArea = outTextArea;
	}
	
	@Override
	public Type getPayloadType(StompHeaders headers) {
		return String.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		String destination = headers.getDestination();
		String channel = destination.substring(destination.lastIndexOf("/") + 1);
		showMessage("RECV", channel, payload.toString());
	}
	
	public void handleError(Throwable ex) {
		ex.printStackTrace();
		handleError(ex.getMessage());
	}
	
	public void handleError(String msg) {
		StringBuilder builder = new StringBuilder();
		builder.append("ERROR ");
		builder.append(msg);
		builder.append("\n");
		
		this.outTextArea.append(builder.toString());
		this.outTextArea.setCaretPosition(this.outTextArea.getDocument().getLength());
	}
	
	public void handleSend(String msg) {
		showMessage("SEND", null, msg);
	}
	
	public void handleSend(String msg, String channel) {
		showMessage("SEND", channel, msg);
	}
	
	public void showMessage(String prefix, String channel, String message) {
		StringBuilder builder = new StringBuilder();
		builder.append(prefix).append(" [");
		if(StringUtils.hasText(channel)) {
			builder.append(channel.toUpperCase());
		} else {
			builder.append("GENERAL");
		}
		builder.append("] ");
		builder.append(message);
		builder.append("\n");
		
		this.outTextArea.append(builder.toString());
		this.outTextArea.setCaretPosition(this.outTextArea.getDocument().getLength());
	}
}
