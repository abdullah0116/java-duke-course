function colorChangerBlue() {
  var canvas = document.getElementById('mainCanvas');
  canvas.className = "colorChangerBlue";
}

function colorInput() {
  var canvas = document.getElementById("mainCanvas");
  var inputColor = document.getElementById("colorPicker");
  var color = inputColor.value;
  canvas.style.backgroundColor = color;


}
