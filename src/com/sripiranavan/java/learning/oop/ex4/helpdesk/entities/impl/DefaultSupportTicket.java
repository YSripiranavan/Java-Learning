package com.sripiranavan.java.learning.oop.ex4.helpdesk.entities.impl;

import com.sripiranavan.java.learning.oop.ex4.helpdesk.entities.Priority;
import com.sripiranavan.java.learning.oop.ex4.helpdesk.entities.RequestType;
import com.sripiranavan.java.learning.oop.ex4.helpdesk.entities.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {
	private static int counter;

	private RequestType requestType;
	private int sequentialNumber;

	{
		sequentialNumber = ++counter;
	}

	public DefaultSupportTicket() {
	}

	public DefaultSupportTicket(RequestType requestType) {
		this.requestType = requestType;
	}

	@Override
	public Priority getPriority() {
		if (requestType == null) {
			return null;
		}
		return this.requestType.getPriority();
	}

	@Override
	public int getSequentialNumber() {
		return this.sequentialNumber;
	}

	@Override
	public RequestType getRequestType() {
		return this.requestType;
	}

}
