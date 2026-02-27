// 02_basic/09_compare.js
const vals1 = [0, 1, 2];
const vals2 = [false, true, "2"];
for (let i = 0; i < vals1.length; i++) {
  console.log(`${vals1[i]} vs ${vals2[i]} : ${vals1[i] == vals2[i]}, ${vals1[i] === vals2[i]}`);
}

// 문자열과 다른 타입의 비교
console.log("2" == 2, "-1" > false, "-1" < true); // true, false, true
console.log(null > -1, null < "3"); // true, true

console.log(new Date(2000, 1, 1) < new Date());
console.log(new Date(2000, 1, 1) < 9);
