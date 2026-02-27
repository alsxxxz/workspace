// 03_function/06_constructor.js
let hong = {
  name: "홍길동",
  age: 30,
  info: function () {
    return this.name + ", " + this.age;
  },
};

let Person = function (name, age) {
  this.name = name;
  this.age = age;
  this.info = function () {
    return this.name + " : " + this.age;
  };
};
let jang = new Person("장길산", 20);
console.log(jang.info());
let lim = new Person("임꺽정", 25);
console.log(lim.info());

class Person2 {
  constructor(name, age) {
    // 생성자
    this.name = name; // 멤버 변수 선언
    this.age = age;
  }
  getInfo() {
    // 메서드 선언
    return this.name + " : " + this.age;
  }
}

let kang = new Person2("강감찬", 35);
console.log(kang.getInfo());

// class literal 형태로 작성
let Student = class extends Person2 {
  // 상속 처리
  constructor(name, age, ssn) {
    super(name, age); // super로 조상 생성자 호출
    this.ssn = ssn;
  }
  getInfo() {
    return super.getInfo() + " : " + this.ssn;
  }
};
let lee = new Student("이순신", 45, "123");
console.log(lee.getInfo());
