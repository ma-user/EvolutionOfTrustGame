package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyCatPlayerTest {

    @Test
    void testCopyCatPlayerStartsByCheatingWithCheatPlayer() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cheatPlayer = new AlwaysCheatPlayer();

        assertEquals(Decision.CHEAT, copyCatPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyCatPlayer, cheatPlayer, 1);

        trustGame.play();

        assertEquals(0, copyCatPlayer.getCoins());
    }

    @Test
    void testCopyCatPlayerStartsByCheatingWithCooperativePlayer() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cooperativePlayer = new AlwaysCooperatePlayer();

        assertEquals(Decision.CHEAT, copyCatPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyCatPlayer, cooperativePlayer, 1);

        trustGame.play();

        assertEquals(3, copyCatPlayer.getCoins());
    }

    @Test
    void testCopyCatPlayerStartsByCheatingWithCopyKitten() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();

        assertEquals(Decision.CHEAT, copyCatPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyCatPlayer, copyKittenPlayer, 1);

        trustGame.play();

        assertEquals(3, copyCatPlayer.getCoins());
    }

    @Test
    void testCopyCatPlayerStartsByCheatingWithGrudger() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player grudgerPlayer = new GrudgerPlayer();

        assertEquals(Decision.CHEAT, copyCatPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyCatPlayer, grudgerPlayer, 1);

        trustGame.play();

        assertEquals(3, copyCatPlayer.getCoins());
    }

    @Test
    void testCopyCatPlayerMimicsCheatPlayerDecisionAfterFirstRound() {
        Player cheatPlayer = new AlwaysCheatPlayer();
        Player copyCatPlayer = new CopyCatPlayer();
        TrustGame trustGame = new TrustGame(copyCatPlayer, cheatPlayer, 2);

        trustGame.play();

        assertEquals(0, copyCatPlayer.getCoins());
    }

    @Test
    void testCopyCatPlayerMimicsCooperativePlayerDecisionAfterFirstRound() {
        Player cooperativePlayer = new AlwaysCooperatePlayer();
        Player copyCatPlayer = new CopyCatPlayer();
        TrustGame trustGame = new TrustGame(copyCatPlayer, cooperativePlayer, 3);

        trustGame.play();

        assertEquals(7, copyCatPlayer.getCoins());
    }

    @Test
    void testCopyCatPlayerMimicsCopyKittenDecisionAfterFirstRound() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player copyKittenPlayer = new CopyKittenPlayer();

        assertEquals(Decision.CHEAT, copyCatPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyCatPlayer, copyKittenPlayer, 3);

        trustGame.play();

        assertEquals(5, copyCatPlayer.getCoins());
    }

    @Test
    void testCopyCatPlayerMimicsGrudgerDecisionAfterFirstRound() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player grudgerPlayer = new GrudgerPlayer();

        assertEquals(Decision.CHEAT, copyCatPlayer.makeDecision());

        TrustGame trustGame = new TrustGame(copyCatPlayer, grudgerPlayer, 3);

        trustGame.play();

        assertEquals(2, copyCatPlayer.getCoins());
    }
}