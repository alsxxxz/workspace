package com.ssafy.day05.a_abstract;

public abstract class Vehicle {
	private int curX, CurY;
	public void reportPosition() {
		System.out.printf("차종: %s: 현재 위치: (%d, %d)%n", this.getClass().getSimpleName());
	}
	
	//모든 차량은 addFuel을 가져야한다고 abstract로 정의하는 것. 
//	자식클래스에 강제하는 것,.
	public abstract void addFuel() ;
}
