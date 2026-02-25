package com.ssafy.day08.b_stream.terminate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.ssafy.day08.b_stream.middle.StreamMiddleTest;

public class CollectTest {
    private List<String> words = StreamMiddleTest.setUpStream();

    public static void main(String[] args) {

        CollectTest ct = new CollectTest();
        ct.collectToList();;
        //ct.collectToMap();
    }

    private void collectToList() {
        // supplier: 최종 반환할 collection
        Supplier<List<String>> s = ArrayList::new;
        // accumulator: 하나씩 돌면서 누적시킴
        BiConsumer<List<String>, String> a = (list, str) -> list.add(str);
        // combiner: 두개의 List를 병합(parallel)
        BiConsumer<List<String>, List<String>> c = (l1, l2) -> l1.addAll(l2);

        words.parallelStream().filter(str -> str.length() >= 5).distinct().sorted().limit(5).collect(s, a, c).forEach(System.out::println);
        System.out.println();
        words.stream().filter(str -> str.length() >= 5).distinct().sorted().limit(5).collect(s, a, (l1, l2) -> {}).forEach(System.out::println);
        System.out.println();

        // TODO: 위 내용을 static 함수를 활용한 형태로 변경해보자.

        // END
    }

    /**
     * 단어별 등장 회수를 map에 담아 반환하세요. 단 등장 회수로 내림차순 정렬하고 상위 5개만 반환한다.
     */
    private void collectToMap() {
        // supplier: 최종 반환할 collection
        Supplier<Map<String, Integer>> supplier = HashMap::new;
        // accumulator: 하나씩 돌면서 누적 시킴
        BiConsumer<Map<String, Integer>, String> accumulator = (map, str) -> map.merge(str, 1, ((ov, nv) -> ov+nv));
        // combiner: 두개의 Hashmap을 병합함
        BiConsumer<Map<String, Integer>, Map<String, Integer>> combiner = (m1, m2) -> m2.forEach((k, v) -> m1.merge(k, v, Integer::sum));

        Map<String, Integer> result = words.parallelStream().collect(supplier, accumulator, combiner);

        result.entrySet().stream().sorted((i, j) -> Integer.compare(i.getValue(), j.getValue()) * -1).limit(5).forEach(System.out::println);
        System.out.println();

        // TODO: 위 내용을 static 함수를 활용한 형태로 변경해보자.

        // END
    }
}
