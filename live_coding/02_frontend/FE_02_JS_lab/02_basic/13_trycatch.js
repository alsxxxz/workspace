// 02_basic/13_trycatch.js
try {
  console.log(notExistVar);
} catch (error) {
  console.log("catch block:", error.name, "-", error.message);
} finally {
  console.log("finally block: this runs no matter what");
}

const arr = [1, 2, 3];
try {
  for (let i = 0; i < 4; i++) {
    //TODO: 01. i가 arr.length보다 크거나 같으면 예외를 발생시켜보자.

    //END
    console.log(arr[i]);
  }
} catch (error) {
  console.log("catch block:", error, error.name, "-", error.message);
}
