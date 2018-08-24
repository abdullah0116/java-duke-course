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

function drawSquare() {
  // instance variable of the canvas
  var canvas = document.getElementById("mainCanvas");
  // variable for the context of the canvas variable
  var canvasCTX = canvas.getContext("2d");

  // instance variable of the slider
  var slider = document.getElementById("squareSize");
  // gets the value of the slider number
  var size = slider.value;

  canvasCTX.clearRect(0,0, canvas.width, canvas.height)

  // sets the color of context to purple
  canvasCTX.fillStyle = "purple";
  //
  canvasCTX.fillRect(0,0, size, size);
}
