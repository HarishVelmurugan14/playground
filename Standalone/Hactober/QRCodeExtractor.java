package Standalone.Hactober;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QRCodeExtractor {

    public static int count = 1;

    public static void main(String[] args) {
        String folderPath = "/Users/harish-10327/Downloads/qrOqr"; // Replace with the actual folder path
        List<String> qrCodeContents = extractQRCodesFromFolder(folderPath);
int i = 0;
        for (String content : qrCodeContents) {
            i++;
            System.out.println(i +". " + content);
        }
    }

    public static List<String> extractQRCodesFromFolder(String folderPath) {
        List<String> qrCodeContents = new ArrayList<>();

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        BufferedImage image = ImageIO.read(file);
                        Result result = decodeQRCode(image);
                        System.out.println(count +". " + result.getText());
                        //Decoder.decode(result.getText());
                        count++;
                        if (result != null) {
                            qrCodeContents.add(result.getText());
                        }
                    } catch (IOException | NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return qrCodeContents;
    }

    public static Result decodeQRCode(BufferedImage image) throws NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        return new MultiFormatReader().decode(binaryBitmap);
    }
}
