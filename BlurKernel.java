
package mikefitzgibbon.convolutions;

/**
 * Creates blur kernel. Blur kernels all have the 
 * same value: 1 divided by the matrix's diameter squared.
 * 
 * @author Mike Fitzgibbon
 */
public class BlurKernel extends Kernel{

    /**
     * Images are blurrier with a higher diameter.
     * @param diameter The size of the kernel.
     */
    public BlurKernel(int diameter) {
        super(diameter);
        for(int my = 0 ; my < matrix[0].length ; my++){
            for (double[] matrix1 : matrix) {
                matrix1[my] = 1.0 / diameter / diameter;
            }
        }
    }

}
