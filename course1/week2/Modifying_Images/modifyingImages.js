// write your code here
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
