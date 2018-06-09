package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WildcardMatchTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testIsMatch() {
        assertFalse(WildcardMatch.isMatch("aa", "a"));
        assertTrue(WildcardMatch.isMatch("aa", "aa"));
        assertFalse(WildcardMatch.isMatch("aaa", "aa"));
        assertTrue(WildcardMatch.isMatch("aa", "*"));
        assertTrue(WildcardMatch.isMatch("aa", "a*"));
        assertTrue(WildcardMatch.isMatch("ab", "?*"));
        assertFalse(WildcardMatch.isMatch("aab", "c*a*b"));
        assertTrue(WildcardMatch.isMatch("abc", "a***?c"));
        assertFalse(WildcardMatch.isMatch("abc", "?*?d"));
        assertTrue(WildcardMatch.isMatch("a", "?*"));
        assertTrue(WildcardMatch.isMatch("a", "*?"));
        assertFalse(WildcardMatch.isMatch("a", "??*"));
        assertTrue(WildcardMatch.isMatch("abc", "a?*c"));
        assertFalse(WildcardMatch.isMatch("abc", "a?*d"));
        assertTrue(WildcardMatch.isMatch("", ""));
        assertFalse(WildcardMatch.isMatch("", "?"));
        assertTrue(WildcardMatch.isMatch("", "*"));
        assertFalse(WildcardMatch.isMatch("", "a*"));
        assertTrue(WildcardMatch.isMatch("", "**"));
        assertTrue(WildcardMatch.isMatch("abaaaa", "a*a*a"));
        assertTrue(WildcardMatch.isMatch("abcdec", "ab*c"));
    }

    @Test
    public void testIsMatchDp() {
        assertFalse(WildcardMatch.isMatchDp("aa", "a"));
        assertTrue(WildcardMatch.isMatchDp("aa", "aa"));
        assertFalse(WildcardMatch.isMatchDp("aaa", "aa"));
        assertTrue(WildcardMatch.isMatchDp("aa", "*"));
        assertTrue(WildcardMatch.isMatchDp("aa", "a*"));
        assertTrue(WildcardMatch.isMatchDp("ab", "?*"));
        assertFalse(WildcardMatch.isMatchDp("aab", "c*a*b"));
        assertTrue(WildcardMatch.isMatchDp("abc", "a***?c"));
        assertFalse(WildcardMatch.isMatchDp("abc", "?*?d"));
        assertTrue(WildcardMatch.isMatchDp("a", "?*"));
        assertTrue(WildcardMatch.isMatchDp("a", "*?"));
        assertFalse(WildcardMatch.isMatchDp("a", "??*"));
        assertTrue(WildcardMatch.isMatchDp("abc", "a?*c"));
        assertFalse(WildcardMatch.isMatchDp("abc", "a?*d"));
        assertTrue(WildcardMatch.isMatchDp("", ""));
        assertFalse(WildcardMatch.isMatchDp("", "?"));
        assertTrue(WildcardMatch.isMatchDp("", "*"));
        assertFalse(WildcardMatch.isMatchDp("", "a*"));
        assertTrue(WildcardMatch.isMatchDp("", "**"));
        assertTrue(WildcardMatch.isMatchDp("abaaaa", "a*a*a"));
    }
    
    @Test
    public void testIsMatchRecursive() {
        assertFalse(WildcardMatch.isMatchRecursive("aa", "a"));
        assertTrue(WildcardMatch.isMatchRecursive("aa", "aa"));
        assertFalse(WildcardMatch.isMatchRecursive("aaa", "aa"));
        assertTrue(WildcardMatch.isMatchRecursive("aa", "*"));
        assertTrue(WildcardMatch.isMatchRecursive("aa", "a*"));
        assertTrue(WildcardMatch.isMatchRecursive("ab", "?*"));
        assertFalse(WildcardMatch.isMatchRecursive("aab", "c*a*b"));
        assertTrue(WildcardMatch.isMatchRecursive("abc", "a***?c"));
        assertFalse(WildcardMatch.isMatchRecursive("abc", "?*?d"));
        assertTrue(WildcardMatch.isMatchRecursive("a", "?*"));
        assertTrue(WildcardMatch.isMatchRecursive("a", "*?"));
        assertFalse(WildcardMatch.isMatchRecursive("a", "??*"));
        assertTrue(WildcardMatch.isMatchRecursive("abc", "a?*c"));
        assertFalse(WildcardMatch.isMatchRecursive("abc", "a?*d"));
        assertTrue(WildcardMatch.isMatchRecursive("", ""));
        assertFalse(WildcardMatch.isMatchRecursive("", "?"));
        assertTrue(WildcardMatch.isMatchRecursive("", "*"));
        assertFalse(WildcardMatch.isMatchRecursive("", "a*"));
        assertTrue(WildcardMatch.isMatchRecursive("", "**"));
        assertTrue(WildcardMatch.isMatchRecursive("a", "**"));
        assertTrue(WildcardMatch.isMatchRecursive("abaaaa", "a*a*a"));
    }

}
