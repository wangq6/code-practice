package com.leetcode.java.algorithm.Refridge;

import java.util.List;

public class Person {

    private List<String> preference;
    private String name;

    public Person(String name, List<String> preference) {
        // TODO Auto-generated constructor stub
        this.setPreference(preference);
        this.setName(name);
    }

    public List<String> getPreference() {
        return preference;
    }

    public void setPreference(List<String> preference) {
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
