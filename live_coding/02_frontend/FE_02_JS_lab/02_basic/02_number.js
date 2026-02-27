// 02_basic/02_number.js
const nums = [3, 3.14, 10 / 0, "string" / 2];

nums.forEach((num) => {
  console.log(num, typeof num);
});

// 값의 상태가 어떤지 판단하는 함수를 만들어보자.
function judge(x) {
  if (isFinite(x)) {
    return "연산 가능";
  } else if (isNaN(x)) {
    throw `숫자 아님(${x})`;
  } else {
    throw `무한대(${x})`;
  }
}

nums.forEach((num) => {
  try {
    judge(num);
  } catch (e) {
    console.log("오류 발생: ", e);
  }
});

// number와 Number
const primitiveNum = 123;
const objectNum = new Number(123);
console.log(primitiveNum, typeof primitiveNum, objectNum, typeof objectNum); // 123 'number' [Number: 123] 'object'
console.log(`기본형이지만 참조형의 메서드 사용: ${primitiveNum.toFixed(2)}`); // 기본형이지만 참조형의 메서드 사용: 123.00

// string --> number로의 형 변환
console.log(Number.parseInt("123cm", 10));
console.log(Number.parseInt("123a1", 10));
console.log(Number.parseInt("q1231", 10));
