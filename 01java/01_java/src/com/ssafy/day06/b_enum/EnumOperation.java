package com.ssafy.day06.b_enum;

import java.util.Arrays;

public class EnumOperation {
    enum Greeting {
        GOOD_MORNING("좋은 아침"), GOOD_AFTERNOON("오후도 힘내"), GOOD_EVENING("오늘도 수고했어");

        private String message;

        Greeting(String message) {
            this.message = message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    enum Season {
        // TODO: 생성자를 이용해 각 상수에 해당하는 달을 저장해보자.
         SPRING, SUMMER, FALL, WINTER

        // END

        // TODO: 순서에 기반하여 다음 시즌을 반환할 수 있도록 처리해보자.

        // END
    }

    public static void main(String[] args) {

        Greeting g = Greeting.GOOD_AFTERNOON;
        System.out.println(g.getMessage()); // 오후도 힘내

        Season current = Season.SPRING;
        // TODO: current의 속성과 기능을 사용해보자.

        // END
    }
}
