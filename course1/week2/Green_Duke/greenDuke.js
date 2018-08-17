var dukeBlue = new SimpleImage("duke_blue_devil.png");

for (var pixel of dukeBlue.values()) {
    if (pixel.getBlue() >= 255) {
        pixel.setBlue(255);
    } else {
        pixel.setBlue(100);
        pixel.setGreen(255);
    }
}

print(dukeBlue);
