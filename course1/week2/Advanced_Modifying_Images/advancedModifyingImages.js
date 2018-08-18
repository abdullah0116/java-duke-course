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
