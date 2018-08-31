var image;
var cleanImage;
var leftCanvas;
var rightCanvas;

function upload() {
  leftCanvas = document.getElementById("leftCanvas");
  var rawImage = document.getElementById("imageUpload");
  cleanImage = new SimpleImage(rawImage);
  image = new SimpleImage(rawImage);
  cleanImage.drawTo(leftCanvas);
}

function makeRed() {

}
