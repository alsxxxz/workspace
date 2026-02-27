package com.ssafy.day05.b_interface.relation;

// TODO: HandPhone를 충전 가능하게 설정하시오.
public class HandPhone extends Phone implements Chargeable{
	public void charge() {
		System.out.println("핸드폰충전");
	}
}

// END
