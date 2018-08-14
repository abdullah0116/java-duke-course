// this is using the duke simple Image Libary
var startingImage = new SimpleImage(200,200);
print(startingImage);

for (var pixel of startingImage.values()) {
    pixel.setRed(255);
    pixel.setGreen(255); 
}
print(startingImage);

for (var pixel of startingImage.values()) {
    pixel.setGreen(0);
    pixel.setBlue(255);
}
print(startingImage);

 

