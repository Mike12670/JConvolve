
package mikefitzgibbon.convolutions;

/**
 * Creates predefined Prewitt kernel with vertical alignment.
 * 
 * @author Mike Fitzgibbon
 */
public class PrewittVertKernel extends Kernel{

    public PrewittVertKernel() {
        super(new double[][]{
            {1, 0, -1},
            {1, 0, -1},
            {1, 0, -1}
        });
    }
    
}
