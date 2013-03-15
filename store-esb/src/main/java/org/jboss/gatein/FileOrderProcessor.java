package org.jboss.gatein;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class FileOrderProcessor extends AbstractActionLifecycle {

	protected ConfigTree _config;

	public FileOrderProcessor(ConfigTree config) {
		_config = config;
	}

	public Message displayMessage(Message message) {
		String xmlBody = (String) message.getBody().get();
		//Print the xmlBody to console!
		return message;
	}

}
