function upload() {
  var canvas = document.getElementById("firstCanvas");
  var input = document.getElementById("input");
  var image = new SimpleImage(input);
  image.drawTo(canvas);
}
