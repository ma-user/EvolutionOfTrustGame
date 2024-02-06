package org.swiggy;

public class TrustTransaction {
    private final Player player1;
    private final Player player2;

    public TrustTransaction(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void processPlayerDecisions() {
        Decision decisionPlayer1 = player1.makeDecision();
        Decision decisionPlayer2 = player2.makeDecision();

        int[] results = transact(decisionPlayer1, decisionPlayer2);

        player1.addCoins(results[0]);
        player2.addCoins(results[1]);
    }

    private int[] transact(Decision decisionPlayer1, Decision decisionPlayer2) {
        return decisionPlayer1.getPayoff(decisionPlayer2);
    }
}
