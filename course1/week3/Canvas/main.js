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

  function addText() {
    // Main Canvas
    var mainCanvas = document.getElementById("firstCanvas");
    var mainCTX = mainCanvas.getContext("2d");
    mainCTX.fillStyle = "lightpink";
    mainCTX.font = "22px Arial";
    mainCTX.fillText("This is the main Canvas.",25,50);

    // Secondary Canvas
    var secondaryCanvas = document.getElementById("secondCanvas");
    var secondaryCTX = secondaryCanvas.getContext("2d");
    secondaryCTX.fillStyle = "black";
    secondaryCTX.font = "22px Arial";
    secondaryCTX.fillText("Thi is the second Canvas.", 25, 50);
  }

  function addRect() {
    // Main Canvas
    var mainCanvas = document.getElementById("firstCanvas");
    var mainCTX = mainCanvas.getContext("2d");
    mainCTX .fillStyle = "purple";
    mainCTX.fillRect(30, 50, 40, 40);

    // Second Canvas
    var secondaryCanvas = document.getElementById("secondCanvas");
    var mainCTX = secondaryCanvas.getContext("2d");
    mainCTX.fillStyle = "purple";
    mainCTX.fillRect(175, 50, 40, 40);
  }
