package com.ssafy.day06.c_annotation;

import java.lang.reflect.Field;

public class ValidationChecker {
    public static StringBuilder validationCheck(Object obj)
            throws IllegalArgumentException, IllegalAccessException {
        StringBuilder output = new StringBuilder();
        // TODO: 02. obj의 field 중 EMAIL, PASS, POSITIVE_NUM에 대한 validation을 처리해서 결과를 output에 담아서 반환하시오.

        // END
        return output;
    }
}

// TODO: 01. email, password, salary가 지정된 형식을 만족하는지 점검하는 annotation을 개발해보세요.
//  annotation 정보는 runtime까지 유지되며 field에 적용될 수 있다.
//  annotation은 EMAIL, PASS, POSITIVE_NUM enum 상수를 갖는 Type 속성을 가진다.
