package com.ssafy.day03.c_modifier.last;
//선언시 초기화 하지 않고 생성자에서 초기화 하는 final변수

public class BlankFinalTest {
    private final String bloodType;//초기화 되지 않았다는 경고가뜸 //선언만
    
    //p30
    public BlankFinalTest(String bloodType) { //여기서 초기화?? 
    	this.bloodType = bloodType;
    }
    // TODO: 위 코드가 정상적으로 컴파일되도록 처리하고 객체를 만들어보자.

    // END
}
