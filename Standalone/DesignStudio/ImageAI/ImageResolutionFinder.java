package Standalone.DesignStudio.ImageAI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResolutionFinder {
    public int[] resolution(String filePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(filePath));
        if (image == null) {
            System.out.println("Unsupported");
            return null;
        }
        return new int[]{image.getWidth(), image.getHeight()};
    }
}
