package org.swiggy;

public class CopyKittenPlayer extends Player{
    private boolean willCheat = false;

    @Override
    public Decision makeDecision() {
        return (willCheat) ? Decision.CHEAT : Decision.COOPERATE;
    }

    @Override
    public void addCoins(int amount) {
        super.addCoins(amount);
        this.willCheat = didOpponentCheat(amount);
    }

    private boolean didOpponentCheat(int amount) {
        return amount == -1 || amount == 0;
    }
}
