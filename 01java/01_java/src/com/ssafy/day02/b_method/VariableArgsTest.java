package com.ssafy.day02.b_method;

public class VariableArgsTest {
    public static void main(String[] args) {
        VariableArgsTest vt = new VariableArgsTest();
        vt.variableArgs(1, 2, 3);
        vt.variableArgs(1, 2, 3, 4, 5);
        vt.variableArgs(1, 2);
    }

    public void variableArgs(int... params) { //대문자 o로 시작하는 object **...
        int sum = 0;
        for (int i : params) {
            sum += i;
        }
        System.out.println(sum);
    }

}


매개변수 개수가 정해지지 않은 가변 인자. 메서드 호출시 0개 이상의 int값 전달 가능.

static이 없는 void, int iv는 먼저 메모리를 할당해줘야한다. -> 객체 생성으로 메모리 할당해줘야함. 

First d = new first(); f.iv = int 10; h.iMethodA();' static: 클래스 로딩 시 자동으로 메모리 할당 (프로그램
시작할 때) non-static (인스턴스): new 키워드로 객체 생성할 때 메모리 할당

