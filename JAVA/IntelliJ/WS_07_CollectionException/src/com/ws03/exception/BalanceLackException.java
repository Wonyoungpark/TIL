package com.ws03.exception;

public class BalanceLackException extends Exception{
    public BalanceLackException(){
        super("잔고가 없습니다.");
    }
    public BalanceLackException(String message) {
        super(message);
    }
}