package com.coffeeisoxygen.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageUtils {

    public static Image resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        return originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
    }
}