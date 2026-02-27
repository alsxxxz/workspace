// 02_basic/07_object_define.js
const user = {
  name: "John",
  age: 30,
  introduce: function () {
    console.log(`이름: ${this.name}, 나이: ${user.age}`);
  },
  "user-address": "seoul", // 이게 변수 이름으로 사용될 수 있을까?
};

console.log(user.name, user["user-address"]);

//TODO: 01. html, css, javascript 세 과목의 점수를 저장하는 scores라는 객체를 만들어보자.
// 총점을 구해서 total이라는 속성으로 추가해보자.
// java 점수가 미등록이라면 100점으로 추가해보자.
// html 점수를 삭제해보자.

//END
