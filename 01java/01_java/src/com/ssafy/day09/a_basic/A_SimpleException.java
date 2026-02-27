package com.ssafy.day09.a_basic;
//0126 예외처리

public class A_SimpleException {
    public static void main(String[] args) {
        int[] intArray = { 10 };
        try{
        	System.out.println(intArray[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        
        System.out.println("프로그램 종료합니다.");
    }
}
