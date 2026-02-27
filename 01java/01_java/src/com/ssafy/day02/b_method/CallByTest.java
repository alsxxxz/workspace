package com.ssafy.day02.b_method;

public class CallByTest {
  int memberVar = 10;

  static void change1(int var) {
    var += 10;
    System.out.printf("change1 : %d%n", var);
  }

  static void change2(CallByTest cbtl) {
    cbtl.memberVar += 100;
    System.out.printf("change2 : %d%n", cbtl.memberVar);
  }

  public static void main(String[] args) {
    CallByTest cbt = new CallByTest();
    cbt.memberVar = 5;
    System.out.printf("change1 호출 전 memberVar: %d%n", cbt.memberVar);
    change1(cbt.memberVar);
    System.out.printf("change1 호출 후 memberVar: %d%n", cbt.memberVar);
    change2(cbt);
    System.out.printf("change2 호출 후 memberVar: %d%n", cbt.memberVar);
  }
}



//*시험문제
//기본형 변수와 참조형 변수
//메서드 호출시 파라미터로 입력된 값을 복사해서 전달
//java는 call by vlaue! value의 정체는

오버로딩은 왜 할까
-> 하는 일은 같으니 중복코드를 제거할겸한다.
