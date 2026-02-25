package com.ssafy.day08.b_stream.make;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FromCollectionTest {

    public static void main(String[] args) {
        String[] heroes = { "아이언맨", "스파이더맨", "헐크", "토르" , "홍길동", "이몽룡", "성춘향"};
        Stream<String> fromArray = Arrays.stream(heroes);

        List<String> heroList = fromArray.collect(Collectors.toList());

        // TODO: heroList를 통해 stream / parallel stream을 만들고 사용해보자.

        // END
    }
}
