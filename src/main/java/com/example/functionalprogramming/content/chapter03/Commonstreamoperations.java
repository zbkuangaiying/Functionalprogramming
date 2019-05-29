package com.example.functionalprogramming.content.chapter03;

import com.example.functionalprogramming.Album;
import com.example.functionalprogramming.Artist;
import com.example.functionalprogramming.DataConstant;
import com.example.functionalprogramming.Track;
import com.example.functionalprogramming.util.ListMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Commonstreamoperations {

    ArrayList<Artist> artists = DataConstant.artists;

    public static void main(String args[]){
        //Collect (toList)  是有stream里的值生成一个列表 是一个早求值操作

        List<String> collected = Stream.of("a","b","c"). //第一步 用stream的各种惰性求值方法
                collect(Collectors.toList());//第二步 用类似collect之类的早求值方法获得结果
        System.out.println(Arrays.asList("a","b","c"));
        System.out.println(collected);



        //map 如果有一个函数可以将一种类型的值转为另外一种类型  可以使用Map函数 将一个流种的值转为另外一个新的流  惰性方法

         collected = Stream.of("a","b","c")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(Arrays.asList("A","B","C"));
        System.out.println(collected);

        //  filter 遍历数据并检查其中的元素时  可以尝试使用filter
        collected =  Stream.of("abc","1abc","cba")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(collected);

        //flatmap 此方法可以用Stream替换值  然后将多个Stream连接成一个Stream   只是合并值 并不排序

        List<Integer> collect = Stream.of(ListMethod.asList(2, 1), ListMethod.asList(4, 3))
                .flatMap(number -> number.stream())
                .collect(Collectors.toList());
        System.out.println(collect);


        //max  min  最最大值最小值

        Track resultTrack = ListMethod.asList(new Track("Bakai", 524), new Track("Violets for your furs", 624), new Track("time Was", 424))
                .stream().min(Comparator.comparing(track -> track.getDuration()))
                .get();

        System.out.println(resultTrack.toString());

        resultTrack = ListMethod.asList(new Track("Bakai", 524), new Track("Violets for your furs", 624), new Track("time Was", 424))
                .stream().max(Comparator.comparing(track -> track.getDuration()))
                .get();

        System.out.println(resultTrack.toString());

        // reduce
        //可以实现从一组值种生成一个值  count min max方法因为常用被列入标准库 实际上这些操作都是reduce操作

        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        System.out.println(count);

        //展开上面这个式子
        BinaryOperator <Integer> accMulator = (acc,element) -> acc+element;
        count = accMulator.apply(accMulator.apply(accMulator.apply(0,1),2),3);
        //java写法
        int acc = 0;
        for (int element : ListMethod.asList(1,2,3)){
            acc = acc + element;
        }

        //整合操作   对面上这些操作来一个整合
        //解决一个问题 找出某张专辑上所有乐队的国籍
        //艺术家列表里基友个人也有乐队  乐队名字一般以the开头
        //分为4步
        //通过album的getMusicians方法 返货一个包含整张专辑涨所有表演者的集合
        //用filter方法对表演者进行过滤  只保留属性为乐队而非歌唱的 表演者
        //用map方法将表演者映射为其所属国家
        //

        Album album = new Album();
        album.setName("杂烩");
        Artist artistA =new Artist();
        artistA.setName("the moon");
        artistA.setNationality("amc");

        Artist artistB =new Artist();
        artistB.setName("the denglijun");
        artistB.setNationality("china");

        Artist artistC =new Artist();
        artistC.setName("cxk");
        artistC.setNationality("china");
//        album.setMusicians(ListMethod.asList(artistA,artistB,artistC));


        Set<String> the = ListMethod.asList(artistA, artistB, artistC).stream()
                .filter(artist -> artist.getName().startsWith("the"))
                .map(artist -> artist.getNationality())
                .collect(toSet());
        System.out.println(the.toString());

        System.out.println(Stream.of(1,2,3,4,5).max(Comparator.comparing( i -> i)).get());


    }


    public static boolean isDigit(char c){
        return    '0' <= c  && c <= '9';
    }



}
