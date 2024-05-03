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

    // const selectedFood = foodItems[index].innerText;
    // const inputBoxes = document.querySelectorAll(".selectfood input");
    // inputBoxes[0].value = selectedFood; // 첫 번째 input 상자에 선택된 음식 표시

    const selectedCategory = foodItems[index].innerText;

    // 서버로 선택된 음식 카테고리를 요청합니다.
    fetch(
      "${rootPath}/random/getCategory?category=" +
        encodeURIComponent(selectedCategory)
    )
      .then((response) => response.text())
      .then((data) => {
        const selectedFoodList = data.split(", "); // 서버에서 받은 음식 리스트를 배열로 변환합니다.
        const inputBoxes = document.querySelectorAll(
          ".selectfood input"
        );
        inputBoxes[1].value = selectedFoodList.join(", "); // 두 번째 input 상자에 선택된 음식 리스트 표시
      })
      .catch((error) => console.error("Error:", error));
  }

  document
    .getElementById("randomButton")
    .addEventListener("click", spinRoulette);
});
