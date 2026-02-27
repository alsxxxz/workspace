package com.ssafy.day03.c_modifier.last;

public class LoadingSequenceTest {

    private static LoadingSequenceTest lst = new LoadingSequenceTest();
    // TODO: array의 length가 10이 될 수 있도록 코드를 개선해보자.
     private static int SIZE = 10;

    // END
    private int[] array;

    public static LoadingSequenceTest getInstance() {
        return lst;
    }

    private LoadingSequenceTest() {
        // 멤버 변수의 초기화
        array = new int[SIZE];
    }

    public static void main(String[] args) {
        LoadingSequenceTest lst = LoadingSequenceTest.getInstance();
        System.out.println(lst.array.length);
    }

}
