var fgImage = null;
var bgImage = null;
var leftCanvas;
var rightCanvas;

function loadForegroundImage() {
  leftCanvas = document.getElementById("leftCanvas");
  var image = document.getElementById("fg");
  fgImage = new SimpleImage(image);
  fgImage.drawTo(leftCanvas);

  if (fgImage != null || fgImage == fgImage.complete) {
    alert("Your foreground image has been uploaded.");
  }
}

function loadBackgroundImage() {
  rightCanvas = document.getElementById("rightCanvas");
  var image = document.getElementById("bg");
  bgImage = new SimpleImage(image);
  bgImage.drawTo(rightCanvas);

  if (bgImage != null || bgImage == bgImage.complete) {
    alert("Your background image has been uploaded.");
  }
}

function createComposite() {
  var output  = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());

  //write code for each of these steps:
  //For each pixel (currentPixel) in fgImage
  for (var pixel of fgImage.values()) {
      //Look at currentPixel and if it is green,
      if (pixel.getGreen() > pixel.getRed() + pixel.getBlue()) {
          //Look at same position in bgImage
          var bgImagePixel = bgImage.getPixel(pixel.getX(), pixel.getY());
          //and set output's corresponding pixel to bgImage's pixel
          output.setPixel(pixel.getX(), pixel.getY(), bgImagePixel);
      }
      //Otherwise: set output's corresponding pixel to currentPixel
      else {
          output.setPixel(pixel.getX(), pixel.getY(), pixel);
      }
  }
  //show our answer!
  output.drawTo(leftCanvas);
}

function greenScreen() {
  if (fgImage == null || ! fgImage.complete) {
    alert("Your foreground image has not been uploaded.");
  }

  if (bgImage == null || ! bgImage.complete) {
    alert("Your background image has not been uploaded.")
  }

  clearCanvas();

  leftCanvas = document.getElementById('leftCanvas');
  var combinedImage = createComposite();
  combinedImage.drawTo(leftCanvas);
}

function clearCanvas() {
  doClear(leftCanvas);
  doClear(rightCanvas);
}

function doClear(canvas) {
  var context = canvas.getContext("2d");
  context.clearRect(0,0,canvas.width,canvas.height);
}
