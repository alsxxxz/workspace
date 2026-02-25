package com.ssafy.day01.a_basic;

@SuppressWarnings(value = "unused")
public class Basic_08 {
    public static void main(String[] args) {
        switchSimple();
        switchExpression();

        // switchString();
    }

    private static void switchSimple() {
        int num = 3;

        switch (num) {
            case 1:
                System.out.println(num);
            case 2:
                System.out.println(num);
            case 3:
                System.out.println(num);
            case 4:
                System.out.println(num);
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println(num);
        }
    }

    private static void switchCalendar() {
        int month = 3;
        int day = -1;
        switch (month) {
            case 2:
                day = 29;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            default:
                day = 31;
        }

    }

    private static void switchExpression() {
        System.out.println("달력 출력 1");
        int month = 2;
        // TODO: 위 switchCalendar을 switchExpression 형태로 변경해보자.
         int day=-1;

        // END
        System.out.printf("%d월은 %d까지 있다.%n", month, day);

    }

    /**
     * 문자열을 활용한 switch case 문장 주의 사항
     */
    private static void switchString() {
        String arg = null;
        // arg = new String("A");
        switch (arg) {
            case "A":
                System.out.println("A");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
