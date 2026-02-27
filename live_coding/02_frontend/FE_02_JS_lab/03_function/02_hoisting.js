// 03_function/02_hoisting.js
console.log("num1 : " + num1);
//console.log(num2);
console.log("square : " + square);

var num1 = 10;
console.log("num1 : " + num1);
let num2 = 20;
console.log("num2 : " + num2);

console.log("square 호출 : " + square(10));

var square = 0;
function square(x) {
  return x * x;
}

console.log(square);

//console.log(square(4));

var square2 = function () {
  return x * x;
};

console.log("square2 : " + square2);
