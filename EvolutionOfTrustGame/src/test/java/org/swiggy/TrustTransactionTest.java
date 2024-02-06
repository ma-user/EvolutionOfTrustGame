package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrustTransactionTest {

    @Test
    void testProcessGameDecisionsCooperateVsCheat() {
        Player alwaysCooperatePlayer = new AlwaysCooperatePlayer();
        Player alwaysCheatPlayer = new AlwaysCheatPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(-1, alwaysCooperatePlayer.getCoins());
        assertEquals(3, alwaysCheatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCooperateVsCooperate() {
        Player alwaysCooperatePlayer1 = new AlwaysCooperatePlayer();
        Player alwaysCooperatePlayer2 = new AlwaysCooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer1, alwaysCooperatePlayer2);

        transaction.processPlayerDecisions();

        assertEquals(2, alwaysCooperatePlayer1.getCoins());
        assertEquals(2, alwaysCooperatePlayer2.getCoins());
    }

    @Test
    void testProcessGameDecisionsCooperateVsCopyCat() {
        Player alwaysCooperatePlayer = new AlwaysCooperatePlayer();
        Player copyCatPlayer = new CopyCatPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, copyCatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(-1, alwaysCooperatePlayer.getCoins());
        assertEquals(3, copyCatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCooperateVsCopyKitten() {
        Player alwaysCooperatePlayer = new AlwaysCooperatePlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();

        assertEquals(2, alwaysCooperatePlayer.getCoins());
        assertEquals(2, copyKittenPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCooperateVsGrudger() {
        Player alwaysCooperatePlayer = new AlwaysCooperatePlayer();
        Player grudgerPlayer = new GrudgerPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, grudgerPlayer);

        transaction.processPlayerDecisions();

        assertEquals(2, alwaysCooperatePlayer.getCoins());
        assertEquals(2, grudgerPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCheatVsCheat() {
        Player alwaysCheatPlayer1 = new AlwaysCheatPlayer();
        Player alwaysCheatPlayer2 = new AlwaysCheatPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer1, alwaysCheatPlayer2);

        transaction.processPlayerDecisions();

        assertEquals(0, alwaysCheatPlayer1.getCoins());
        assertEquals(0, alwaysCheatPlayer2.getCoins());
    }

    @Test
    void testProcessGameDecisionsCheatVsCooperate() {
        Player player1 = new AlwaysCheatPlayer();
        Player player2 = new AlwaysCooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.processPlayerDecisions();

        assertEquals(3, player1.getCoins());
        assertEquals(-1, player2.getCoins());
    }

    @Test
    void testProcessGameDecisionsCheatVsCopyCat() {
        Player alwaysCheatPlayer = new AlwaysCheatPlayer();
        Player copyCatPlayer = new CopyCatPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, copyCatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(0, alwaysCheatPlayer.getCoins());
        assertEquals(0, copyCatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCheatVsCopyKitten() {
        Player alwaysCheatPlayer = new AlwaysCheatPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();

        assertEquals(3, alwaysCheatPlayer.getCoins());
        assertEquals(-1, copyKittenPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCheatVsGrudger() {
        Player alwaysCheatPlayer = new AlwaysCheatPlayer();
        Player grudgerPlayer = new GrudgerPlayer();
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, grudgerPlayer);

        transaction.processPlayerDecisions();

        assertEquals(3, alwaysCheatPlayer.getCoins());
        assertEquals(-1, grudgerPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCheat() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player alwaysCheatPlayer = new AlwaysCheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(0, copyCatPlayer.getCoins());
        assertEquals(0, alwaysCheatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCooperate() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player alwaysCooperatePlayer = new AlwaysCooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();

        assertEquals(3, copyCatPlayer.getCoins());
        assertEquals(-1, alwaysCooperatePlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCopyCat() {
        Player copyCatPlayer1 = new CopyCatPlayer();
        Player copyCatPlayer2 = new CopyCatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer1, copyCatPlayer2);

        transaction.processPlayerDecisions();

        assertEquals(0, copyCatPlayer1.getCoins());
        assertEquals(0, copyCatPlayer2.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCopyKitten() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();

        assertEquals(3, copyCatPlayer.getCoins());
        assertEquals(-1, copyKittenPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyCatVsGrudger() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player grudgerPlayer = new GrudgerPlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, grudgerPlayer);

        transaction.processPlayerDecisions();

        assertEquals(3, copyCatPlayer.getCoins());
        assertEquals(-1, grudgerPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCheat() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player alwaysCheatPlayer = new AlwaysCheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(-1, copyKittenPlayer.getCoins());
        assertEquals(3, alwaysCheatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCooperate() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player alwaysCooperatePlayer = new AlwaysCooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();

        assertEquals(2, copyKittenPlayer.getCoins());
        assertEquals(2, alwaysCooperatePlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCopyCat() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player copyCatPlayer = new CopyCatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, copyCatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(-1, copyKittenPlayer.getCoins());
        assertEquals(3, copyCatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCopyKitten() {
        Player copyKittenPlayer1 = new CopyKittenPlayer();
        Player copyKittenPlayer2 = new CopyKittenPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer1, copyKittenPlayer2);

        transaction.processPlayerDecisions();

        assertEquals(2, copyKittenPlayer1.getCoins());
        assertEquals(2, copyKittenPlayer2.getCoins());
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsGrudger() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player grudgerPlayer = new GrudgerPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, grudgerPlayer);

        transaction.processPlayerDecisions();

        assertEquals(2, copyKittenPlayer.getCoins());
        assertEquals(2, grudgerPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCheat() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player alwaysCheatPlayer = new AlwaysCheatPlayer();

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(-1, grudgerPlayer.getCoins());
        assertEquals(3, alwaysCheatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCooprate() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player alwaysCooperatePlayer = new AlwaysCooperatePlayer();

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();

        assertEquals(2, grudgerPlayer.getCoins());
        assertEquals(2, alwaysCooperatePlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCopyCat() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player copyCatPlayer = new CopyCatPlayer();

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, copyCatPlayer);

        transaction.processPlayerDecisions();

        assertEquals(-1, grudgerPlayer.getCoins());
        assertEquals(3, copyCatPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCopyKitten() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();

        assertEquals(2, grudgerPlayer.getCoins());
        assertEquals(2, copyKittenPlayer.getCoins());
    }

    @Test
    void testProcessGameDecisionsGrudgerVsGrudger() {
        Player grudgerPlayer1 = new GrudgerPlayer();
        Player grudgerPlayer2 = new GrudgerPlayer();

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer1, grudgerPlayer2);

        transaction.processPlayerDecisions();

        assertEquals(2, grudgerPlayer1.getCoins());
        assertEquals(2, grudgerPlayer2.getCoins());
    }
}