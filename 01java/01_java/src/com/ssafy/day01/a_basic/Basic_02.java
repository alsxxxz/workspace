package com.ssafy.day01.a_basic;

public class Basic_02 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        stringCompare(str1, str2);
        stringCompare(str3, str4);

        textBlockTest();
    }

    private static void stringCompare(String s1, String s2) {
        // TODO: 두 문자열을 같습니까? 
        System.out.println("equal(내용이 같나요?) " + (s1.equals(s2)));
        System.out.println("==(같은 객체인가요?) " + (s1 == s2));

        // END
    }

    private static void textBlockTest() {
        String name = "hong gil dong";
        int salary = -20000000;
        double height = 1800.1592;
        String address = "율도국";
        // TODO: 위 내용을 하나의 문자열로 표현해보자. 단 속성별로 한 줄에 하나씩만 표현하고 키는 소숫점 2자리로 한다.

        // END
    }
}
