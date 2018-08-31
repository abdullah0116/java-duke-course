var redImage;
var blueImage;
var cleanImage;
var leftCanvas;
var rightCanvas;

function upload() {
  leftCanvas = document.getElementById("leftCanvas");
  var rawImage = document.getElementById("imageUpload");
  blueImage = new SimpleImage(rawImage);
  cleanImage = new SimpleImage(rawImage);
  redImage = new SimpleImage(rawImage);
  cleanImage.drawTo(leftCanvas);
}

function makeRed() {
  rightCanvas = document.getElementById("rightCanvas");
  for (var pixel of redImage.values()) {
    var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    if (average < 128) {
      var newRed = average * 2;
      pixel.setRed(newRed);
      pixel.setGreen(0);
      pixel.setBlue(0);
    } else {
      pixel.setRed(0);
      var newGreen = (average * 2) - 255;
      pixel.setGreen(newGreen);
      var newBlue = (average * 2) - 255;
      pixel.setBlue(newBlue);
    }
  }
  redImage.drawTo(rightCanvas);
}

function makeBlue() {
  for (var pixel of blueImage.values()) {
    var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    if (average < 128) {
      var newBlue = average * 2;
      pixel.setRed(0);
      pixel.setGreen(0);
      pixel.setBlue(newBlue);
    } else {
      var newRed = (average * 2) - 255;
      pixel.setRed(newRed);
      var newGreen = (average * 2) - 255;
      pixel.setGreen(newGreen);
      pixel.setBlue(0);
    }
  }
  var ctx = rightCanvas.getContext("2d");
  ctx.clearRect(0, 0, rightCanvas.width, rightCanvas.height);
  blueImage.drawTo(rightCanvas);
}
