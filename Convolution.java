
package mikefitzgibbon.convolutions;

import java.awt.image.BufferedImage;


public class Convolution {
    //cases for how the edges of each image are processed
    static final int
            ZERO = 0,
            WRAP = 1,
            REFLECT = 2,
            DO_NOTHING = 3;
    
    private int edgeOption;
    private final Kernel kernel;

    public Convolution(Kernel kernel, int edgeOption) {
        if(edgeOption < 0 || edgeOption > 2)
            throw new IllegalArgumentException("Edge option needs to be between 0 and 2, inclusive.");
        this.edgeOption = edgeOption;
        this.kernel = kernel;
    }
    
    public BufferedImage convolve(BufferedImage in){
        BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(), in.getType());
        for(int imgY = 0 ; imgY < out.getHeight() ; imgY++){
            for(int imgX = 0 ; imgX < out.getWidth() ; imgX++){
                out.setRGB(imgX, imgY, getConvolvedPixel(imgX, imgY, in));
            }
        }
        return out;
    }
    
    protected int getConvolvedPixel(int imgX, int imgY, BufferedImage in){
        double a = 0, r = 0, g = 0, b = 0;
        for(int matrixY = 0 ; matrixY < kernel.getMatrix()[0].length ; matrixY++){
            for(int matrixX = 0 ; matrixX < kernel.getMatrix().length ; matrixX++){
                int c = getPixel(imgX, imgY, matrixX, matrixY, in);
                double ff = kernel.getMatrix()[matrixX][matrixY];
                a += ff * ((c >> 24) & 0xff);
                r += ff * ((c >> 16) & 0xff);
                g += ff * ((c >> 8) & 0xff);
                b += ff * (c & 0xff);
            }
        }
        return ((int)a << 24) | ((int)r << 16) | ((int)g << 8) | (int)b;
    }
    
    protected int getPixel(int imgX, int imgY, int matrixX, int matrixY, BufferedImage in){
        int width = kernel.getMatrix().length,
                height = kernel.getMatrix()[0].length;
        int indexX = imgX + matrixX - width / 2, 
                indexY = imgY + matrixY - height / 2;
        switch(edgeOption){
            case REFLECT:
                if(indexX < 0)
                    indexX *= -1;
                else if(indexX >= in.getWidth())
                    indexX -= (indexX - in.getWidth()) * 2 + 1;
                if(indexY < 0)
                    indexY *= -1;
                else if(indexY >= in.getHeight())
                    indexY -= (indexY - in.getHeight()) * 2 + 1; 
                return in.getRGB(indexX, indexY);
            case WRAP:
                if(indexX < 0)
                    indexX += in.getWidth();
                else if(indexX >= in.getWidth())
                    indexX -= in.getWidth();
                if(indexY < 0)
                    indexY += in.getHeight();
                else if(indexY >= in.getHeight())
                    indexY -= in.getHeight();
                return in.getRGB(indexX, indexY);
            case ZERO: //zero
                if(indexX < 0)
                    return 0;
                else if(indexX >= in.getWidth())
                    return 0;
                if(indexY < 0)
                    return 0;
                else if(indexY >= in.getHeight())
                    return 0;
                return in.getRGB(indexX, indexY);
            case DO_NOTHING: default://return unedited pixel in default case
                return in.getRGB(indexX, indexY);
        }
    }
}
