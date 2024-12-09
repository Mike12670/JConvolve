package lightanvil.jconvolve;

/**
 *
 * @author Mike Fitzgibbon
 */
public class NoOpKernel extends Kernel{

    public NoOpKernel() {
        super(new double[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
    }

}
