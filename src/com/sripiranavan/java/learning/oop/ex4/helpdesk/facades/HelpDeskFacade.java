package com.sripiranavan.java.learning.oop.ex4.helpdesk.facades;

import com.sripiranavan.java.learning.oop.ex4.helpdesk.entities.SupportTicket;

public interface HelpDeskFacade {
	void addNewSupportTicker(SupportTicket supportTicket);
	
	SupportTicket getNextSupportTicker();
	
	int getNumberOfTickets();
}
