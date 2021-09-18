package com.sripiranavan.java.learning.oop.ex1;

import java.util.Arrays;
import java.util.Objects;

public class Account {
	private static final int DEFAULT_TRANSACTION_AMOUNT = 10;

	private int id;
	private Transaction[] transactions;
	private int lastTransactionIndex;

	{
		transactions = new Transaction[DEFAULT_TRANSACTION_AMOUNT];
	}

	public Account(int id) {
		this.id = id;
	}

	public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
		if (accountTo == null) {
			return;
		}

		if (moneyAmount <= 0) {
			return;
		}

		Transaction transaction = new Transaction(this, accountTo, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_SEND);
		addTransaction(transaction);
		accountTo.recieveMoney(this, moneyAmount);
	}

	private void recieveMoney(Account account, double moneyAmount) {
		if (account == null) {
			return;
		}
		if (moneyAmount <= 0) {
			return;
		}
		Transaction transaction = new Transaction(account, this, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
		addTransaction(transaction);
	}

	private void addTransaction(Transaction transaction) {
		if (transaction == null) {
			return;
		}
		if (transactions.length <= lastTransactionIndex) {
			transactions = Arrays.copyOf(transactions, transactions.length << 1);
		}
		transactions[lastTransactionIndex] = transaction;
	}

	public void withdrawMoney(double moneyAmount) {
		Transaction transaction = new Transaction(this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
		addTransaction(transaction);
	}

	@Override
	public String toString() {
		return "Account ID: " + this.id;
	}

	public Transaction[] getTransactions() {
		return Arrays.stream(transactions).filter(Objects::nonNull).toArray(Transaction[]::new);
	}

	public static class Transaction {
		Account accountFrom;
		Account accountTo;
		double moneyAmount;
		StandardAccountOperations operations;

		public Transaction(Account accountFrom, Account accountTo, double moneyAmount,
				StandardAccountOperations operations) {
			super();
			this.accountFrom = accountFrom;
			this.accountTo = accountTo;
			this.moneyAmount = moneyAmount;
			this.operations = operations;
		}

		public Account getAccountFrom() {
			return accountFrom;
		}

		public void setAccountFrom(Account accountFrom) {
			this.accountFrom = accountFrom;
		}

		public Account getAccountTo() {
			return accountTo;
		}

		public void setAccountTo(Account accountTo) {
			this.accountTo = accountTo;
		}

		public double getMoneyAmount() {
			return moneyAmount;
		}

		public void setMoneyAmount(double moneyAmount) {
			this.moneyAmount = moneyAmount;
		}

		public StandardAccountOperations getOperations() {
			return operations;
		}

		public void setOperations(StandardAccountOperations operations) {
			this.operations = operations;
		}

		@Override
		public String toString() {
			return "Transaction [accountFrom=" + accountFrom + ", accountTo=" + accountTo + ", moneyAmount="
					+ moneyAmount + ", operations=" + operations + "]";
		}

	}
}
