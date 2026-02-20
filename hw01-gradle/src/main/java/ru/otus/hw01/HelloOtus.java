package ru.otus.hw01;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class HelloOtus {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(Lists.reverse(list));
    }
}
