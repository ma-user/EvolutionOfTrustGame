package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrudgerPlayerTest {

    @Test
    void testGrudgerStartsByCooperatingWithCheatPlayerForOneRound() {
        Player cheatPlayer = new AlwaysCheatPlayer();
        Player grudgerPlayer = new GrudgerPlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(cheatPlayer, grudgerPlayer, 1);

        trustGame.play();

        assertEquals(-1, grudgerPlayer.getCoins());
    }

    @Test
    void testGrudgerStartsByCooperatingWithCooperativePlayerForOneRound() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player cooperativePlayer = new AlwaysCooperatePlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(grudgerPlayer, cooperativePlayer, 1);

        trustGame.play();

        assertEquals(2, grudgerPlayer.getCoins());
    }

    @Test
    void testGrudgerStartsByCooperatingWithCopyCatForOneRound() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player copyCatPlayer = new CopyCatPlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(grudgerPlayer, copyCatPlayer, 1);

        trustGame.play();

        assertEquals(-1, grudgerPlayer.getCoins());
    }

    @Test
    void testGrudgerStartsByCooperatingWithCopyKittenForOneRound() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(grudgerPlayer, copyKittenPlayer, 1);

        trustGame.play();

        assertEquals(2, grudgerPlayer.getCoins());
    }

    @Test
    void testGrudgerStartsByCooperatingWithCheatPlayerThenCheatsAllRounds() {
        Player cheatPlayer = new AlwaysCheatPlayer();
        Player grudgerPlayer = new GrudgerPlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(cheatPlayer, grudgerPlayer, 3);

        trustGame.play();

        assertEquals(-1, grudgerPlayer.getCoins());
    }

    @Test
    void testGrudgerStartsByCooperatingWithCooperativePlayerThenCooperatesAllRounds() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player cooperativePlayer = new AlwaysCooperatePlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(grudgerPlayer, cooperativePlayer, 3);

        trustGame.play();

        assertEquals(6, grudgerPlayer.getCoins());
    }

    @Test
    void testGrudgerStartsByCooperatingWithCopyCatThenCheatsAllRounds() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player copyCatPlayer = new CopyCatPlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(grudgerPlayer, copyCatPlayer, 4);

        trustGame.play();

        assertEquals(2, grudgerPlayer.getCoins());
    }

    @Test
    void testGrudgerStartsByCooperatingWithCopyKittenThenCooperatesAllRounds() {
        Player grudgerPlayer = new GrudgerPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(grudgerPlayer, copyKittenPlayer, 4);

        trustGame.play();

        assertEquals(8, grudgerPlayer.getCoins());
    }
}