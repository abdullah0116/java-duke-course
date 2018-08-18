// Part 1
var fgImage = new SimpleImage("drewgreen.png");
var bgImage = new SimpleImage("dinos.png");
var outputImage = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());

for (var pixel of fgImage.values()) {
    if (pixel.getGreen() > pixel.getRed() + pixel.getBlue()) {
        var bgImagePixel = bgImage.getPixel(pixel.getX(),pixel.getY());
        outputImage.setPixel(pixel.getX(), pixel.getY(), bgImagePixel);
    }
    else {
        outputImage.setPixel(pixel.getX(), pixel.getY(), pixel);
    }
}

print(outputImage);


// Part 2
var img = new SimpleImage(200,200);
for (var px of img.values()){
  var x = px.getX();
  var y = px.getY();
  if (x < img.getWidth()/2){
    px.setRed(255);
  }
  if (y>img.getHeight()/2){
    px.setBlue(255);
  }
  else {
    px.setGreen(255);
  }

  if (px.getRed() == 255 && px.getGreen() == 255) {
      px.setGreen(0);
  }
}
print (img);
