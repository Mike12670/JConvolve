
package mikefitzgibbon.convolutions;

import java.awt.image.BufferedImage;

public class ConvolveWrap extends Convolve{

    public ConvolveWrap(Kernel kernel) {
        super(kernel);
    }

    /**
     * If the pixel is outside bounds, return a pixel from the other edge of the image
     * @param indexX X location in image.
     * @param indexY Y location in image.
     * @param in Image to be convolved.
     * @return An unaltered pixel if it is within the bounds of the image,
     *  and a wrapped pixel if it isn't.
     */
    @Override
    protected int getPixel(int indexX, int indexY, BufferedImage in){
        if(indexX < 0)
            indexX += in.getWidth();
        else if(indexX >= in.getWidth())
            indexX -= in.getWidth();
        if(indexY < 0)
            indexY += in.getHeight();
        else if(indexY >= in.getHeight())
            indexY -= in.getHeight();
        return in.getRGB(indexX, indexY);
    }
}
