package com.ssafy.day02.d_init;

public class LoadingSequenceTest {
    static int SIZE;
    static int[] sArray = new int[SIZE];
    int[] iArray = new int[SIZE];

    static {
        System.out.println("static initializer");
        SIZE = 10;
    }

    {
        System.out.println("instance initializer");
        SIZE = 2;
    }

    public LoadingSequenceTest() {
        System.out.println("constructor");
        SIZE = 1;
    }

    public static void main(String[] args) {
        System.out.println("SIZE: %d".formatted(SIZE));
        LoadingSequenceTest lst = new LoadingSequenceTest();
        System.out.println("sArray 길이: %d".formatted(sArray.length));
        System.out.println("SIZE: %d".formatted(SIZE));
        System.out.println("iArray 길이: %d".formatted(lst.iArray.length));
    }
}
