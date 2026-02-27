package com.ssafy.day06.c_annotation;

public class UserInfoTest {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        UserInfo[] infos = {
                new UserInfo("hong gil dong", "abcdef.net", "@#$", -10000000),
                new UserInfo("hong gil dong", "abc@def.net", "@#$", -10000000),
                new UserInfo("hong gil dong", "ab@cdef.net", "123456@#$", -10000000),
                new UserInfo("hong gil dong", "ab@cdef.net", "123456@#$", 10000000)
        };
        for (UserInfo info : infos) {
            System.out.println(info);
            // TODO: 04. info의 validation 점검 결과를 확인하고 출력하세요.

            // END
        }
    }
}
