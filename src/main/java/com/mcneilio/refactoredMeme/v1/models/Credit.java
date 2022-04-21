package com.mcneilio.refactoredMeme.v1.models;

import java.util.ArrayList;
import java.util.Date;

public class Credit {
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPremium() {
        return premium;
    }

    public void setPremium(float premium) {
        this.premium = premium;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public static ArrayList<Credit> getCredits() {
        return credits;
    }

    public void save() {
        credits.add(this);
    }

    String action, status;
    Date date;
    float premium;
    int shares;
    static ArrayList<Credit> credits = new ArrayList<>();
}
