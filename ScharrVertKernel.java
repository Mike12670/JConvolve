
package mikefitzgibbon.convolutions;

/**
 * Creates predefined Scharr kernel with vertical alignment.
 * 
 * @author Mike Fitzgibbon
 */
public class ScharrVertKernel extends Kernel{

    public ScharrVertKernel() {
        super(new double[][]{
            {3, 0, -3},
            {10, 0, -10},
            {3, 0, -3}
        });
    }

}
