package com.ssafy.day09.b_trycatchfinally;

import java.io.FileInputStream;
import java.io.IOException;

public class C_TryWithResource {

    public static void main(String[] args) {
        C_TryWithResource test = new C_TryWithResource();
        test.useStream();
        test.useStreamNewStye();

    }

    public void useStream() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("abc.txt");
            fileInput.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) { //안쓸순없으나 답답
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void useStreamNewStye() {
        // TODO: useStream을 try~with~resource ->  그래서 이거 나옴
    	try(FileInputStream, fin= new FileInputStream("abc.txt") {
    		fin.read();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}

        // END
    }
}
