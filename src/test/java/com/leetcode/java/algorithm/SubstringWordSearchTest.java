package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SubstringWordSearchTest {

    private SubstringWordSearch substringWordSearch;

    @Before
    public void setUp() throws Exception {
        substringWordSearch = new SubstringWordSearch();
    }

    @Test
    public void test() {
        String[] dictionary = new String[] { "been", "doing", "a", "lot", "of", "graphic", "based", "blogging", "with",
                "Processing", "thought", "it", "would", "be", "fun", "to", "try", "something", "a", "little",
                "different" };
        substringWordSearch.addWords(dictionary);
        List<String> result = substringWordSearch.search(
                "gregrtget4grtagrertgrtlotewretretofrfwefregreysomethingfwefwfwefwelittlevgrevregreprocessingfwewe");
        assertTrue(result.contains("a"));
        assertTrue(result.contains("lot"));
        assertTrue(result.contains("to"));
        assertTrue(result.contains("of"));
        assertTrue(result.contains("something"));
        assertTrue(result.contains("little"));
        assertTrue(result.contains("it"));
        assertEquals(7, result.size());
    }

}
