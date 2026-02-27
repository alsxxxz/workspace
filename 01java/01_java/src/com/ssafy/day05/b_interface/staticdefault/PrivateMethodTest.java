package com.ssafy.day05.b_interface.staticdefault;

interface MyMath {
    static void add(int a, int b) {
        int result = a + b;
        print(a, b, '+', result);
    }

    default void multi(int a, int b) {
        print(a, b, '*', a * b);
    }

    private static void print(int num1, int num2, char oper, int result) {
        System.out.println("%d %c %d = %d".formatted(num1, oper, num2, result));
    }
}

public class PrivateMethodTest {

    public static void main(String[] args) {
        MyMath.add(10, 20);
    }
}
