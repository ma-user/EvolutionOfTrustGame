package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyKittenTest {

    @Test
    void testCopyKittenPlayerStartsByCooperatingWithCheatPlayer() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player cheatPlayer = new AlwaysCheatPlayer();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyKittenPlayer, cheatPlayer, 1);

        trustGame.play();

        assertEquals(-1, copyKittenPlayer.getCoins());
    }

    @Test
    void testCopyKittenStartsByCooperatingWithCooperative() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player cooperativePlayer = new AlwaysCooperatePlayer();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyKittenPlayer, cooperativePlayer, 1);

        trustGame.play();

        assertEquals(2, copyKittenPlayer.getCoins());
    }

    @Test
    void testCopyKittenStartsByCooperatingWithCopyCat() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player copyCatPlayer = new CopyCatPlayer();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyKittenPlayer, copyCatPlayer, 1);

        trustGame.play();

        assertEquals(-1, copyKittenPlayer.getCoins());
    }

    @Test
    void testCopyKittenStartsByCooperatingWithGrudger() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player grudgerPlayer = new GrudgerPlayer();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyKittenPlayer, grudgerPlayer, 1);

        trustGame.play();

        assertEquals(2, copyKittenPlayer.getCoins());
    }

    @Test
    void testCopyKittenMimicsCooperativeDecisionAfterFirstRound() {
        Player cooperativePlayer = new AlwaysCooperatePlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();
        TrustGame trustGame = new TrustGame(copyKittenPlayer, cooperativePlayer, 3);

        trustGame.play();

        assertEquals(6, copyKittenPlayer.getCoins());
    }

    @Test
    void testCopyKittenMimicsCheatDecisionAfterFirstRound() {
        Player cheatPlayer = new AlwaysCheatPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();
        TrustGame trustGame = new TrustGame(copyKittenPlayer, cheatPlayer, 2);

        trustGame.play();

        assertEquals(-1, copyKittenPlayer.getCoins());
    }

    @Test
    void testCopyKittenMimicsCopyCatDecisionAfterFirstRound() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player copyCatPlayer = new CopyCatPlayer();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyKittenPlayer, copyCatPlayer, 3);

        trustGame.play();

        assertEquals(1, copyKittenPlayer.getCoins());
    }

    @Test
    void testCopyKittenMimicsGrudgerDecisionAfterFirstRound() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player grudgerPlayer = new GrudgerPlayer();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyKittenPlayer, grudgerPlayer, 3);

        trustGame.play();

        assertEquals(6, copyKittenPlayer.getCoins());
    }
}

