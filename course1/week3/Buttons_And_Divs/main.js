function male() {
  alert('Your gender has been updated to Male.');
}

function female() {
  alert('Your gender has been updated to Female.');
}

//var conformationAnswer = confirm('confirm this');

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
