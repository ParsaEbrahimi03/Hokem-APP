package com.example.atry;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private Player hakim; // حاکم دور
    private String hokm; // حکم تعیین شده
    private List<CardItem> cardsPlayed; // کارت‌های بازی شده در این دور

    public Round(Player hakim, String hokm) {
        this.hakim = hakim;
        this.hokm = hokm;
        this.cardsPlayed = new ArrayList<>();
    }

    public Player getHakim() {
        return hakim;
    }

    public String getHokm() {
        return hokm;
    }

    public List<CardItem> getCardsPlayed() {
        return cardsPlayed;
    }

    public void addCardPlayed(CardItem card) {
        cardsPlayed.add(card);
    }
}
