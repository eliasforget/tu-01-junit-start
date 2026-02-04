package org.sebsy.levenshtein;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceLevenshteinTest {

    private DistanceLevenshtein distance;

    private static Object[][] cas;

    @BeforeAll
    static void initialiserCas() {
        cas = new Object[][]{
                {"chat", "chats", 1},
                {"machins", "machine", 1},
                {"java", "jee", 3}
        };
    }

    @BeforeEach
    void initialiser() {
        distance = new DistanceLevenshtein();
    }

    @Test
    void distance_chat_chats() {
        assertEquals((int) cas[0][2], distance.calculerDistance((String) cas[0][0], (String) cas[0][1]));
    }

    @Test
    void distance_machins_machine() {
        assertEquals((int) cas[1][2], distance.calculerDistance((String) cas[1][0], (String) cas[1][1]));
    }

    @Test
    void distance_java_jee() {
        assertEquals((int) cas[2][2], distance.calculerDistance((String) cas[2][0], (String) cas[2][1]));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/org/sebsy/levenshtein/DistanceLevenshtein.csv",
            delimiter = ';',
            numLinesToSkip = 1)
    void calculerDistance_depuisCsv(String mot1, String mot2, int distanceAttendue) {
        assertEquals(distanceAttendue, distance.calculerDistance(mot1, mot2));
    }

}
