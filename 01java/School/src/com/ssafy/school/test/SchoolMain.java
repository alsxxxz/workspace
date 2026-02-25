package com.ssafy.school.test;

import com.ssafy.school.*;

public class SchoolMain {
    public static void main(String[] args) {
        ManagerImpl m=ManagerImpl.getInstance();
        m.add(new Student("홍길동",20,202601));
        m.add(new Teacher("임강사",30,"자바"));
        m.add(new Employee("임직원",25,'A'));
        m.printAll();
        System.out.println();
        
        Person p=m.search("임강사");
        p.printAll();
        System.out.println();
        
        p=new Student("일강사", 20, 202602);
        m.update(p);
        for(Person t:m.search()) t.printAll();
        System.out.println();
        
        m.delete("일강사")
        m.printAll();
    }
}