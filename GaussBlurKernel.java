
package lightanvil.jconvolve;

/**
 * Creates Gaussian blur kernel.
 * 
 * @author Mike Fitzgibbon
 */
public class GaussBlurKernel extends IntensityKernel{

    /**
     * Gaussian blur Kernels get increasingly larger as you get closer
     * to the center of the kernel.
     * @param n The size of the Kernel.
     * @param intensity The degree to which the Gaussian blur is applied.
     */
    public GaussBlurKernel(int n, double intensity) {
        super(n, intensity);
        for(int y = 0 ; y < n ; y++){
            for(int x = 0 ; x < n ; x++){
                matrix[x][y] -= 1.0 / 
                        (x < n / 2 ? x : n - x + 
                        y < n / 2 ? y : n - y)
                        / n;
            }
        }
    }

}
