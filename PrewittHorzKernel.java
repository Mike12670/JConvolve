
package lightanvil.jconvolve;

/**
 * Creates predefined Prewitt kernel with horizontal alignment.
 * 
 * @author Mike Fitzgibbon
 */
public class PrewittHorzKernel extends Kernel{

    public PrewittHorzKernel() {
        super(new double[][]{
            {1, 1, 1},
            {0, 0, 0},
            {-1, -1, -1}
        });
    }

}
