package org.sebsy.levenshtein;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // -----------------------------
    // Tests distance (J1.2 / J1.3)
    // -----------------------------

    @Test
    void distance_chat_chats() {
        assertEquals((int) cas[0][2],
                distance.calculerDistance((String) cas[0][0], (String) cas[0][1]));
    }

    @Test
    void distance_machins_machine() {
        assertEquals((int) cas[1][2],
                distance.calculerDistance((String) cas[1][0], (String) cas[1][1]));
    }

    @Test
    void distance_java_jee() {
        assertEquals((int) cas[2][2],
                distance.calculerDistance((String) cas[2][0], (String) cas[2][1]));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/org/sebsy/levenshtein/DistanceLevenshtein.csv",
            delimiter = ';',
            numLinesToSkip = 1)
    void calculerDistance_depuisCsv(String mot1, String mot2, int distanceAttendue) {
        assertEquals(distanceAttendue, distance.calculerDistance(mot1, mot2));
    }

    // -----------------------------
    // Tests exception (J1.4)
    // -----------------------------

    @Test
    void mot1_null_declencheException() {
        AppException ex = assertThrows(AppException.class,
                () -> distance.calculerDistance(null, "abc"));

        assertEquals("le premier paramètre ne peut être null ou vide", ex.getMessage());
    }

    @Test
    void mot1_vide_declencheException() {
        AppException ex = assertThrows(AppException.class,
                () -> distance.calculerDistance("", "abc"));

        assertEquals("le premier paramètre ne peut être null ou vide", ex.getMessage());
    }

    @Test
    void mot2_null_declencheException() {
        AppException ex = assertThrows(AppException.class,
                () -> distance.calculerDistance("abc", null));

        assertEquals("le second paramètre ne peut être null ou vide", ex.getMessage());
    }

    @Test
    void mot2_vide_declencheException() {
        AppException ex = assertThrows(AppException.class,
                () -> distance.calculerDistance("abc", ""));

        assertEquals("le second paramètre ne peut être null ou vide", ex.getMessage());
    }
}
