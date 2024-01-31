package com.ws03.dto;

/**
 *  고객의 계좌정보 관리하는 객체
 * */
public class AccountDto {
	public int accountSeq;
	public String accountNumber;
	public int balance;
	public int userSeq;

  	public AccountDto(int accountSeq, String accountNumber,int balance,int userSeq) {
  		this.userSeq=userSeq;
  		this.accountSeq=accountSeq;
  		this.accountNumber=accountNumber;
  		this.balance=balance;
	  }

	public int getAccountSeq() {
		return accountSeq;
	}

	public void setAccountSeq(int accountSeq) {
		this.accountSeq = accountSeq;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
  	
}
