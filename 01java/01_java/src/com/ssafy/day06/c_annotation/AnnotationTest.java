package com.ssafy.day06.c_annotation;
import java.util.Arrays;

import com.ssafy.day03.a_inheritance.person.Person;
import com.ssafy.day06.a_generic.box.GenericBox;

public class AnnotationTest {

    private String[] blackList;

    // TODO: 다음의 생성자를 deprecated 시켜보자.
    public AnnotationTest() {
        blackList = new String[] { "hello", "java", "world" };
    }

    // END

    public AnnotationTest(String[] list) {
        this.blackList = list;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        AnnotationTest at = new AnnotationTest();
        Person p = at.createInstance(Person.class);
        System.out.println(p);
    }


    // TODO: 다음 메서드에서 발생하는 warning들을 억눌러보자.
    public <T> T createInstance(Class<T> clazz) throws Exception {
        GenericBox box = new GenericBox();
        
        Object obj = clazz.getDeclaredConstructors()[0].newInstance();
        return (T)obj;
    }

    // END

    // TODO: 다음 메서드가 잘 재정의되었는지 확인해보자.
    public String toString() {
        return "black list: " + Arrays.toString(blackList);

    // END

}
