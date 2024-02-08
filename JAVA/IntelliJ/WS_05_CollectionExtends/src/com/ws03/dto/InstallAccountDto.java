package com.ws03.dto;

public class InstallAccountDto extends AccountDto {
    private int period;
    private int amount;

    @Override
    public String toString() {
        return super.getClass().getSimpleName() +
                super.toString()+
                "period=" + period +
                ", amount=" + amount +
                '}';
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public InstallAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int period, int amount) {
        super(accountSeq,accountNumber,balance,userSeq);
        this.period = period;
        this.amount = amount;
    }
}
