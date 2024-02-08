package com.ws03.exception;

public class UserAccountNotFoundException extends Exception{
    public UserAccountNotFoundException(){
        super("사용자의 정보를 찾을 수 없습니다.");
    }
    public UserAccountNotFoundException(String message) {
        super(message);
    }
}