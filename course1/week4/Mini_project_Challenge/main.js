var leftCanvas;
var rightCanvas;
var rainbow;
var imageOrg;

function upload() {
  var rawImage = document.getElementById("uploadImage");
  leftCanvas = document.getElementById("leftCanvas");
  rightCanvas = document.getElementById("rightCanvas");
  rainbow = new SimpleImage(rawImage);
  imageOrg = new SimpleImage(rawImage);
  imageOrg.drawTo(leftCanvas);
}

function makeRainbow() {
  var h = rainbow.getHeight();

  for (var pixel of rainbow.values()) {
    var average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    var y = pixel.getY();

    if (y < h / 7) {
      if (average < 128) {
        pixel.setRed(2 * average);
        pixel.setGreen(0);
        pixel.setBlue(0);
      } else {
        pixel.setRed(255);
        pixel.setGreen(2 * average - 255);
        pixel.setBlue(2 * average - 255);
      }
    } else if (y < (h * 2) / 7) {
      if (average < (h * 3) / 7) {
        if (average < 128) {
          pixel.setRed(2 * average);
          pixel.setGreen(2 * average);
          pixel.setBlue(0);
        } else {
          pixel.setRed(255);
          pixel.setGreen(255);
          pixel.setBlue(2 * average - 255);
        }
      }
    } else if (y < (h * 4) / 7) {
      if (average < 128) {
        pixel.setRed(0);
        pixel.setGreen(2 * average);
        pixel.setBlue(0);
      } else {
        pixel.setRed(2 * average - 255);
        pixel.setGreen(255);
        pixel.setBlue(2 * average - 255);
      }
    } else if (y < (h * 5) / 7) {
      if (average < 128) {
        pixel.setRed(0);
        pixel.setGreen(0);
        pixel.setBlue(6 * average);
      } else {
        pixel.setRed(2 * average - 255);
        pixel.setGreen(2 * average - 255);
        pixel.setBlue(255);
      }
    } else if (y < (h * 6) / 7) {
      if (average < 128) {
        pixel.setRed(.6 * average);
        pixel.setGreen(0);
        pixel.setBlue(3 * average);
      } else {
        pixel.setRed(3 * average - 50);
        pixel.setGreen(2 * average - 255);
        pixel.setBlue(255);
      }
    } else {
      if (average < 128) {
        pixel.setRed(10 * average);
        pixel.setGreen(0);
        pixel.setBlue(10 * average);
      } else {
        pixel.setRed(0.9 * average + 153);
        pixel.setGreen(4 * average - 255);
        pixel.setBlue(0.9 * average + 153)
      }
    }
  }
  rainbow.drawTo(rightCanvas);
}
