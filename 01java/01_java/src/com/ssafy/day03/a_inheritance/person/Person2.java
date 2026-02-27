package com.ssafy.day03.a_inheritance.person;

//class Person2 extends Person {
//	Spider spider = new Spider();
//	boolean isSpider;
//	//다중속성만 가능한 JAVA이기 때문에
//	//Person은 상속 받고,
//	//Spider은 객체만 포함하며 멤버 변수로 가ㅣㄴ다.
//	
//	@Override
//	void jump() {
//		spider.jump(); //Spider 객체의 jump호출
//	}
//}

//    String name;
//    Person2(String name) {
//        this.name = name;
//    }
//}
class Person2 extends Person {
	String name;
	Person2(String name) {
		this.name = name;
	}
}

