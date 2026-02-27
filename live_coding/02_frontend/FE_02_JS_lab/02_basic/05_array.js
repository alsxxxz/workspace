// 02_basic/05_array.js
// 배열 클래스 생성자 활용
let nums = new Array(1, 2, 3, 4, 5);

// 배열 리터럴
let coffees = ["아메리카노", "카페라떼", "카페모카"]; // length가 3인 배열
console.log(coffees[0], typeof coffees, Array.isArray(coffees)); // 아메리카노 'object' true

console.log(coffees[100]); // undefined

const line2 = ["청소년기", "청년기", ""];


