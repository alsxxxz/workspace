package com.ssafy.day07.d_etc.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimplelyMakeCollection {

    public static void main(String[] args) {
        SimplelyMakeCollection smc = new SimplelyMakeCollection();
        smc.immutableCollection();
    }

    private void immutableCollection() {
        // 기존
        List<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");

        List<String> unmodifiableList = Collections.unmodifiableList(originalList);

        // JDK 9부터 가능
        List<String> list = List.of("Hello", "Java", "World");
        Set<String> set = Set.of("Hello", "Java", "World");
        Map<String, String> map = Map.of("lang", "Java", "ver", "JDK 9");

        // unmodifiableList.set(0, "Hi");
        //list.set(0, "Hi");
    }

}
