package com.jesjobom.websocket.handler;

import com.jesjobom.websocket.stomp.SubscribableChannel;
import javax.swing.JComboBox;
import org.springframework.messaging.simp.stomp.StompHeaders;

/**
 * Custom handler to receive and register a new channel created in server side.
 *
 * @author jairton
 */
public class ChannelsResponseHandler extends WebsocketResponseHandler {
	
	private final JComboBox channels;
	
	public ChannelsResponseHandler(WebsocketResponseHandler responseHandler, JComboBox channels) {
		super(responseHandler.outTextArea);
		this.channels = channels;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		channels.addItem(new SubscribableChannel(payload.toString()));
		super.showMessage("RECV", null, "Channel " + payload.toString() + " created");
	}
	
	public void removeAllChannels() {
		while(channels.getItemCount() > 1) {
			channels.removeItemAt(1);
		}
	}
}
