
package lightanvil.jconvolve;

import java.awt.image.BufferedImage;

public class ConvolveZero extends Convolve{

    public ConvolveZero(Kernel kernel) {
        super(kernel);
    }

    /**
     * If the pixel is outside bounds, return a black color
     * @param indexX X location in image.
     * @param indexY Y location in image.
     * @param in Image to be convolved.
     * @return An unaltered pixel if it is within the bounds of the image,
     *  and a black pixel if it isn't.
     */
    @Override
    protected int getPixel(int indexX, int indexY, BufferedImage in){
        if(
                indexX < 0 ||
                indexX >= in.getWidth() ||
                indexY < 0 ||
                indexY >= in.getHeight())
            return 0;
        return in.getRGB(indexX, indexY);
    }
}
