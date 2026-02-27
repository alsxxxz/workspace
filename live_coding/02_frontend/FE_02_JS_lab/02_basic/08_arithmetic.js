// 02_basic/07_arithmetic.js
console.log(1 + 2);
console.log(1 / 2); // 정수, 실수의 구분이 없다.

// TODO: 다음 연산 결과를 예측하고 결과를 확인하시오.(숫자와 문자열의 연산)
// + 연산
console.log("number의 + 연산: ", 1 + "a", "a" + 1, 1 + "10", "10" + 1);

// + 이외의 연산
console.log("number의 +이외의 연산: ", "a" - 1, "10" - 1, "10" / 3);

// TODO: 다음 연산 결과를 예측하고 결과를 확인하시오.(숫자와 불리언의 연산)
console.log("boolean과의 연산: ", 1 + true, 1 + false, 1 - true, 1 - false);
console.log("null과의 연산: ", 1 + null, 1 - null);

// 객체의 toString과 valueOf 메서드
console.log("Date의 toString: ", new Date(2001, 1, 1).toString()); // Wed Feb 01 2001 00:00:00 GMT+0900 (대한민국 표준시)
console.log("Date의 valueOf: ", new Date(2001, 1, 1).valueOf()); // 981158400000

// TODO: 다음 연산 결과를 예측하고 결과를 확인하시오.(숫자와 참조형의 연산)
// 객체의 + 연산
console.log(new Date(2001, 1, 1) + 1);

// 객체의 + 이외 연산
console.log(new Date(2001, 1, 1) - 1);
