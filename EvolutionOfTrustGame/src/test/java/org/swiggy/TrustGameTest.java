package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrustGameTest {

    @Test
    public void testInitializeTrustGamePlay_nullPlayer1_throwsRuntimeException() {
        Player player = mock(Player.class);

        assertThrows(RuntimeException.class, () ->  new TrustGame(null, player, 3));
    }

    @Test
    public void testInitializeTrustGamePlay_nullPlayer2_throwsRuntimeException() {
        Player player = mock(Player.class);

        assertThrows(RuntimeException.class, () ->  new TrustGame(player, null, 3));
    }

    @Test
    public void testTrustGamePlay() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        TrustGame trustGame = new TrustGame(player1, player2, 3);
        TrustTransaction trustTransaction = mock(TrustTransaction.class);
        doNothing().when(trustTransaction).processPlayerDecisions();

        trustGame.play();

//        verify(playerTransaction, times(3)).processPlayerDecisions();
        verify(player1, times(3)).displayCoins();
        verify(player2, times(3)).displayCoins();
    }
}