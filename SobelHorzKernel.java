
package mikefitzgibbon.convolutions;

/**
 * Creates predefined Sobel kernel with horizontal alignment.
 * 
 * @author Mike Fitzgibbon
 */
public class SobelHorzKernel extends Kernel{

    public SobelHorzKernel() {
        super(new double[][]{
            {1, 2, 1},
            {0, 0, 0},
            {-1, -2, -1}
        });
    }

}
