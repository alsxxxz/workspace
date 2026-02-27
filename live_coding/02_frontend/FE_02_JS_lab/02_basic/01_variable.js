// 02_basic/01_variable.js
function test() {
  if (true) {
    globalData = "이런 변수 선언은 정말 아니다.";
    var varData = "옛날에는 이런거 썼데.";
    let letData = "이젠 let이지.";
    const constData = "상수";
    //constData = 30;                // const 변수 재할당 불가

    // TODO: globalData, varData, letData, constData 중 호출 가능한 변수와 호출 불가능한 변수를 확인하시오.

    // END
  }// if scope
  // TODO: globalData, varData, letData, constData 중 호출 가능한 변수와 호출 불가능한 변수를 확인하시오.

  // END
}// test method scope
test();
// TODO: globalData, varData, letData, constData 중 호출 가능한 변수와 호출 불가능한 변수를 확인하시오.

// END
