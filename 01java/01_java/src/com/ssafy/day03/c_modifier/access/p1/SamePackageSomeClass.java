package com.ssafy.day03.c_modifier.access.p1;

public class SamePackageSomeClass extends Parent{
    
	public void useMember() {
        
		 this.publicVar = 10;
	     this.protectVar = 10;
	     this.defaultVar = 10;
	     //this.privVar = 10;//가지고는 잇는데 볼수는 없음
}
	}