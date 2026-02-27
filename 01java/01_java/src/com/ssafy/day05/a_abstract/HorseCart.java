package com.ssafy.day05.a_abstract;

//public class HorseCart extends Vehicle{
//
//}

public class HorseCart extends Vehicle{
//그 클래스 자체를 abstract로 만들어라.
    public void addFuel() {
        System.out.printf("차종: %s: 연료 주입: %s%n", this.getClass().getSimpleName(), "건초공급");
    }
}