
package mikefitzgibbon.convolutions;

/**
 * Creates Gaussian blur kernel.
 * 
 * @author Mike Fitzgibbon
 */
public class GaussBlurKernel extends IntensityKernel{

    /**
     * Gaussian blur Kernels get increasingly larger as you get closer
     * to the center of the kernel.
     * @param diameter The size of the Kernel.
     * @param intensity The degree to which the Gaussian blur is applied.
     */
    public GaussBlurKernel(int diameter, double intensity) {
        super(diameter, intensity);
        for(int y = 0 ; y < diameter ; y++){
            for(int x = 0 ; x < diameter ; x++){
                matrix[x][y] -= 1.0 / 
                        (x < diameter / 2 ? x : diameter - x + 
                        y < diameter / 2 ? y : diameter - y)
                        / diameter;
            }
        }
    }

}
