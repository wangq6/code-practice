package com.leetcode.java.algorithm.NewsFeed;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class InternalNewsFeed {

    private HashMap<Integer, LinkedList<News>> personalNews;
    private HashMap<Integer, String> commonNewsCache;
    private Queue<Integer> commonNewsCacheList;
    private Queue<News> commonNews;
    private int capacity;

    public InternalNewsFeed(int capacity) {
        // TODO Auto-generated constructor stub
        this.capacity = capacity;
        personalNews = new HashMap<>();
        commonNewsCache = new HashMap<>();
        commonNewsCacheList = new LinkedList<>();
        commonNews = new LinkedList<>();
    }

    /** Compose a news to an account. */
    public void putPersonalNewsFeed(int userId, News news) {
        if (!personalNews.containsKey(userId))
            personalNews.put(userId, new LinkedList<>());
        personalNews.get(userId).offer(news);
    }

    /** Compose a common news */
    public void putCommonNewsFeed(News news) {
        commonNewsCache.put(news.getNewsId(), news.getContent());
        commonNews.offer(news);
        commonNewsCacheList.offer(news.getNewsId());
        if (commonNewsCache.size() >= capacity) {
            commonNewsCache.remove(commonNewsCacheList.poll());
        }
    }

    /** Retrieve the {length} most recent news from personal news feed. */
    public List<String> getPersonalNewsFeed(int userId, int length) {
        if (!personalNews.containsKey(userId)) {
            return new LinkedList<>();
        }
        PriorityQueue<News> feed = new PriorityQueue<>((t1, t2) -> t2.getDate() - t1.getDate());
        personalNews.get(userId).forEach(feed::add);
        List<String> res = new LinkedList<>();
        while (feed.size() > 0 && res.size() < length)
            res.add(feed.poll().getContent());
        return res;
    }

    /** Retrieve the {length} most recent news from common news feed. */
    public List<String> getCommonNewsFeed(int length) {
        if (commonNews.size() == 0) {
            return new LinkedList<>();
        }
        PriorityQueue<News> feed = new PriorityQueue<>((t1, t2) -> t2.getDate() - t1.getDate());
        commonNews.forEach(feed::add);
        List<String> res = new LinkedList<>();
        while (feed.size() > 0 && res.size() < length) {
            News news = feed.poll();
            if (commonNewsCache.containsKey(news.getNewsId())) {
                res.add(commonNewsCache.get(news.getNewsId()));
            } else {
                res.add(news.getContent());
            }
        }
        return res;
    }
}
