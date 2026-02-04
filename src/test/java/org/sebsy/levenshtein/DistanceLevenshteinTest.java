package org.sebsy.levenshtein;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceLevenshteinTest {

    @Test
    void distanceEntreChatEtChats() {
        DistanceLevenshtein distance = new DistanceLevenshtein();

        int resultat = distance.calculerDistance("chat", "chats");

        assertEquals(1, resultat);
    }
}
