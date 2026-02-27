package com.ssafy.day08.b_stream.middle;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMiddleTest {
    List<String> words;

    public static void main(String[] args) {
        StreamMiddleTest ft = new StreamMiddleTest();
        ft.words = setUpStream();
        ft.filterTest();
        //ft.sortTest();
        //ft.mapTest();
        //ft.flatMapTest();
    }

    public static List<String> setUpStream() {
        List<String> words = null;
        try {
            Path text = Paths.get(StreamMiddleTest.class.getResource("../song.txt").toURI());
            words = Files.readAllLines(text).stream().flatMap(data -> Arrays.stream(data.split("[,-. ]")))
                    .collect(Collectors.toList());

            System.out.println("초기 단어 개수: " + words.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    private void filterTest() {
        System.out.println("중복 제거 결과: " + words.stream().distinct().count());
        System.out.println("처음 다섯개 단어: ");
        words.stream().limit(5).forEach(System.out::println);

        // TODO: 다음의 요청 사항을 stream으로 구현해보자.
        //  1. words에서 단어의 길이가 5 이상인 단어의 개수는?
        //  2. 오가 들어가는 단어 중 처음 4개를 생략하고 2개 출력해보자.
        //  3. 0~100 까지의 정수에서 짝수의 합을 구해보자.

        // END

    }

    private void sortTest() {
        words.stream().distinct().sorted((a, b) -> {
            return a.compareTo(b) * -1;
        }).limit(3).forEach(System.out::println);

        // TODO: 다음의 요청 사항을 stream으로 구현해보자.
        //  words에서 중복을 제거하고 글자수에 대한 내림차순 정렬 했을 때 가장 긴 문자열의 길이는?

        // END
    }

    private void mapTest() {
        List<String> list = Arrays.asList("Hello", "Stream");
        list.stream().map(item -> item.toCharArray()).forEach(arr -> System.out.println(arr.length));

        // Integer -> String
        IntStream is = IntStream.range(0, 5);
        is.mapToObj(num -> "제곱: " + num * num).forEach(System.out::println);

        Map<String, Integer> map = Map.of("hong", 100, "jang", 80, "lim", 95, "kim", 4);
        // TODO: map의 점수에 이름의 길이를 곱한 총 합을 출력해보자.

        // END
    }

    private void flatMapTest() {
        List<String> list = Arrays.asList("Hello", "Stream");
        list.stream().map(item -> item.toCharArray()).forEach(arr -> System.out.println(arr.length));
        list.stream().flatMap(item -> Arrays.stream(item.split(""))).forEach(System.out::println);

        // TODO: 1단의 합~9단의 합을 모두 더해서 반환해보자.

        // END
    }

}
