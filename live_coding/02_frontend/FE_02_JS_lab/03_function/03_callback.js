// 03_function/07_callback.js
let arr = ["alpha", "zz", "dream is come true", "hi"];

arr.sort();
console.log(arr);

arr.sort((first, second) => first.length - second.length);
console.log(arr);

//TODO: 01. arr를 알파벳 내림차순으로 정렬시켜보자.

//END

//TODO: 02. java의 표준 functional interface의 개념에 해당하는 callback들을 작성해보자.
// js에서는 함수의 형태가 java처럼 정확히 정해져 있지는 않다. 유연하게 사용하자.
// Consumer (forEach) - 배열의 요소를 input으로 받고 반환은 없음: 배열의 요소를 출력하자.
// Supplier (Array.from) - 파라미터를 안받고 랜덤하게 값 공급: 랜덤 정수로 구성된 5개짜리 배열을 만들자.
// Function (map) - 배열의 요소를 입력으로 받고 다른 타입으로 출력함: arr 요소들의 길이로 구성된 배열을 만들자.
// Operator (reduce) - 배열의 요소를 입력으로 받고 같은 타입으로 출력함. arr에서 가장 긴 문자열은?
// Predicate (filter) - 배열의 요소를 입력으로 받고 boolean을 반환함: 3글자 이상인 문자열의 배열은?

//END

//TODO: 03. 내이름을_부를땐_이렇게_해주세요라는 함수를 만들고 어떻게 부를지를 callback으로 처리해주자.

//END
