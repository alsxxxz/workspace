let timeout = document.getElementById("timeout");

let timestame = document.getElementById("timestamp");
let latitude = document.getElementById("latitude");
let longitude = document.getElementById("longitude");
let accuracy = document.getElementById("accuracy");
let errorMessage = document.getElementById("errorMessage");
let getLocationB = document.getElementById("getLocation");

// 화면 새로 고침
const refreshFields = () => {
  let tds = document.querySelectorAll("#infoTable td input");
  for (let i = 0; i < tds.length; i++) {
    tds[i].value = "";
  }
};

let geolocation = navigator.geolocation;

getLocationB.addEventListener("click", function () {
  refreshFields();

  let options = {
    enableHighAccuracy: true,
    timeout: timeout.value * 1000,
    maximumAge: 10 * 1000, // 10초 이내에 가져온 정보를 사용
  };

  //TODO: 01. geolocation을 이용해서 위치 정보를 조회하세요. success, error callback 이용

  //END
});

const success = (position) => {
  //TODO: 02. 성공시 전달되는 position 객체를 받아서 화면에 출력하세요.

  //END
};

const error = (positionError) => {
  switch (positionError.code) {
    case 1:
      errorMessage.value = "사용자가 권한 부여를 거부하였습니다.";
      break;
    case 2:
      errorMessage.value = "내부 오류로 위치 정보를 가져오지 못하였습니다.";
      break;
    case 3:
      errorMessage.value = "Timeout 초과로 정보를 가져오지 못하였습니다.";
  }
};
