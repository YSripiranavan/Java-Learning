package com.sripiranavan.java.learning.multithread.executors.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class DefaultRecursiveAction extends RecursiveAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int workload = 0;

	public DefaultRecursiveAction(int workload) {
		this.workload = workload;
	}

	@Override
	protected void compute() {
		if (this.workload < 18) {
			System.out.println("Doing workLoad myself in thread " + Thread.currentThread().getName()
					+ " with workload: " + this.workload);
		} else {
			System.out.println("Splitting workLoad in thread " + Thread.currentThread().getName() + " with workload: "
					+ this.workload);
//			List<DefaultRecursiveAction> subtasks = new ArrayList<DefaultRecursiveAction>(createSubtasks());
//			for (RecursiveAction subtask : subtasks) {
//				subtask.fork();
//			}
			// Alternatively
			ForkJoinTask.invokeAll(createSubtasks());
		}
	}

	private List<DefaultRecursiveAction> createSubtasks() {
		List<DefaultRecursiveAction> subtasks = new ArrayList<DefaultRecursiveAction>();

		DefaultRecursiveAction subtask1 = new DefaultRecursiveAction(this.workload / 2);
		DefaultRecursiveAction subtask2 = new DefaultRecursiveAction(this.workload / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}

}
