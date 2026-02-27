package com.ssafy.day08.a_lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class E_FunctionalApiTest {
    private List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private Map<String, Integer> map = new HashMap<>(Map.of("hong", 100, "jang", 80, "lim", 95, "kim", 4));

    public static void main(String[] args) {
        E_FunctionalApiTest fpt = new E_FunctionalApiTest();
        // fpt.consumerTest("hong");
        fpt.supplierTest("hong");
        // fpt.functionTest();
        // fpt.operationTest();
        // fpt.predicateTest();
    }



    public void consumerTest(String name) {
        // TODO: list와 map의 각 요소를 출력해보자. list는 단순 출력, map은 이름:점수 형태

        // END

        Optional<Integer> optional = Optional.ofNullable(map.get(name));
        // TODO:map에서 name의 점수를 조회해서 값이 있을 80이상이면 우수, 미만이면 노력필요, 값 없으면 대상없음이라고

        // END
    }

    public void supplierTest(String name) {
        Optional<Integer> optional = Optional.ofNullable(map.get(name));
        // TODO: map에서 name의 성적을 조회하고 만약 score가 null이면 0~100 사이의 값을 설정해보자. (orElseGet)

        // END
    }

    public void functionTest() {
        String name = "hong";
        // TODO: map에 name이 없었다면 score를 1로 추가하고 있었다면 +1 해주세요.(merge)

        // END

        // TODO: map에 jang이 있다면 기존 점수에 100점을 더해서 값을 출력해주세요.(computeIfPresent)

        // END
        System.out.println(map);
    }

    public void operationTest() {
        // TODO: list의 요소를 2배씩으로 대체 하세요. (replaceAll)

        // END
        System.out.println(list);
    }

    public void predicateTest() {
        // TODO: map의 Entry 중 name이 3자 넘고 score가 90점 이상인 것들을 삭제 후 출력해보자.(removeIf)

        // END
        System.out.println(map);
    }

}
