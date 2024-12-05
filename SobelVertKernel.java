
package lightanvil.jconvolve;

/**
 * Creates predefined Sobel kernel with vertical alignment.
 * 
 * @author Mike Fitzgibbon
 */
public class SobelVertKernel extends Kernel{

    public SobelVertKernel() {
        super(new double[][]{
            {1, 0, -1},
            {2, 0, -2},
            {1, 0, -1}
        });
    }

}
