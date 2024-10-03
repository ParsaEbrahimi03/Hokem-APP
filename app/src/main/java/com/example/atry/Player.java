package com.example.atry;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private boolean isHuman;
    private List<CardItem> hand;
    private List<CardItem> playedCards; // کارت‌های بازی شده توسط بازیکن

    public Player(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
        this.hand = new ArrayList<>();
        this.playedCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public List<CardItem> getHand() {
        return hand;
    }

    public void addCardToHand(CardItem card) {
        hand.add(card);
    }

    public void playCard(CardItem card) {
        hand.remove(card);
        playedCards.add(card); // کارت بازی شده را ذخیره کن
    }
    public List<CardItem> getPlayedCards() {
        return playedCards;
    }

    public void clearPlayedCards() {
        playedCards.clear();
    }
}
