
package lightanvil.jconvolve;

import java.awt.image.BufferedImage;

/**
 * Convolve subclasses specify the edge handling cases, 
 *  and includes ConvolveNoOp, ConvolveZero, ConvolveWrap, 
 *  and ConvolveReflect.
 * 
 * @author Mike Fitzgibbon
 */
public abstract class Convolve {
    protected final Kernel kernel;

    public Convolve(Kernel kernel) {
        this.kernel = kernel;
    }
    
    /**
     * Assigns convolved pixels to image.
     * @param in The BufferedImage to be convolved.
     * @return The convolved BufferedImage.
     */
    public BufferedImage filter(BufferedImage in){
        BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(), in.getType());
        for(int imgY = 0 ; imgY < out.getHeight() ; imgY++){
            for(int imgX = 0 ; imgX < out.getWidth() ; imgX++){
                out.setRGB(imgX, imgY, getConvolvedPixel(imgX, imgY, in));
            }
        }
        return out;
    }
    
    /**
     * 
     * @param imgX Pixel x from the original image that will be convolved.
     * @param imgY Pixel y from the original image that will be convolved.
     * @param in The original image that will be convolved.
     * @return An int that represents the color in a single pixel.
     */
    protected int getConvolvedPixel(int imgX, int imgY, BufferedImage in){
        double a = 0, r = 0, g = 0, b = 0;
        for(int matrixY = 0 ; matrixY < kernel.n ; matrixY++){
            for(int matrixX = 0 ; matrixX < kernel.n ; matrixX++){
                
                int indexX = imgX + matrixX - kernel.n / 2, 
                        indexY = imgY + matrixY - kernel.n / 2;
                int c = getPixel(indexX, indexY, in);
                double ff = kernel.getMatrix()[matrixX][matrixY];
                
                a += ff * ((c >> 24) & 0xff);
                r += ff * ((c >> 16) & 0xff);
                g += ff * ((c >> 8) & 0xff);
                b += ff * (c & 0xff);
            }
        }
        return ((int)a << 24) | ((int)r << 16) | ((int)g << 8) | (int)b;
    }
    
    /**
     * 
     * @param indexX The combination of image and kernel x.
     * @param indexY The combination of image and kernel y.
     * @param in The original image that will be convolved.
     * @return An int that represents the color in a single pixel 
     *  that has its edge cases taken care of. 
     */
    protected abstract int getPixel(int indexX, int indexY, BufferedImage in);
}
