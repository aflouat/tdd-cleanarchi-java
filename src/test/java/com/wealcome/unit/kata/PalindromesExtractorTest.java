package com.wealcome.unit.kata;

import com.wealcome.nextride.kata.PalindromesExtractor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromesExtractorTest {


    @ParameterizedTest
    @MethodSource("palindromes")
    public void extract_palindromes_of_a_given_sentence(
            String sentence, String[] expectedPalindromes) {
        assertThat(PalindromesExtractor.extract(sentence))
                .containsExactly(expectedPalindromes);
    }

    public static Object[][] palindromes() {
        return new Object[][]{
                {"", new String[]{}},
                {"A", new String[]{"A"}},
                {"AB", new String[]{}},
                {"AA", new String[]{"AA"}},
                {"ABCA", new String[]{}},
                {"ANNA ", new String[]{"ANNA"}},
                {"ANNA KAYAK", new String[]{"ANNA", "KAYAK"}},
                {"anna", new String[]{"ANNA"}},
                {"Anna est partie faire du Kayak mais flashée par un radar", new String[]{"ANNA", "KAYAK", "RADAR"}}
        };
    }

}
