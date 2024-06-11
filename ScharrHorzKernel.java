
package mikefitzgibbon.convolutions;

/**
 * Creates predefined Scharr kernel with horizontal alignment.
 * 
 * @author Mike Fitzgibbon
 */
public class ScharrHorzKernel extends Kernel{

    public ScharrHorzKernel() {
        super(new double[][]{
            {3, 10, 3},
            {0, 0, 0},
            {-3, -10, -3}
        });
    }

}
