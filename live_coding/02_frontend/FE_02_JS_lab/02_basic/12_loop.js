// 02_basic/11_loop.js
let nums = [1, 2, 3, 4, 5];
let sum = 0;
for (let i = 0; i < nums.length; i++) {
  sum += nums[i];
}

console.log(sum); // 15

sum = 0;
for (let num of nums) {
  sum += num;
}
console.log(sum); // 15

for (let prop in console) {
  console.log(prop, console[prop]);
}

//TODO: 01. nums에 sum이라는 이름의 프로퍼티를 추가하고, for-in과 for-of로 출력해보자.

//END
