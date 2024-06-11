
package mikefitzgibbon.convolutions;

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
     * @param diameter The size of the kernel.
     * @param intensity The degree to which the kernel is applied.
     */
    public IntensityKernel(int diameter, double intensity) {
        super(diameter);
        this.intensity = intensity;
    }

}
