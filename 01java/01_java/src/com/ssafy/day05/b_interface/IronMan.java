package com.ssafy.day05.b_interface;

public class IronMan implements Heroable{
	@Override
	public int fire(){
		System.out.println("빠양");
		return 0;
	}
	public void ChangeShape() {
		System.out.println("짜잔");
		
	}
	public void upgrade() {
		System.out.println("좋아짐");
		
	}
}
