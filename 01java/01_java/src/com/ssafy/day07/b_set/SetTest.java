package com.ssafy.day07.b_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    Set<Object> hset = new HashSet<Object>();

    private void addMethod() {
        hset.add(Integer.valueOf(1));
        hset.add("Hello");
        hset.add("Hello"); // 동일한 데이터 추가 확인
        hset.add(1); // 기본형은 wrapper를 통해 추가
        // TODO: SmartPhone 타입의 객체를 추가해보자.

        // END
        System.out.println("데이터 추가 결과: " + hset);
    }

    private void retrieveMethod() {
        // TODO:hset에서 필요한 정보를 조회해보자.

        // END
    }

    private void removeMethod() {
        // TODO:hset에서 hello를 삭제해보자.

        // END
        System.out.println("데이터 삭제 결과: " + hset);
    }

    public static void main(String[] args) {
        SetTest test = new SetTest();
        test.addMethod();
        test.retrieveMethod();
        test.removeMethod();
    }
}
