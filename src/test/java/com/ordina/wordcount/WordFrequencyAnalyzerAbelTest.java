package com.ordina.wordcount;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordFrequencyAnalyzerAbelTest extends TestCase {
    private static final WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerAbel();

    public void testCalculateHighestFrequencyNormal() {
        String inputText = " aaa Aaa aAA bbb bbb cc ddd";
        assertEquals(3, wordFrequencyAnalyzer.calculateHighestFrequency(inputText));
    }

    public void testCalculateHighestFrequencyEmptyInput() {
        assertEquals(0, wordFrequencyAnalyzer.calculateHighestFrequency(""));
    }

    public void testCalculateFrequencyForWordNormal() {
        String inputText = " aaa Aaa aAA bbb bbb cc ddd";
        assertEquals(3, wordFrequencyAnalyzer.calculateFrequencyForWord(inputText, "aaa"));
    }

    public void testCalculateFrequencyForWordWordUpperCase() {
        String inputText = " aaa Aaa aAA bbb bbb cc ddd";
        assertEquals(3, wordFrequencyAnalyzer.calculateFrequencyForWord(inputText, "AAA"));
    }

    public void testCalculateFrequencyForWordDigitDelimiters() {
        String inputText = "aaa1Aaa2aAA3x4a5y6asdds7efffddsf891011sdffdf";
        assertEquals(3, wordFrequencyAnalyzer.calculateFrequencyForWord(inputText, "aaa"));
    }

    public void testCalculateFrequencyForWordEmptyInput() {
        assertEquals(0, wordFrequencyAnalyzer.calculateFrequencyForWord("", "aaa"));
    }

    public void testCalculateMostFrequentNWordsSimple() {
        String inputText = "aaa aaa bbb bbb ccc ";
        List<WordFrequency> expectedResult = Arrays.asList(
                new WordFrequencyAbel("aaa", 2),
                new WordFrequencyAbel("bbb", 2)
        );
        assertEquals(expectedResult, wordFrequencyAnalyzer.calculateMostFrequentNWords(inputText, 2));
    }

    public void testCalculateMostFrequentNWordsLimitTooHigh() {
        String inputText = "aaa aaa bbb bbb ccc ";
        List<WordFrequency> expectedResult = Arrays.asList(
                new WordFrequencyAbel("aaa", 2),
                new WordFrequencyAbel("bbb", 2),
                new WordFrequencyAbel("ccc", 1)
        );
        assertEquals(expectedResult, wordFrequencyAnalyzer.calculateMostFrequentNWords(inputText, 4));
    }

    public void testCalculateMostFrequentNWordsSortAlphabetically() {
        String inputText = "bbb bbb aaa aaa ccc ";
        List<WordFrequency> expectedResult = Arrays.asList(
                new WordFrequencyAbel("aaa", 2),
                new WordFrequencyAbel("bbb", 2)
        );
        assertEquals(expectedResult, wordFrequencyAnalyzer.calculateMostFrequentNWords(inputText, 2));
    }

    public void testCalculateMostFrequentNWordsChooseAlphabetically() {
        String inputText = "bbb bbb aaa aaa ccc ";
        List<WordFrequency> expectedResult = Collections.singletonList(
                new WordFrequencyAbel("aaa", 2)
        );
        assertEquals(expectedResult, wordFrequencyAnalyzer.calculateMostFrequentNWords(inputText, 1));
    }
}