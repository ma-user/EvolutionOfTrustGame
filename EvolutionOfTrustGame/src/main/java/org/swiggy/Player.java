package org.swiggy;

public abstract class Player {
    private int coins;

    public Player() {
        this.coins = 0;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public void displayCoins() {
        System.out.println("Player coins: " + coins);
    }

    public abstract Decision makeDecision();
}
