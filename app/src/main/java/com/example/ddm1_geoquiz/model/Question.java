package com.example.ddm1_geoquiz.model;

public class Question {
    private int sTextId;
    private boolean response;

    public Question(int sTextId, boolean response) {
        this.sTextId = sTextId;
        this.response = response;
    }

    public int getsTextId() {
        return sTextId;
    }

    public boolean getResponse() {
        return response;
    }
}
