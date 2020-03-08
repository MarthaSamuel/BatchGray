 /**
 * Create a gray scale version of an image by setting all color components of each 
 * pixel to the same value and saving the new grayscale file with new names.
 *  N10a
 * @author Dimgba Martha Otisi 
 * @2020,January
 * @martha_samuel_
 * 
 */

import edu.duke.*;
import java.io.File;

public class GrayScaleConverters {
    //I started with the image I wanted (inImage)
    public ImageResource makeGray(ImageResource inImage) {
        //I made copy of the original image with color which will be the one later returned in grayscale
        ImageResource outImage = new ImageResource(inImage);
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + inPixel's blue + inPixel's green
            //divide that sum by 3 (call it average)
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) /3;
            //set pixel's red to average
            pixel.setRed(average);
            //set pixel's green to average
            pixel.setGreen(average);
            //set pixel's blue to average
            pixel.setBlue(average);
        }
        //outImage is your answer
        return outImage;
    }

    public void selectConvertAndSave() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.setFileName("gray-" + inImage.getFileName());
            gray.draw();
            gray.save();
        }
    }
}
