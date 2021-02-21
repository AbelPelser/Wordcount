package com.ordina.wordcountee;

import com.ordina.wordcount.WordFrequencyAnalyzer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("wordcount")
public class WordCountResource {
    private final WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @Inject
    public WordCountResource(WordFrequencyAnalyzer wordFrequencyAnalyzer) {
        this.wordFrequencyAnalyzer = wordFrequencyAnalyzer;
    }

    @GET
    @Path("/calculate-highest-frequency/{text}")
    @Produces("text/plain")
    public String calculateHighestFrequency(@PathParam("text") String text) {
        return String.valueOf(wordFrequencyAnalyzer.calculateHighestFrequency(text));
    }

    @GET
    @Path("/calculate-frequency-for-word/{text}/{word}")
    @Produces("text/plain")
    public String calculateFrequencyForWord(@PathParam("text") String text, @PathParam("word") String word) {
        return String.valueOf(wordFrequencyAnalyzer.calculateFrequencyForWord(text, word));
    }

    @GET
    @Path("/calculate-most-frequent-n-words/{text}/{n}")
    @Produces("text/plain")
    public String calculateMostFrequentNWords(@PathParam("text") String text, @PathParam("n") int n) {
        return String.valueOf(wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n));
    }
}