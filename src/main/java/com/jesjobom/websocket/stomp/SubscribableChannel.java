package com.jesjobom.websocket.stomp;

import java.util.Objects;
import org.springframework.messaging.simp.stomp.StompSession;

/**
 * Represents a channel with its subscription if any.
 *
 * @author jairton
 */
public class SubscribableChannel {
	
	private final String channel;
	
	private StompSession.Subscription subscription;

	public SubscribableChannel(String channel) {
		this.channel = channel;
	}

	public String getChannel() {
		return channel;
	}

	public StompSession.Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(StompSession.Subscription subscription) {
		this.subscription = subscription;
	}
	
	public String getSubscriptionUri() {
		return "/subscribe/channel/" + channel;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.channel);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SubscribableChannel other = (SubscribableChannel) obj;
		if (!Objects.equals(this.channel, other.channel)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Channel " + channel.toUpperCase();
	}
}
