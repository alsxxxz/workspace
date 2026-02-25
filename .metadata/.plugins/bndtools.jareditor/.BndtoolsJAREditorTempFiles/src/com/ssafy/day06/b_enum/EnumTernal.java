package com.ssafy.day06.b_enum;

import java.util.Arrays;

public class EnumTernal {

    public enum TernalType{
        dummy(new int [][] {}),
        A(new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}),
        B(new int [][] {{-1, 0}, {1, 0}}),
        C(new int [][] {{0, -1}, {0, 1}}),
        D(new int [][] {{-1, 0}, {0, -1}}),
        E(new int [][] {{1, 0}, {0, -1}}),
        F(new int [][] {{-1, 0}, {0, 1}}),
        G(new int [][] {{1, 0}, {0, 1}});

        int [][] direction;

        TernalType(int [][] direction) {
            this.direction = direction;
        }

        public static TernalType of(int ordinal) {
            return TernalType.values()[ordinal];
        }

    }
    @Deprecated
    public static void main(String[] args) {
        TernalType t = TernalType.of(1);
        TernalType type1 = TernalType.A;
        TernalType type2 = TernalType.of(1);
        System.out.println(type1 == type2); // true

        System.out.println("Ternal Type: " + t);
        System.out.println(Arrays.deepToString(t.direction)); // [[-1, 0], [1, 0], [0, -1], [0, 1]]
    }
}
