window.addEventListener("scroll", function () {
  let favTexts = document.querySelectorAll(".fav-text");
  let value = scrollY;
  console.log(value);
  if (value < 200) {
    favTexts.forEach((item) => {
      item.style.animation = "slide-forward 2s ease-in-out";
    });
  }
  else if (value >= 200) {
    favTexts.forEach((item) => {
      item.style.animation = "slide-backward 2s ease-in-out forwards";
    });
  }
});