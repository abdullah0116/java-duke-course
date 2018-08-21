function addColor() {
  var mainCanvas = document.getElementById("firstCanvas");
  var secondaryCanvas = document.getElementById("secondCanvas");
  mainCanvas.className = "canvasBlue";
  secondaryCanvas.className = "canvasLime";
}

function flipColors() {
  var mainCanvas = document.getElementById("firstCanvas");
  var secondaryCanvas = document.getElementById("secondCanvas");
  mainCanvas.className = "canvasLime";
  secondaryCanvas.className = "canvasBlue";
}
