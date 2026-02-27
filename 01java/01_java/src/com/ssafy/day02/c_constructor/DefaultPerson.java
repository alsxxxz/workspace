package com.ssafy.day02.c_constructor;

public class DefaultPerson {
  String name;
  int age;
  boolean isHungry;
  //파라미터 생성자 추가 -> 기본 생성자 out
  DefaultPerson(String n, int a , boolean h){
		name = n;
		age = a;
		isHungry = h;
	}
//시험문제* 생성자 코드가 없으면 컴파일러가 기본 생성자 제공한다.
  // public DefaultPerson() {} -- 생략된 기본 생성자

  ///명시적인 생성자를 만들면 기본 생성자는 추가되지 않는다. 
  public static void main(String[] args) {
    DefaultPerson person = new DefaultPerson();
    person.name = "홍길동";
    person.age = 10;
    person.isHungry = false;
  }
}

