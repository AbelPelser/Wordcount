package com.ordina.wordcount;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyAnalyzerAbel implements WordFrequencyAnalyzer {
    @Override
    public int calculateHighestFrequency(String text) {
        return getWordFrequencyStream(text)
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0L).intValue();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        return (int) getWordStream(text)
                .filter(s -> s.equalsIgnoreCase(word))
                .count();
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        // First sort by frequency (value, reversed), then alphabetically (key)
        Comparator<Map.Entry<String, Long>> mapComparator = Map.Entry.<String, Long>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey());
        return getWordFrequencyStream(text)
                .sorted(mapComparator)
                .limit(n)
                .map(entry -> new WordFrequencyAbel(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());
    }

    private Stream<Map.Entry<String, Long>> getWordFrequencyStream(String text) {
        return getWordFrequencies(text).entrySet().stream();
    }

    private Map<String, Long> getWordFrequencies(String text) {
        return getWordStream(text)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Stream<String> getWordStream(String text) {
        return Arrays.stream(text.split("[^a-zA-Z]")).filter(s -> !s.isEmpty());
    }
}
