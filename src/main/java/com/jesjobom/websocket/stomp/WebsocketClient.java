package com.jesjobom.websocket.stomp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesjobom.websocket.handler.CustomStompSessionHandler;
import com.jesjobom.websocket.handler.ChannelsResponseHandler;
import com.jesjobom.websocket.handler.WebsocketResponseHandler;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.util.MimeType;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

/**
 * Component to connect to the server via Websocket SockJS Stomp.
 * SockJS will provide a fallback using a different strategy over HTTP if
 * websocket doesn't work.
 *
 * @author jesjobom
 */
public class WebsocketClient {

	private final String url;

	private final WebsocketResponseHandler responseHandler;
	
	private final ChannelsResponseHandler channelsHandler;
	
	private WebSocketStompClient client;
	
	private StompSession session;

	/**
	 * Constructor to configure the URL with the endpoint expected.
	 * Also, some interface components are informed to allow some interactions
	 * (websocket response) -> (user)
	 * 
	 * @param url
	 * @param output
	 * @param channels 
	 */
	public WebsocketClient(String url, JTextArea output, JComboBox channels) {
		this.url = url + (url.endsWith("/") ? "" : "/") + "chat";
		this.responseHandler = new WebsocketResponseHandler(output);
		channelsHandler = new ChannelsResponseHandler(responseHandler, channels);
	}

	public void connect(SuccessCallback<WebsocketClient> successCallback) {
		ListenableFuture<StompSession> connectionStatus = connect();

		connectionStatus.addCallback(
			localSession -> {
				subscribeInitialChannels(localSession);
				successCallback.onSuccess(this);
			},
			ex -> {
				responseHandler.handleError(ex);
			}
		);
	}

	private ListenableFuture<StompSession> connect() {
		List<Transport> transports = new ArrayList<>(2);
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
		transports.add(new RestTemplateXhrTransport());

		SockJsClient sockJsClient = new SockJsClient(transports);

		client = new WebSocketStompClient(sockJsClient);
		client.setMessageConverter(new MappingJackson2MessageConverter(new MimeType("application", "json", Charset.forName("UTF-8")), new MimeType("text", "plain", Charset.forName("UTF-8"))));

		StompSessionHandlerAdapter sessionHandler = new CustomStompSessionHandler(responseHandler);
		return client.connect(url, sessionHandler);
	}
	
	public void disconnect() {
		client.stop();
		session.disconnect();
		channelsHandler.removeAllChannels();
	}
	
	private void subscribeInitialChannels(StompSession session) {
		session.subscribe("/subscribe/hello", responseHandler);
		session.subscribe("/subscribe/channel/general", responseHandler);
		session.subscribe("/subscribe/channels", channelsHandler);
		session.subscribe("/user/subscribe/private", responseHandler);
		this.session = session;
	}
	
	public void sendHello() {
		send("/client/hello", "Hello!");
	}
	
	public void sendChannel(SubscribableChannel channel, String message) {
		String ch = channel == null ? "general" : channel.getChannel();
		send("/client/channel/" + ch, message);
	}
	
	private void send(String destination, String message) {
		responseHandler.handleSend(message);
		try {
			session.send(destination, new ObjectMapper().writeValueAsString(message));
		} catch (JsonProcessingException ex) {
			responseHandler.handleError(ex);
		}
	}

	public void createChannel() {
		session.send("/client/channel/create", null);
	}
	
	public void subscribeChannel(SubscribableChannel channel) {
		StompSession.Subscription sub = session.subscribe(channel.getSubscriptionUri(), responseHandler);
		channel.setSubscription(sub);
	}

	public void unsubscribeChannel(SubscribableChannel channel) {
		StompSession.Subscription subscription = channel.getSubscription();
		subscription.unsubscribe();
		channel.setSubscription(null);
	}
}
