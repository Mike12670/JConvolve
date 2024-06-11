
package mikefitzgibbon.convolutions;

/**
 * Kernel subclasses specify the kernel matrix values, 
 *  and includes BlurKernel, GaussBlurKernel, 
 *  SharpenKernel, EmbossKernel,
 *  PrewittHorzKernel, PrewittVertKernel, 
 *  ScharrHorzKernel, ScharrVertKernel,
 *  SobelHorzKernel, and SobelVertKernel.
 * 
 * @author Mike Fitzgibbon
 */
public class Kernel {
    protected double matrix[][];
    
    /**
     * int diameter is the size of the kernel.
     */
    protected int diameter;
    
    /**
     * Creates a matrix for a kernel based on type.
     * @param diameter The degree to which the convolution is applied
     */
    public Kernel(int diameter){
        this.diameter = diameter;
        matrix = new double[diameter][diameter];
    }

    /**
     * Sets matrix.
     * @param matrix The matrix to set the existing matrix. 
     */
    public Kernel(double[][] matrix) {
        this.matrix = matrix;
        this.diameter = matrix.length;
    }

    /**
     * Gets matrix
     * @return The matrix created in the constructor.
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Gets diameter
     * @return The size of the kernel
     */
    public int getDiameter() {
        return diameter;
    }
}
