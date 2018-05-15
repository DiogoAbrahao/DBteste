package com.controller.db.dbteste.Objects;

public class Transaction {

    private long id;
    private float value;
    private String description;
    private String date;
    private String transactionType;

    public float getValue() {return value;}
    public void setValue(float value) {this.value = value;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getTransactionType() {return transactionType;}
    public void setTransactionType(String transactionType) {this.transactionType = transactionType;}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
}
