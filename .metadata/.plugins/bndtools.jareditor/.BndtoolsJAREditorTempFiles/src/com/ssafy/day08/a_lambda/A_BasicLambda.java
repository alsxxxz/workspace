package com.ssafy.day08.a_lambda;

public class A_BasicLambda {
    // TODO: 다음의 interface가 함수형인지 확인해보세요.
    interface MyFunctional1 {
        void sayHello(String name);
    }

    // END

    @FunctionalInterface
    interface MyFunctional2 {
        double numTo(int num);
    }

    private static void useFunction1(MyFunctional1 function, String name) {
        function.sayHello(name);
    }

    private static void useFunction2(MyFunctional2 function, int num) {
        System.out.println(function.numTo(num));
    }

    public static void main(String[] args) {
        // TODO: useFunction1과 useFunction2를 lambda식을 이용해서 호출해보세요.

        // END
    }

}
