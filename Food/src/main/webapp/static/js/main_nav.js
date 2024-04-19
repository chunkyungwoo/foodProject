// const NAV_INDEX = {
//   랜덤돌리기: { url: "/random" },
//   로그인: { url: "/user/login" },
//   회원가입: { url: "/user/join" },
// };

document.addEventListener("DOMContentLoaded", () => {
  const mainNav = document.querySelector("nav.main");
  const navItem = mainNav.querySelector("li");

  mainNav.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "LI") {
      navItem.forEach((item) => {
        item.classList.remove("active");
      });
      target.classList.add("active");

      const className = target.classList[0];
      //   const url = NAV_INDEX[className].url;

      //   document.location.href = `${rootPath}${url}`;
    }
  });
});
