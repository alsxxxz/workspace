package com.ssafy.day03.d_sealed;
//Sealed class : 봉인된 클래스로 내가 관리하는 특정 클래스에게만 상속 사능



// TODO: SealedStudyGroup을 sealed로 선언하고 Algo, Java, CS에게 상속을 허락해보세요.
 sealed class SealedStudyGroup permits Algo, CS, JAVA {
    public void study() {
        System.out.println("공부 공부 공부!!");
    }
}
// END
 
 
 
 
// TODO: Algo, Java, CS 클래스를 각각 final, sealed, non-sealed 형태로 작성해보세요.
final class Algo extends SealedStudyGroup{}
sealed class Java extends SealedStudyGroup permits Spring{}
non-sealed class CS extends SealedStudyGroup{}
// END



// TODO: Java와 CS를 각각 상속받는 Spring과 Network를 구성해보세요.
final class Spring extends Java{}
class Network extends CS{}
// END



public class SealedTest {

    public static void main(String[] args) {
        SealedStudyGroup group = new SealedStudyGroup();
        group.study();

    }
}
