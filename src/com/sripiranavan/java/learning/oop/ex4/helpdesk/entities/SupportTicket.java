package com.sripiranavan.java.learning.oop.ex4.helpdesk.entities;

public interface SupportTicket {
	Priority getPriority();

	int getSequentialNumber();

	RequestType getRequestType();
}
