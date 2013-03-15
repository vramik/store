package org.jboss.gatein;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class WsOrderProcessor extends AbstractActionLifecycle {

	protected ConfigTree _config;

	public WsOrderProcessor(ConfigTree config) {
		_config = config;
	}

	public Message displayMessage(Message message) {
		String xmlBody = (String) message.getBody().get();
		System.out.println(xmlBody);
		return message;
	}

}
