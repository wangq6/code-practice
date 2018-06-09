package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

    private LRUCache lruCache;

    @Before
    public void setUp() throws Exception {
        lruCache = new LRUCache(5);
    }

    @Test
    public void testPutGet() {
        lruCache.put("sadsafwe", "greerwev");
        assertEquals("greerwev", lruCache.get("sadsafwe"));
        lruCache.put("ghrr", "brtmyumyum");
        lruCache.put("nyrnyukuj ", "brtbrtfgb");
        lruCache.put("bfgrghjmym", "nghmhjmjhm,kj");
        assertEquals("brtmyumyum", lruCache.get("ghrr"));
        lruCache.put("rgrtyujmky", "bfgnvbm");
        lruCache.put("nyrnyukuj", "gt5nghfngh");
        assertEquals("brtmyumyum", lruCache.get("ghrr"));
        lruCache.put("nfghghjmj", "hbrtngbb,");
        lruCache.put("sadsafwe", "juhkjjmh");
        lruCache.put(",hkuj,kj", "rtymhjmjhy");
        assertEquals("gt5nghfngh", lruCache.get("nyrnyukuj"));
        lruCache.put("nyth", "nhytnhjmhj");
        assertEquals("juhkjjmh", lruCache.get("sadsafwe"));
        lruCache.put("rtyhkj", "nhgghrthyrt");
        lruCache.put("nhmhjmh", "retretyrt");
        assertEquals("gt5nghfngh", lruCache.get("nyrnyukuj"));
        assertEquals("nhgghrthyrt", lruCache.get("rtyhkj"));
        assertEquals("retretyrt", lruCache.get("nhmhjmh"));
        assertEquals(null, lruCache.get("bfgrghjmym"));

    }

}
