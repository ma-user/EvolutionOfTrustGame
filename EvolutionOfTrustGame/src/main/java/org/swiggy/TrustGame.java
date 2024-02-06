package org.swiggy;

public class TrustGame {

    private final Player player1;
    private final Player player2;
    private final int totalRounds;

    public TrustGame(Player player1, Player player2, int totalRounds) {
        if(player1 == null || player2 == null) {
            throw new RuntimeException("Player can't be null");
        }
        this.player1 = player1;
        this.player2 = player2;
        this.totalRounds = totalRounds;
    }

    public void play() {
        TrustTransaction trustTransaction = new TrustTransaction(player1, player2);

        for (int round = 1; round <= totalRounds; round++) {
            trustTransaction.processPlayerDecisions();

            System.out.println("Round " + round);
            player1.displayCoins();
            player2.displayCoins();
        }
    }
}
