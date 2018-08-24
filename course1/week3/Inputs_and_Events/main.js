function colorChangerBlue() {
  var canvas = document.getElementById('mainCanvas');
  canvas.className = "colorChangerBlue";
}

function chooseColor() {
  var canvas = document.getElementById('mainCanvas');
  var color = document.getElementById('colorPicker');
  canvas.style.backgroundColor = color;
}
