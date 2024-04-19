document.addEventListener("DOMContentLoaded", () => {
  populateFoodDropdown();
  async function populateFoodDropdown() {
    try {
      //   alert("test");
      const res = await fetch("/food/list");
      const data = await res.json();
      console.log("data", data);
      data.forEach((food) => {
        console.log("food.id:" + food.f_code);
        console.log("food.name:" + food.f_sort);
        console.log("food.name:" + food.f_foodname);

        // $(#food) : id가 food인 요소를 선택하고 해당요소에 내용추가
        // append : 음식목록에서 가져온 옵션요소들을 선택한 요소에 추가
        $("#food").append(
          "<option value=" +
            food.f_code +
            ">" +
            food.f_foodname +
            "</option>"
        );
      });
    } catch (error) {
      console.error("음식정보 오류", error);
    }
  }

  const join_form = document.querySelector("form.join");
  const m_id = join_form.querySelector("input[name='m_id']");
  const m_password = join_form.querySelector(
    "input[name='m_password']"
  );
  const re_password = join_form.querySelector(
    "input[name='re_password']"
  );
  const m_name = join_form.querySelector("input[name='m_name']");
  const f_foodname = join_form.querySelector(
    "select[name='f_foodname']"
  );
  //   const selected_food = document.querySelector(
  //     "input[name='selected_food']"
  //   );
  const btn_join = join_form.querySelector("button");

  const m_idExp = /^[a-zA-Z0-9_]{4,20}$/;
  const m_passwordExp = /^[a-zA-Z0-9!@#$%^&*()]{8,20}$/;

  const idCheck = async (m_id) => {
    try {
      const res = await fetch(`${rootPath}/user/idcheck/${m_id}`);
      const result = await res.text();
      console.log(result);
      return result === "OK";
    } catch (error) {
      alert("오류");
    }
  };
  btn_join.addEventListener("click", async () => {
    if (!m_id.value) {
      alert("ID는 반드시 입력하세요");
      m_id.select();
      return false;
    }
    if (!m_idExp.test(m_id.value)) {
      alert("ID는 영문대소문자,숫자 4~20글자만 가능합니다");
      m_id.select();
      return false;
    }
    if (!(await idCheck(m_id.value))) {
      alert("이미 가입된 ID입니다");
      m_id.select();
      return false;
    }
    if (!m_password.value) {
      alert("비밀번호는 반드시 입력하세요");
      m_password.select();
      return false;
    }
    if (!m_passwordExp.test(m_password.value)) {
      alert("비밀번호는 8자리이상 영문자,숫자,특수문자만 가능합니다");
      m_password.select();
      return false;
    }
    if (!re_password.value) {
      alert("비밀번호확인은 반드시 입력하세요");
      re_password.select();
      return false;
    }
    if (m_password.value !== re_password.value) {
      alert("비밀번호가 일치하지않습니다");
      m_password.select();
      return false;
    }
    if (!m_name.value) {
      alert("사용자 이름을 입력하세요");
      m_name.select();
      return false;
    }

    const selectedOptions = f_foodname.selectedOptions;
    if (selectedOptions.length === 0) {
      alert("음식취향을 선택하세요.");
      return false;
    }

    // 선택된 음식을 hidden input에 설정
    // Array.from() : 배열객체나 반복가능한 객체를 배열로변환 ,
    // 선택된 옵션 요소들을 배열로 변환하여 각각의 값 추출
    const selectedFoods = Array.from(selectedOptions)
      // 배열의 각 요소에 대해 주어진 함수를 호출한 결과를 모아서 새로운 배열을 반환
      .map((option) => option.value)
      // 배열의 모든 요소를 연결하여 하나의 문자열로 만듬
      .join(", ");
    const foodInput = document.querySelector(
      "input[name='selected_food']"
    );
    foodInput.value = selectedFoods;

    join_form.submit();
  });
});

// document.addEventListener("DOMContentLoaded", () => {
//     populateFoodDropdown();

//     // 음식 목록 채우기 함수
//     async function populateFoodDropdown() {
//         try {
//             const res = await fetch(`${rootPath}/food/list`);
//             const data = await res.json();
//             const foodSelect = document.getElementById("food");
//             data.forEach((food) => {
//                 const option = document.createElement("option");
//                 option.value = food.f_code;
//                 option.textContent = food.f_foodname;
//                 foodSelect.appendChild(option);
//             });
//         } catch (error) {
//             console.error("음식정보 오류", error);
//         }
//     }

//     // 회원가입 버튼 클릭 이벤트 핸들러
//     const btnJoin = document.querySelector(".join button");
//     btnJoin.addEventListener("click", () => {
//         const mId = document.querySelector("input[name='m_id']").value;
//         const mPassword = document.querySelector("input[name='m_password']").value;
//         const rePassword = document.querySelector("input[name='re_password']").value;
//         const mName = document.querySelector("input[name='m_name']").value;
//         const fFoodname = document.querySelector("select[name='f_foodname']");
//         const selectedFood = Array.from(fFoodname.selectedOptions)
//             .map((option) => option.value)
//             .join(", ");
//         const mTel = document.querySelector("input[name='m_tel']").value;

//         // 회원가입 폼 submit
//         const joinForm = document.querySelector(".join");
//         joinForm.submit();
//     });
// });
