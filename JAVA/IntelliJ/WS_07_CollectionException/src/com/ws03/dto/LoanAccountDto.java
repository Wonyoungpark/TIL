package com.ws03.dto;

public class LoanAccountDto extends AccountDto {
    private String mortgage;

    public LoanAccountDto(){}
    public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq,String mortgage) {
        super(accountSeq,accountNumber,balance,userSeq);
        this.mortgage=mortgage;
    }

    @Override
    public String toString() {
        return super.toString()+
                "LoanAccountDto{" +
                "mortgage='" + mortgage + '\'' +
                '}';
    }

    public String getMortgage() {
        return mortgage;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }
}
