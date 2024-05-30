document.addEventListener("DOMContentLoaded", function () {
  const arrow = document.querySelector(".arrow");
  let isSpinning = false;

  function spinRoulette() {
    if (!isSpinning) {
      isSpinning = true;
      arrow.style.transition = "transform 8s ease-in-out";
      arrow.style.transform = `rotate(3600deg) translate(-50%, -50%)`; // 중앙으로 이동
      setTimeout(() => {
        stopArrow();
      }, 8000);
    }
  }
  const data2 = [];
  function stopArrow() {
    const stopDeg = Math.floor(Math.random() * 360); // 랜덤한 각도를 설정합니다.
    arrow.style.transition = "transform 2s ease-in-out";
    arrow.style.transform = `rotate(${stopDeg}deg) translate(-50%, -50%)`;
    setTimeout(() => {
      isSpinning = false;
      showSelectedFood(stopDeg);
    }, 2000);
  }

  function showSelectedFood(angle) {
    const foodList = document.querySelector(".food-list");
    const foodItems = foodList.querySelectorAll("li");
    const numItems = foodItems.length;
    const index = Math.floor((angle % 360) / (360 / numItems));
    alert("선택된 음식: " + foodItems[index].innerText);

    const selectedFood = foodItems[index].innerText;
    const inputBox1 = document.querySelector(
      ".selectfood input[readonly]"
    );
    inputBox1.value = selectedFood; // 첫 번째 input 상자에 선택된 음식 표시

    const selectedCategory = foodItems[index].innerText;

    // 서버로 선택된 음식 카테고리를 요청합니다.
    fetch(`${rootPath}/random/getCategory/${selectedCategory}`)
      .then((response) => response.json())
      .then((data) => {
        const inputBox2 = document.querySelector("#random");
        data.map((data) => {
          // console.log(data.f_foodname);
          data2.push(data.f_foodname);
        });
        // console.log(data2);
        // const selectedFoodList = data.split(", "); // 서버에서 받은 음식 리스트를 배열로 변환합니다.
        // inputBox2.value = data.f_foodname; // 두 번째 input 상자에 선택된 음식 리스트 표시
      })
      .catch((error) => console.error("Error:", error));
  }

  function changeData() {
    // 데이터를 랜덤하게 섞기 위해 배열을 복제합니다.
    var shuffledData = data2.slice();
    // Fisher-Yates 알고리즘을 사용하여 배열을 섞습니다.
    for (var i = shuffledData.length - 1; i > 0; i--) {
      var j = Math.floor(Math.random() * (i + 1));
      var temp = shuffledData[i];
      shuffledData[i] = shuffledData[j];
      shuffledData[j] = temp;
    }
    // 섞인 배열 중 하나의 요소를 반환합니다.
    return shuffledData[
      Math.floor(Math.random() * shuffledData.length)
    ];
  }

  // 매초마다 데이터를 바꿔주는 함수
  function displayChangingData() {
    var timeInterval = 100; // 0.1초 간격으로 데이터를 변경합니다.
    var totalTime = 3000; // 3초 후에 멈춥니다.
    var elapsedTime = 0;

    // 매 timeInterval마다 changeData 함수를 호출하여 값을 바꿉니다.
    var changingInterval = setInterval(function () {
      var newData = changeData();
      document.querySelector("#random").value = newData; // 요소에 새로운 데이터를 출력합니다.
      console.log(newData);
      elapsedTime += timeInterval;
      if (elapsedTime >= totalTime) {
        clearInterval(changingInterval); // 일정 시간이 지나면 setInterval을 멈춥니다.
        alert("이거 ? 다른거 ?" + newData);
      }
    }, timeInterval);
  }
  const btn_random = document.querySelector("#selectButton");
  btn_random.addEventListener("click", () => {
    console.log(data2);
    displayChangingData();
  });

  document
    .getElementById("randomButton")
    .addEventListener("click", spinRoulette);
});
