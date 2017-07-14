package com.jesjobom.websocket;

import java.util.ArrayList;
import java.util.List;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

/**
 *
 * @author jairton
 */
public class WebsocketClient {

	private final String url;

	private final WebsocketResponseHandler responseHandler;
	
	private StompSession session;

	public WebsocketClient(String url, WebsocketResponseHandler responseHandler) {
		this.url = url + (url.endsWith("/") ? "" : "/") + "chat";
		this.responseHandler = responseHandler;
	}

	public void connect(SuccessCallback<WebsocketClient> successCallback) {
		ListenableFuture<StompSession> connectionStatus = connect();

		connectionStatus.addCallback(
			s -> {
				subscribeInitialChannels(s);
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

		WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
		stompClient.setMessageConverter(new StringMessageConverter());

		StompSessionHandlerAdapter sessionHandler = new CustomStompSessionHandler(responseHandler);
		return stompClient.connect(url, sessionHandler);
	}

	private void subscribeInitialChannels(StompSession session) {
		session.subscribe("/subscribe/hello", responseHandler);
		session.subscribe("/subscribe/channel/general", responseHandler);
		session.subscribe("/subscribe/channels", responseHandler);
		session.subscribe("/user/subscribe/private", responseHandler);
		this.session = session;
	}
	
	public StompSession.Subscription subscribe(String uri) {
		return session.subscribe(uri, responseHandler);
	}
}
