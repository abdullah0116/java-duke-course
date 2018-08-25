// global image variable
var image;

function upload() {
  var canvas = document.getElementById("firstCanvas");
  var input = document.getElementById("input");
  image = new SimpleImage(input);
  image.drawTo(canvas);
}

function makeGray() {
  for (var pixel of image.values()) {
    var average = (pixel.getRed(), pixel.getGreen(), pixel.getBlue()) / 3;
    pixel.setRed(average);
    pixel.setGreen(average);
    pixel.setBlue(average);
  }
  var canvas = document.getElementById("firstCanvas");
  image.drawTo(canvas);
}
