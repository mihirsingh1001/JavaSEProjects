package com.info.client;

import com.info.model.Account;
import com.info.service.AccountHolder;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account  = new Account();
		AccountHolder accountHolder = new AccountHolder(account);
		
		Thread thread1 = new Thread(accountHolder);
		Thread thread2 = new Thread(accountHolder);
		
		thread1.setName("Sam");
		thread2.setName("Joya");
		
		thread1.start();
		thread2.start();
	}

}
