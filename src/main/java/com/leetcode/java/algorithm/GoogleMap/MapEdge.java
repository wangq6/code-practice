package com.leetcode.java.algorithm.GoogleMap;

public class MapEdge {

    private final String id;
    private final MapNode source;
    private final MapNode destination;
    private final int weight;

    public MapEdge(String id, MapNode source, MapNode destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }
    public MapNode getDestination() {
        return destination;
    }

    public MapNode getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }

}
