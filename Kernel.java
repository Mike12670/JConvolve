
package lightanvil.jconvolve;

/**
 * Kernel subclasses specify the formula for the
 * kernel matrix values, and includes 
 * BlurKernel, GaussBlurKernel, 
 *  SharpenKernel, EmbossKernel,
 *  PrewittHorzKernel, PrewittVertKernel, 
 *  ScharrHorzKernel, ScharrVertKernel,
 *  SobelHorzKernel, and SobelVertKernel.
 * 
 * @author Mike Fitzgibbon
 */
public class Kernel {
    static Kernel kernel;
    protected double matrix[][];
    
    
    /**
     * int diameter is the size of the kernel.
     */
    protected int n;
    
    /**
     * Creates a matrix for a kernel based on type.
     * @param n The degree to which the convolution is applied
     */
    protected Kernel(int n){
        this.n = n;
        matrix = new double[n][n];
    }

    /**
     * Sets matrix.
     * @param matrix The matrix to set the existing matrix. 
     */
    public Kernel(double[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
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
    public int getN() {
        return n;
    }
}
