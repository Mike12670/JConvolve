
package lightanvil.jconvolve;

/**
 * Creates blur kernel. Blur kernels all have the 
 * same value: 1 divided by n squared.
 * 
 * @author Mike Fitzgibbon
 */
public class BlurKernel extends Kernel{

    /**
     * Images are blurrier with a higher diameter.
     * @param n The size of the kernel.
     */
    public BlurKernel(int n) {
        super(n);
        for(int my = 0 ; my < matrix[0].length ; my++){
            for (double[] matrix1 : matrix) {
                matrix1[my] = 1.0 / n / n;
            }
        }
    }

}
