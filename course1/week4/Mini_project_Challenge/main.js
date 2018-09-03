var leftCanvas;
var rightCanvas;
var rainbow;
var blur;
var imageOrg;

function upload() {
  var rawImage = document.getElementById("uploadImage");
  leftCanvas = document.getElementById("leftCanvas");
  rightCanvas = document.getElementById("rightCanvas");
  rainbow = new SimpleImage(rawImage);
  blur = new SimpleImage(rawImage);
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

function makeBlurry() {

     if (blur == null) {
       alert("no image uploaded");
       return;
     }
     //create blank image
     var blankImage = new SimpleImage(blur.getWidth(), blur.getHeight());

     //iterate through image pixel by pixel

     for(var pixel of blur.values()){
       //generate random number between 0 and 1
       var randomNumber = Math.random();
       //if random is less than 0.5 copy original image pixel
       var x = pixel.getX();
         var y = pixel.getY();
       if(randomNumber < 0.5){
         //get x and y value of original pixel

         //set original pixel on blank image at x and y
         blankImage.setPixel(x,y,pixel);
       } else {
         //make an offsetX variable
         //assign to x + 1 if x is less than image width
         //otherwise assign to x - 1
         var offsetX;
         if(x < blur.getWidth() - 1){
           offsetX = x+1;
         } else {
           offsetX = x-1;
         }
         //make an offsetY variable
         //assign to y + 1 if y is less than image height
         //otherwise assign to y - 1
         var offsetY;
         if(y < blur.getHeight() - 1) {
           offsetY = y+1;
         } else {
           offsetY = y-1;
         }
         //set pixel with on blankImage with x, y and pixel at offsetX and offsetY
         var nearbyPixel = blur.getPixel(offsetX, offsetY);
         blankImage.setPixel(x, y, nearbyPixel);
       }
       //otherwise copy a nearby image pixel
     }
     blankImage.drawTo(rightCanvas);
   }
