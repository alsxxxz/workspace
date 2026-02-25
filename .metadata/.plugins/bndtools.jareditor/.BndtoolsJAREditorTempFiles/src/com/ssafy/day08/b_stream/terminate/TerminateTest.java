package com.ssafy.day08.b_stream.terminate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.ssafy.day08.b_stream.middle.StreamMiddleTest;

public class TerminateTest {
    private List<String> words = StreamMiddleTest.setUpStream();
    private Map<String, Integer> map = Map.of("hong", 100, "jang", 80, "lim", 95, "kim", 70);

    public static void main(String[] args) throws IOException, URISyntaxException {
        TerminateTest tt = new TerminateTest();
        tt.matchingTest();
        //tt.aggregateTest();
        //tt.reduceTest();
        //tt.findTest();
    }

    private void matchingTest() {
        boolean anyMatch = words.stream()
                .distinct()
                .anyMatch(word -> word.length() >= 5);

        System.out.println("stream의 단어들에는 5글자 이상인 것이 있다? " + anyMatch);

        // TODO: 모든 학생의 점수가 80점 이상인지 확인해보자.

        // END

    }

    public void aggregateTest() {

        IntStream is = new Random().ints(10, 1, 100);
        System.out.println("총합은: " + is.sum());

        words.stream().max(String::compareTo).ifPresent(val -> {
            System.out.println("최대값은: " + val);
        });

        IntStream is2 = new Random().ints(10, 1, 100);
        // TODO: is2에서 짝수 중 최소값을 찾아서 반환하세요. 없다면 -1을 반환한다.

        // END
    }

    public void reduceTest() {
        IntStream is = Arrays.stream(new int[] { 1, 2, 3, 4, 5 });
        int sumByReduce = is.reduce(0, (sum, num) -> sum + num);
        System.out.println(sumByReduce);

        // TODO: 학생들의 시험점수가 짝수이면 그대로, 홀수이면+1점으로 처리해서 총점을 구해보자.

        // END

        class Info {
            int sum, cnt, max = Integer.MIN_VALUE;
            double avg;
            String highest;

            public Info() {
            }

            public Info(int sum, int cnt, int max, double avg, String highest) {
                this.sum = sum;
                this.cnt = cnt;
                this.max = max;
                this.highest = highest;
                this.avg = avg;
            }

            @Override
            public String toString() {
                return "Info [sum=" + sum + ", cnt=" + cnt + ", max=" + max + ", avg=" + avg + ", highest=" + highest + "]";
            }

        }

        // TODO: Info를 이용하여 총점, 평균, 최고득점자, 최고점을 반환해보자.

        // END
    }

    private void findTest() {
        String[] strs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".split("");
        Stream<String> stream = Arrays.stream(strs);
        Optional<String> sequentialFirst = stream.findAny();
        System.out.println(sequentialFirst.orElse("none"));

        Optional<String> parallelFirst = Arrays.stream(strs).parallel().findAny();
        System.out.println(parallelFirst.orElse("none"));

    }
}
