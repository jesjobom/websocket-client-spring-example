package com.jesjobom.websocket;

import java.lang.reflect.Type;
import javax.swing.JTextArea;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

/**
 * Handles websocket responses and decide how to present them to the user.
 *
 * @author jairton
 */
public class WebsocketResponseHandler implements StompFrameHandler {

	private final JTextArea outTextArea;

	public WebsocketResponseHandler(JTextArea outTextArea) {
		this.outTextArea = outTextArea;
	}
	
	@Override
	public Type getPayloadType(StompHeaders headers) {
		return String.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		StringBuilder builder = new StringBuilder();
		builder.append("RECV ");
		builder.append(payload);
		builder.append("\n");
		
		this.outTextArea.append(builder.toString());
	}
	
	public void handleError(Throwable ex) {
		ex.printStackTrace();
		handleError(ex.getMessage());
	}
	
	public void handleError(String msg) {
		StringBuilder builder = new StringBuilder();
		builder.append("ERRO ");
		builder.append(msg);
		builder.append("\n");
		
		this.outTextArea.append(builder.toString());
	}
}
