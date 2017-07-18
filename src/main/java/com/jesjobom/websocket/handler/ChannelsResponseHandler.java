package com.jesjobom.websocket.handler;

import com.jesjobom.websocket.stomp.SubscribableChannel;
import javax.swing.JComboBox;
import org.springframework.messaging.simp.stomp.StompHeaders;

/**
 * Custom handler to receive and register a new channel created in server side.
 * By extending {@link WebsocketResponseHandler} it gain access to the output text area.
 *
 * @author jesjobom
 */
public class ChannelsResponseHandler extends WebsocketResponseHandler {
	
	private final JComboBox channels;
	
	public ChannelsResponseHandler(WebsocketResponseHandler responseHandler, JComboBox channels) {
		super(responseHandler.outTextArea);
		this.channels = channels;
	}

	/**
	 * When a channel is created in the server, only the number is broadcasted.
	 * 
	 * @param headers
	 * @param payload 
	 */
	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		channels.addItem(new SubscribableChannel(payload.toString()));
		super.showMessage("RECV", null, "Channel " + payload.toString() + " created");
	}
	
	/**
	 * Since this handler has access to the combo box, wich holds the channels
	 * created, I'm also using it to clean all channels.
	 * Another option would be to give access to the combo box to whatever 
	 * component that need to remove the channels...
	 * Or to create a static utility clas...
	 */
	public void removeAllChannels() {
		//The first option is the default one
		while(channels.getItemCount() > 1) {
			channels.removeItemAt(1);
		}
	}
}
