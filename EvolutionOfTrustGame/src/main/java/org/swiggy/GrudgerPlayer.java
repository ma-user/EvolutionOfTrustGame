package org.swiggy;

public class GrudgerPlayer extends Player{
    private boolean retaliate = false;

    @Override
    public Decision makeDecision() {
        return (retaliate) ? Decision.CHEAT : Decision.COOPERATE;
    }

    @Override
    public void addCoins(int amount) {
        super.addCoins(amount);
        if (didOpponentCheat(amount)) {
            retaliate = true;
        }
    }

    private boolean didOpponentCheat(int amount) {
        return amount == -1;
    }
}
