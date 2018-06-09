package com.leetcode.java.algorithm.NewsFeed;

public class News {

    private int newsId;
    private String source;
    private String url;
    private int date;

    public News(int newsId, String source, String url, int date) {
        this.setNewsId(newsId);
        this.setSource(source);
        this.setUrl(url);
        this.setDate(date);
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getContent() {
        return null;
    }
}
