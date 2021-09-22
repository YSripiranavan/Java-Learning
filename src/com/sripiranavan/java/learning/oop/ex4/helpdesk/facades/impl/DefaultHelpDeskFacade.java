package com.sripiranavan.java.learning.oop.ex4.helpdesk.facades.impl;

import java.util.PriorityQueue;
import java.util.Queue;

import com.sripiranavan.java.learning.oop.ex4.helpdesk.entities.SupportTicket;
import com.sripiranavan.java.learning.oop.ex4.helpdesk.facades.HelpDeskFacade;
import com.sripiranavan.java.learning.oop.ex4.helpdesk.utils.CustomSupportTicketsComparator;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
	private Queue<SupportTicket> tickets;

	{
		tickets = new PriorityQueue<SupportTicket>(new CustomSupportTicketsComparator());
	}

	@Override
	public void addNewSupportTicker(SupportTicket supportTicket) {
		tickets.offer(supportTicket);
	}

	@Override
	public SupportTicket getNextSupportTicker() {
		return tickets.poll();
	}

	@Override
	public int getNumberOfTickets() {
		return tickets.size();
	}

}
