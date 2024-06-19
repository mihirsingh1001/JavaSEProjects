package com.info.service;

import com.info.model.Account;

public class AccountHolder implements Runnable {
	private Account account;

	public AccountHolder(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}

	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			makeWithdraw(2000);
			if (account.getBalance() < 0) {
				System.out.println("Account is overdrawn");
			}
		}
	}

	
	private synchronized void makeWithdraw(int withdrawAmount) {
		if (account.getBalance() >= withdrawAmount) {
			System.out.println(Thread.currentThread().getName() + " is going to withdrawal " + withdrawAmount + " ruppes");
			{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			account.withdraw(withdrawAmount);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal of " + withdrawAmount + " ruppes");
		} else {
			System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdrawal " + account.getBalance());
		}
	}

}
