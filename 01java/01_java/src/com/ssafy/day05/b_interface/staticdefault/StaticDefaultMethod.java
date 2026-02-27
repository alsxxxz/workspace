package com.ssafy.day05.b_interface.staticdefault;

import java.util.Arrays;

interface Aircon {
    void makeCool();

    // TODO: 2.(곰팡이이슈)건조기능을 추가해보자.
    default void dry() {
    	System.out.println("건조 기능이 필요합니다.");
    }
    // END

    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
    static void descrption() {
    	System.out.println("");
    }
    // END


}

class OldisButGoodies1 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// TODO: 1. 무풍 에어컨을 구현해보자.
class NowindAirCon implements Aircon{
	@Override
	public void makeCool() {
		System.out.println("차가운바람없이 시원하게");
		//+
		dry();
	}
	@Override
	public void dry() {
		System.out.println("잘 말려줘");
	}
}
// END

public class StaticDefaultMethod {
    public static void main(String[] args) {
        Aircon[] aircons = { 
        		new OldisButGoodies1(), 
        		new OldisButGoodies2(),
        		//+
        		new NowindAirCon()};
        for (Aircon aircon : aircons) {
            aircon.makeCool();
        }
        Aircon.descrption();
    }
}
