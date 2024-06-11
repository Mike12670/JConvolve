
package mikefitzgibbon.convolutions;

/**
 * Creates embossing kernel. Embossing kernels are positive around
 * the top left corner, negative around the bottom right corner,
 * and have a line of zeroes from the bottom left corner to the 
 * top right corner.
 * 
 * @author Mike Fitzgibbon
 */
public class EmbossKernel extends Kernel{

    public EmbossKernel(int diameter) {
        super(diameter);
        for(int y = 0 ; y < diameter ; y++){
            for(int x = 0 ; x < diameter ; x++){
                matrix[x][y] = x + y + 1 - diameter;
            }
        }
    }

}
