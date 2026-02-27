package com.ssafy.day06.a_generic.box;

import com.ssafy.day03.a_inheritance.person.Person;
import com.ssafy.day03.a_inheritance.person.SpiderMan;

public class GenericAttention<I> {

    public void useRawType() {
        // TODO: 다음에서 발생하는 warning을 제거해보자.
        GenericBox box = new GenericBox();

        // END
    }

    public void confusing() {

        GenericBox<Person> pbox = new GenericBox<>();
        // TODO: pbox에 담을 수 있는 객체를 담아보자.

        // END

        // TODO: pbox를 다른 타입을 담는 박스로 대체해보자.

        // END
    }

    public void cantUseGeneric() {
        //I i = new I();//Cannot instantiate the type I

        GenericBox<SpiderMan> obj = new GenericBox<>();

        // compile error : Type Object cannot be safely cast to GenericBox<String>
        //if(obj instanceof GenericBox<String>) {  }

        if (obj instanceof GenericBox gb) {
            gb.setSome("Hello"); // 타입에 안전하지 않음
            System.out.println("맞지만 타입에 안전하지 않음: " + gb.getSome());
        }

        if (obj instanceof GenericBox<?> gb) {
            // gb.setSome("Hello"); // compile error
            System.out.println("이것이 최선: 타입이 훼손될 일은 없다!");
        }
    }

    public void genericArray() {
        // Generic 타입으로는 배열 생성 불가
        // GenericBox<String> [] boxes1 = new GenericBox<>[3]; // compile error

        // row 타입 객체의 형 변환 주의
        GenericBox<Person>[] boxes3 = (GenericBox<Person>[]) new GenericBox[3];
        boxes3[0] = new GenericBox<Person>();
        // TODO: 위코드가 의미 있게 된다면 어떤 불상사가 발생하는지 생각해보자.

        // END
    }

    public static void main(String[] args) {
        GenericAttention<Integer> ga = new GenericAttention<>();
        //ga.cantUseGeneric();
        ga.genericArray();
    }
}
