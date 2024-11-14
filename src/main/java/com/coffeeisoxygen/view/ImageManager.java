package com.coffeeisoxygen.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.coffeeisoxygen.model.tiles.TileType;
import com.coffeeisoxygen.utils.ImageUtils;

public class ImageManager {

    private static final Map<TileType, BufferedImage> imageCache = new EnumMap<>(TileType.class);
    private static final Map<String, Image> resizedImageCache = new HashMap<>();

    static {
        loadImages();
    }

    private static void loadImages() {
        imageCache.put(TileType.STARTTILE, loadImage("/images/STARTTILE.png"));
        imageCache.put(TileType.FINISHTILE, loadImage("/images/FINISHTILE.png"));
        imageCache.put(TileType.SAFETILE, loadImage("/images/SAFETILE.png"));
        imageCache.put(TileType.DANGERTILE, loadImage("/images/DANGERTILE.png"));
        imageCache.put(TileType.ROUTETILE, loadImage("/images/ROUTETILE.png"));
    }

    private static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageManager.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage getImage(TileType tileType) {
        return imageCache.get(tileType);
    }

    public static Image getResizedImage(TileType tileType, int width, int height) {
        String key = tileType.name() + "_" + width + "x" + height;
        if (!resizedImageCache.containsKey(key)) {
            BufferedImage originalImage = getImage(tileType);
            Image resizedImage = ImageUtils.resizeImage(originalImage, width, height);
            resizedImageCache.put(key, resizedImage);
        }
        return resizedImageCache.get(key);
    }
}