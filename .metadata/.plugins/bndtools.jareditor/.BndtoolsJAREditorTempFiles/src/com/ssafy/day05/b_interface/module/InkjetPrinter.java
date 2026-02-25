package com.ssafy.day05.b_interface.module;

public class InkjetPrinter implements Printer {

    @Override
    public void print(String fileName) {
        System.out.println("Inkjet Printer로 프린트 한다.");
    }

}
