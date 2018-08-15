// PART 1
var startingImage = new SimpleImage("smalllion.jpg");

print("Width: " + startingImage.getWidth());

for (var pixel of startingImage.values()) {
    if (pixel.getX() <= 83) {
        pixel.setRed(255);
    }
    else if (pixel.getX() >= 83 && pixel.getX() <= 166) {
        pixel.setGreen(255);
    }
    else {
        pixel.setBlue(255);
    }
}

print("Part One: ")
print(startingImage);

//PART 2
function swapRedGreen(image) {
    for (var pixel of image.values()) {
        var redColor = pixel.getRed();
        var greenColor = pixel.getGreen();
        pixel.setRed(greenColor);
        pixel.setGreen(redColor);
    }
    print(image);
}

print("Part Two: ")
swapRedGreen(startingImage);

// PART 3
var dukeIMG = new SimpleImage("duke_blue_devil.png");
print("Part Three:");
print(dukeIMG);

for (var pixel of dukeIMG.pixels()) {
    if (pixel.getBlue() >= 255) {
        pixel.setBlue(255);
    } else {
        pixel.setBlue(0);
        pixel.setRed(255);
        pixel.setGreen(255);
    }
}
print(dukeIMG);
