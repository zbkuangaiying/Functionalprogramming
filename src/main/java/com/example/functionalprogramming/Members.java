package com.example.functionalprogramming;

import java.util.List;

public class Members {

    private List<String> names;
    private int count;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Members{" +
                "names=" + names +
                ", count='" + count + '\'' +
                '}';
    }
}
