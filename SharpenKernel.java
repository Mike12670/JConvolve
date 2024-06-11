
package mikefitzgibbon.convolutions;

/**
 * Creates sharpening kernel.
 * 
 * @author Mike Fitzgibbon
 */
public class SharpenKernel extends Kernel{
    /**
     * Sharpening kernels have their largest value in the center of their matrix,
     * and all other values are negative.
     * @param diameter The size of the kernel.
     */
    public SharpenKernel(int diameter) {
        super(diameter);
        if(diameter % 2 == 0)
            matrix[diameter / 2 - 1][diameter / 2 - 1] = 2;
        else
            matrix[diameter / 2][diameter / 2] = 2;
        
        for(int y = 0 ; y < diameter ; y++){
            for(int x = 0 ; x < diameter ; x++){
                matrix[x][y] -= 1.0 / diameter / diameter;
            }
        }
    }

}
