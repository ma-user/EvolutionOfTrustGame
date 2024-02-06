package org.swiggy;

public class CopyCatPlayer extends Player {

    private boolean willCooperate = false;

    @Override
    public Decision makeDecision() {
        return (willCooperate) ? Decision.COOPERATE : Decision.CHEAT;
    }

    @Override
    public void addCoins(int amount) {
        super.addCoins(amount);
        this.willCooperate = didOpponentCooperate(amount);
    }

    private boolean didOpponentCooperate(int amount) {
        return amount == 3 || amount == 2;
    }
}
