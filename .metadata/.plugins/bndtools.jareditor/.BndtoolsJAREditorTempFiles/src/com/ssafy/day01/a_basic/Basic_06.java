package com.ssafy.day01.a_basic;

public class Basic_06 {
    public static void main(String[] args) {
        // TODO: 기본형과 객체형의 형 변환에 대해 살펴보자. 
        int i = 1024;
        // 기본형 --> 참조
        Integer iw = Integer.valueOf(i);
        Integer iw2 = i; // autoboxing
        System.out.printf("%d와 %d는 같은 객체? %b, 같은 내용? %b%n", iw, iw2, iw == iw2, iw.equals(iw2)); // -128 부터 127까지는 캐싱되어 있음

        // 참조형 --> 기본
        int i2 = iw.intValue();
        int i3 = iw; // unboxing
        System.out.println("두 값은 같은 값? " + (i2 == i3));

        // 기본형 --> 문자열
        String s1 = String.valueOf(i);
        String s2 = "" + i; // 결합 연산
        System.out.printf("%s와 %s는 같은 객체? %b, 같은 내용? %b%n", s1, s2, s1 == s2, s1.equals(s2));

        // 문자열 --> 기본형
        int i4 = Integer.parseInt(s1);
        System.out.println(i4);

        // 참조형 --> 문자열
        String s3 = iw.toString();
        String s4 = "" + iw;
        System.out.printf("%s와 %s는 같은 객체? %b, 같은 내용? %b%n", s3, s4, s3 == s4, s3.equals(s4));

        // 문자열 --> 참조형
        Integer iw3 = Integer.valueOf(s4);
        Integer iw4 = Integer.parseInt(s4);
        System.out.printf("%d와 %d는 같은 객체? %b, 같은 내용? %b%n", iw3, iw4, iw3 == iw4, iw3.equals(iw4));

        // END
    }
}
