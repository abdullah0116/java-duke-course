function male() {
  alert('Your gender has been updated to Male.');
}

function female() {
  alert('Your gender has been updated to Female.');
}

function conformationText() {
  var confirmSTAT = confirm('Is the data you have selected correct?');
  var response;

  if (confirmSTAT == true) {
    response = "you have confirmed the data";
  } else {
    response = "You have not confirmed the data";
  }

  document.getElementById("confirmedData").innerHTML = response;
}

function swapColors() {
  var maleData = document.getElementById("male");
  maleData.className = "malePurp";

  var femaleData = document.getElementById("female");
  femaleData.className = "femaleHP";

  var confirmData = document.getElementById("confirmation");
  confirmData.className = "confirmBlue";

  var changeCoData = document.getElementById("changeColors");
  changeCoData.className = "changeCoORG";
}

function flipText() {
  var maleData = document.getElementById("male");
  maleData.value = "female";

  var femaleData = document.getElementById("female");
  femaleData.value = "male";
}
