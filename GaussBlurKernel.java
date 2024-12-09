
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
                matrix[x][y] = Math.pow(Math.E, 
                        -((Math.pow(x, 2) + Math.pow(y, 2))/(2*Math.pow(intensity, 2)))) 
                        / (2 * Math.PI * Math.pow(intensity, 2));
            }
        }
    }

}
