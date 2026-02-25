package com.ssafy.day06.b_enum;

public class EnumOrNot {

    private static final int SALES = 1;
    private static final int PART_TIME_JOB = 2;
    private static final int NORMAL = 3;

    private static final int SPRING = 1;

    private void nonEnume(int grade) {
        if (grade == SALES) {
            System.out.println("영업 실적 반영");
        } else if (grade == PART_TIME_JOB) {
            System.out.println("근무 시간 반영");
        } else if (grade == NORMAL) {
            System.out.println("근로 계약 기준");
        }
    }

    // TODO: nonEnume을 enum을 사용하는 형태로 변경해보자.
     private void useEnum(){}

    // END

    private void enumMethods() {
        Grade[] grades = Grade.values();
        for (Grade g : grades) {
            System.out.printf("name: %s, ordinal: %d\n", g.name(), g.ordinal());
        }
    }

    public static void main(String[] args) {
        EnumOrNot eon = new EnumOrNot();
        eon.nonEnume(SALES);
        eon.nonEnume(SPRING); //논리적 오류

        // TODO: useEnume을 호출하면서 논리적인 오류를 발생시켜보자.

        // END

        eon.enumMethods();
    }
}
