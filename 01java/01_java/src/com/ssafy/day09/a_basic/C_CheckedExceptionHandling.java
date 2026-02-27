package com.ssafy.day09.a_basic;

public class C_CheckedExceptionHandling {
    public static void main(String[] args) {
        // TODO: 다음에서 발생하는 예외를 처리해보자.
    	try {
              Class.forName("com.ssafy.day09.a_basic.C_CheckedExceptionHandling");
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
        // END
        System.out.println("프로그램 정상 종료");
    }

}
