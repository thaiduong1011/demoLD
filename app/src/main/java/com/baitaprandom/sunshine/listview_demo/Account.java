package com.baitaprandom.sunshine.listview_demo;

public class Account {
    String accountName;
    String passWord;
    String amount;

    public Account(String accountName, String passWord) {
        this.accountName = accountName;
        this.passWord = passWord;
        this.amount = "12.000.000";
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
