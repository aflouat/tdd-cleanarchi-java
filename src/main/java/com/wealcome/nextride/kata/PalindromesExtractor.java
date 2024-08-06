package com.wealcome.nextride.kata;


// "Anna est partie faire du Kayak mais flashée par un radar"
// ["ANNA", "KAYAK", "RADAR"]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromesExtractor {

    private PalindromesExtractor() {
    }

    public static List<String> extract(String sentence) {
        String[] words = Arrays.stream(sentence.split("\\s"))
                .map(
                        String::toUpperCase
                ).toArray(String[]::new);
        List<String> palindromes = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty() && isPalindrome(word))
                palindromes.add(word);
        }
        return palindromes;
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length(); i++)
            if (word.charAt(i) != word.charAt(word.length() - i - 1))
                return false;
        return true;
    }

}
