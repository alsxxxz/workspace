package com.ssafy.day03.c_modifier.last;
//final -> 오버라이드 금지. 이미 완벽하기 때문에 재정의하는것을 막아둔다.
//주관식 단답형


// TODO: 1. String class를 상속받아보고 오류를 파악해보자.
class PerfectMember {
    public final void perfectMethod() {
        System.out.println("완벽해!!");
    }
}

// TODO: 2. PerfectMember를 상속받아 perfectMethod를 재정의해보고 오류를 파악해보자.
public class FinalTest {

    // TODO: 3. printGugu 메서드의 오류를 확인하고 대책을 수립하시오.
     public void printGugu(int dan) {
        if (dan > 9) {
            return;
        }
        for (int i = 1; i < 10; i++) {
            System.out.print(dan * i + "\t");
        }
        System.out.println();
         printGugu(dan++);
    }

    public static void main(String[] args) {
        FinalTest ft = new FinalTest();
        ft.printGugu(1);
    }
}
