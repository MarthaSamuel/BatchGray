/** Batchinversions gives us the saved copies of inverted scale images
 * 
 * 
 * N10d
 * @author Dimgba Martha Otisi 
 * @2020,January
 * @martha_samuel_
 */
import edu.duke.*;
import java.io.File;

public class BatchInversions {
    
    public ImageResource makeInversion(ImageResource inImage) {
        
        ImageResource outImage = new ImageResource(inImage);
        
        for (Pixel pixel: outImage.pixels()) {
            
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            int invRed = 255 - inPixel.getRed();
            int invGreen = 255 - inPixel.getGreen();
            int invBlue = 255 - inPixel.getBlue();
            
            pixel.setRed(invRed);
            
            pixel.setGreen(invGreen);
           
            pixel.setBlue(invBlue);
        }
        
        return outImage;
        
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource imageInv = makeInversion(inImage);
            imageInv.setFileName("inverted-" + inImage.getFileName());
            imageInv.draw();
            imageInv.save();
        }
    }
    
}