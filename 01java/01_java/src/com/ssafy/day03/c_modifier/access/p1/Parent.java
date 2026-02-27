package com.ssafy.day03.c_modifier.access.p1;

public class Parent {
    public int publicVar;
    protected int protectVar;
    int defaultVar;
    @SuppressWarnings("unused")
    private int privVar;

    public void useMember() {
        this.publicVar = 10;
        this.protectVar = 10;
        this.defaultVar = 10;
        this.privVar = 10; //가지고는 있으나 쓸 수 없는 이유는 private.볼 수는 없다.
        //private int privVar;
    }//같은 패키지에 있는 다른 class에서 써보기
}
