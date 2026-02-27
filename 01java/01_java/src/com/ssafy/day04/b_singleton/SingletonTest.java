package com.ssafy.day04.b_singleton;

//객체 생성 제어와 Singleton 디자인 패턴
//여러개의 객체가 필요없는 경우 -> stateless, 객체를 계속 생성, 삭제하는데 많은 비용이 들어서 재사용이 유리한 경우.
//싱글톤의 출발점: 외부에서 객체를 만들수 없어야한다.

class SingletonClass {
  // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
	private SingletonClass() {}
	
	private SingletonClass sc = new SingletonClass();
	
	
	public static SingletonClass getInstance() {
		return sc;
	}
  // END
  public void sayHello() {
    System.out.println("Hello");
  }

}

public class SingletonTest {
  public static void main(String[] args) {
    // TODO:SingletonClass를 사용해보세요.
	  SingletonClass sc1 = new SingletonClass.getInstance();
	  SingletonClass sc2 = new SingletonClass.getInstance();
	  System.out.println(sc1 == sc2);
	  
	  
	  // END
  }
}
