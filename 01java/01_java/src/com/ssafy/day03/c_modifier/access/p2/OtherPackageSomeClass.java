package com.ssafy.day03.c_modifier.access.p2;

import com.ssafy.day03.c_modifier.access.p1.Parent;

public class OtherPackageSomeClass extends Parent{
    
	public void useMember() {
        
		 this.publicVar = 10;
	     this.protectVar = 10;
	     this.defaultVar = 10;
	     this.privVar = 10;//가지고는 잇는데 볼수는 없음
    }
// END
}