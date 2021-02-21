package com.ordina.wordcount;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class WordFrequencyAbel implements WordFrequency {
    private final String word;
    private final int frequency;

    @Override
    public String toString() {
        return "(\"" + word + "\", " + frequency + ")";
    }
}
