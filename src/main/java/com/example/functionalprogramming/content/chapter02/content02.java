package com.example.functionalprogramming.content.chapter02;

import android.view.View;

import com.example.functionalprogramming.util.TestLog;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class content02 {

    public static void mian(String args[]){

        Runnable noArguments = () -> TestLog.e("hello world");
        View.OnClickListener listener = view -> TestLog.e("hello world by view.Listener");
        Runnable multistatment = () -> {
            TestLog.e("hello world ");
            TestLog.e("by multistatment");
        };
        BinaryOperator<Long> add =  (Long x, Long y) -> x + y;
        BinaryOperator<Long> addExplicit = (x,y) ->x+y;
        TestLog.e("BinaryOperator<Long> add --------->" + add.apply(3l,5l));
//        Artist john = new Artist();
//        john.setName("约翰");
//
//        String name = john.getName();
//        btn.setOnClickListener(view -> TestLog.e("hi" + name));
        Predicate<Integer> a = x -> x>5;
        TestLog.e(a.test(4)+"");
        Runnable helloworld = () -> System.out.println("hello world");
    }
}
