
package lightanvil.jconvolve;

/**
 * Creates diameter and intensity for a kernel.
 * 
 * @author Mike Fitzgibbon
 */
public class IntensityKernel extends Kernel{
    /**
     * double intensity is the degree to which the kernel is applied.
     */
    protected final double intensity;

    /**
     * @param n The size of the kernel.
     * @param intensity The degree to which the kernel is applied.
     */
    public IntensityKernel(int n, double intensity) {
        super(n);
        this.intensity = intensity;
    }

}
