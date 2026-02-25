package com.ssafy.day08.a_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class C_MethodAndConstructorRef {

    public static void main(String[] args) {
        methodRef1();
        //methodRef2();
        //constructorRef();
    }

    private static void methodRef1() {
        // 다음 배열을 다양한 방식(lambda, 메서드 참조)으로 정렬해보자.
        Integer[] nums = { 1, 5, 4, 3, 8, 9 };
        // TODO: 위 배열을 숫자 오름차순으로 정렬하시오.

        // END
    }

    private static void methodRef2() {
        List<String> source = List.of("Hello", "Java", "World");
        List<String> target = new ArrayList<>();
        // TODO: source의 내용을 target으로 옮겨보자.

        // END

        // TODO: forEach를 이용하여 source의 내용을 출력하세요.

        // END
    }

    private static <T> void constructorRef() {
        Supplier<StringBuilder> s1 = () -> new StringBuilder();
        Supplier<StringBuilder> s2 = StringBuilder::new;
        StringBuilder sb1 = s2.get();

        Function<String, StringBuilder> f1 = (init) -> new StringBuilder(init);
        Function<String, StringBuilder> f2 = StringBuilder::new;
        StringBuilder sb2 = f2.apply("hong");

        System.out.println(sb2);

        // TODO: ArrayList 객체를 다양한 생성자 참조로 만들어보자.

        // END

    }
}
