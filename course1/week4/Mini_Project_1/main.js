// global image variable
var red;
var gray;
var blue;
var image;

function upload() {
  var canvas = document.getElementById("canvas");
  var input = document.getElementById("input");
  red = new SimpleImage(input);
  gray = new SimpleImage(input);
  blue = new SimpleImage(input);
  image = new SimpleImage(input);
  image.drawTo(canvas);
}

function makeGray() {
    for (var pixel of gray.values()) {
      var average = (pixel.getRed(), pixel.getGreen(), pixel.getBlue()) / 3;
        pixel.setRed(average);
        pixel.setGreen(average);
        pixel.setBlue(average);
    }
    var canvas = document.getElementById("canvas");
    gray.drawTo(canvas);
}

function makeRed() {
  for(var pixel of red.values()) {
    pixel.setRed(230);
  }
  var canvas = document.getElementById("canvas");
  red.drawTo(canvas);
}

function makeBlue() {
  for (var pixel of blue.values()) {
    pixel.setBlue(230);
  }
  var canvas = document.getElementById("canvas");
  blue.drawTo(canvas);
}

function removeFilters() {
  var canvas = document.getElementById("canvas");
  image.drawTo(canvas);
}
