package com.example.functionalprogramming.content.chapter03;

import com.example.functionalprogramming.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * stream是用函数式编程方式在集合类上进行复杂操作的工具
 */
public class Streams {

    public static void main(String args[]) {
        List<Artist> allArtists = new ArrayList<>();
        Artist artistOne = new Artist();
        artistOne.setName("John");
        artistOne.setOrigin("London");
        Artist artistTwo = new Artist();
        artistTwo.setOrigin("London");
        artistTwo.setName("Paul");
        Artist artistThree = new Artist();
        artistThree.setOrigin("paris");
        artistThree.setName("george");
        allArtists.add(artistOne);
        allArtists.add(artistTwo);
        allArtists.add(artistThree);

        //每种操作都对应Stream接口的一个方法 .
        //为了找出来自伦敦的艺术家 需要对Stream对象进行过滤  filter  过滤在这里是是指 "只保留通过某项测试的对象"
        //测试由一个函数完成 根据艺术家是否来自伦敦 该函数返回true 或者 false
        //由于Stream API函数式变成风格  我们这里并没有改变集合的内容 而是描述出Stream里的内容
        //count() 负责计算给定的Stream里包含多少个对象
        long counts = allArtists.stream().filter(artist -> artist.isFrom("London")).count();


        //filter()只返回一个用来描述集合的Stream 是一个惰性求值方法 没有给出最终的值
        java.util.stream.Stream<Artist> a = allArtists.stream().filter(artist -> {
            System.out.println(artist.getName() + " from " + artist.getOrigin());
            return artist.isFrom("London");
        });

        //count()放回的是一个确切的值或者是空  是一个早求值方法
        long counts1 = allArtists.stream().filter(artist -> {
            System.out.println(artist.getName() + " from " + artist.getOrigin());
            return artist.isFrom("London");
        }).count();

        //判断一个操作是惰性求值 还是 早求值   只需要看它的返回值..
        //返回的是stream 就是惰性求值 返回的是确切的值 则是早求值
        //最好的使用方式是为 链式操作各种惰性求值  最后一步早求值返回需要的结果
        //整个过程跟builder建造者模式类似  都是一系列的设置或者属性匹配或者属性设置  最后调用一个build()或者count()  此时对象才真正的被创建


        //区分这个的意义
        //在对需要什么样的结果和操作有了更多了解之后 才能更有效率的进行计算
        //例如 如果要找大于10的第一个数字  那么并不需要和所有元素去做比较 只要找出第一个匹配的元素就够了 这也意味着可以在集合类上 级联 多种操作 但是只迭代一次

    }
}
