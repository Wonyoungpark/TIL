package com.ws03.dto;

/**
 *  고객의 계좌정보 관리하는 객체
 * */
public class AccountDto implements Comparable<AccountDto> {
   public int accountSeq;
   public String accountNumber;
   public int balance;
   public int userSeq;
   
   public AccountDto() {}
   public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
	this.accountSeq = accountSeq;
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.userSeq = userSeq;
  }


    @Override
    public int compareTo(AccountDto o) {
       int bDiff = balance-o.balance;
        return (bDiff==0 ? (accountSeq-o.accountSeq) : bDiff);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountSeq=" + accountSeq +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", userSeq=" + userSeq +
                '}';
    }
}
