
package lightanvil.jconvolve;

import java.awt.image.BufferedImage;

public class ConvolveReflect extends Convolve{

    public ConvolveReflect(Kernel kernel) {
        super(kernel);
    }

    /**
     * If the pixel is outside bounds, return a pixel mirrored from the bounds
     * @param indexX X location in image.
     * @param indexY Y location in image.
     * @param in Image to be convolved.
     * @return An unaltered pixel if it is within the bounds of the image,
     *  and a reflected pixel if it isn't.
     */
    @Override
    protected int getPixel(int indexX, int indexY, BufferedImage in) {
        if(indexX < 0)
            indexX = -indexX + 1;
        else if(indexX >= in.getWidth())
            indexX -= (indexX - in.getWidth()) * 2 + 1;
        if(indexY < 0)
            indexY = -indexY + 1;
        else if(indexY >= in.getHeight())
            indexY -= (indexY - in.getHeight()) * 2 + 1; 
        return in.getRGB(indexX, indexY);
    }

}
