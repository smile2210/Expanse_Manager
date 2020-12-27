package com.example.expansetracker_moneymanagerbudget;

public class Model {
    int amount;
    String note;
    String abc;

    public Model() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public Model(int amount, String note, String abc) {
        this.amount = amount;
        this.note = note;
        this.abc = abc;
    }
}
