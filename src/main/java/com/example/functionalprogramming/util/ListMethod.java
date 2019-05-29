package com.example.functionalprogramming.util;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListMethod {

    public static<T> List<T> asList(T ...t){
        return Stream.of(t).collect(Collectors.toList());
    }
}
