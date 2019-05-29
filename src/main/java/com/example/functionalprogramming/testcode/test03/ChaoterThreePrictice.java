package com.example.functionalprogramming.testcode.test03;

import com.example.functionalprogramming.Album;
import com.example.functionalprogramming.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 第三章 stream的练习题
 */
public class ChaoterThreePrictice {
    static int sum = 0;
    public static void main(String args[]) {

        //1.a 求和函数
        addup(Stream.of(1,2,3,4,5));
        //1.2 遍历返回字符串列表
        Artist artist = new Artist();
        artist.setName("aaa");
        artist.setNationality("bbb");
        getName(Stream.of(artist));
        //1.3
        Album album = new Album();
        getList(Stream.of(album));

        // 2
        getSimpleStream();

        // 3
        // boolean anyMatch(Predicate < ? super T> pridicate) 惰性
        // Stream<T> limit(long maxSize) 早求值

        // 4
        // boolean anyMatch(Predicate < ? super T> pridicate) 高阶函数
        // Stream<T> limit(long maxSize) 非高阶函数

        // 5 没弄明白

        // 6
       int count = calculChars("abcdefghigklmnOPQRSTUVWXYZ");

       // 7
        Optional<String> num = maxChars(Stream.of("a","aaa","aaaaa","aaaaaaa"));

    }

    private static Optional<String> maxChars(Stream<String> a) {
        return a.max(Comparator.comparing( ChaoterThreePrictice::calculChars));
    }

    private static int calculChars(String str) {

        return (int) str.chars().filter(c -> c >='a' && c <= 'z').count();
    }

    private static void getSimpleStream() {
        Stream.of(new Artist[]{new Artist(),new Artist()}).map(artist -> artist.getMembers().getCount()).reduce(0,(x,y)-> x+y);
    }

    private static void getList(Stream<Album> album) {
        album.filter(album1 -> album1.getTracks().size() <= 3).collect(toList());
    }

    private static void getName(Stream<Artist> a) {
        List<String> collect = a.flatMap(artist -> Stream.of( artist.getName() + artist.getNationality())).collect(toList());
    }

    private static int addup(Stream<Integer> integerStream) {
       return integerStream.reduce(0,(x,y)->x+y);
    }



}
