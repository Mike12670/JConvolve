
package mikefitzgibbon.convolutions;

public class Kernel {
    static final int
            BLUR = 0,
            SHARPEN = 1,
            PREWITT_VERT = 2,
            SOBEL_VERT = 3,
            SCHARR_VERT = 4,
            PREWITT_HORZ = 5,
            SOBEL_HORZ = 6,
            SCHARR_HORZ = 7,
            EMBOSS = 8,
            GAUSSIAN_BLUR = 9;
    private final double matrix[][];
    private final int intensity;
    
    /**
     * Creates a matrix for a kernel based on type.
     * @param type Determines which type of kernel is to be used.
     * @param intensity The degree to which the convolution is applied
     */
    public Kernel(int type, int intensity){
        this.intensity = intensity;
        if(intensity < 1)
            throw new IllegalArgumentException("Kernel intensity needs to be 1 or more.");
        if(type < 0 || type > GAUSSIAN_BLUR)
            throw new IllegalArgumentException("Kernel type needs to be between 0 and 10, inclusive.");
        switch(type){
            case BLUR://Blur
                matrix = new double[intensity][intensity];
                for(int my = 0 ; my < matrix[0].length ; my++){
                    for(int mx = 0 ; mx < matrix.length ; mx++){
                        matrix[mx][my] = 1f / intensity / intensity;
                    }
                }
                break;
            case SHARPEN:
                matrix = new double[][]{
                    {-0.111111f, -0.111111f, -0.111111f},
                    {-0.111111f, 17f/9,     -0.111111f},
                    {-0.111111f, -0.111111f,0-0.111111f}
                };
                break;
            case PREWITT_VERT:
                matrix = new double[][]{
                    {1, 0, -1},
                    {1, 0, -1},
                    {1, 0, -1}
                };
                break;
            case SOBEL_VERT:
                matrix = new double[][]{
                    {1, 0, -1},
                    {2, 0, -2},
                    {1, 0, -1}
                };
                break;
            case SCHARR_VERT:
                matrix = new double[][]{
                    {3, 0, -3},
                    {10, 0, -10},
                    {3, 0, -3}
                };
                break;
            case PREWITT_HORZ:
                matrix = new double[][]{
                    {1, 1, 1},
                    {0, 0, 0},
                    {-1, -1, -1}
                };
                break;
            case SOBEL_HORZ:
                matrix = new double[][]{
                    {1, 2, 1},
                    {0, 0, 0},
                    {-1, -2, -1}
                };
                break;
            case SCHARR_HORZ:
                matrix = new double[][]{
                    {3, 10, 3},
                    {0, 0, 0},
                    {-3, -10, -3}
                };
                break;
            case EMBOSS:
                matrix = new double[][]{
                    {-2, -1, 0},
                    {-1, 0, 1},
                    {0, 1, 2}
                };
                break;
            case GAUSSIAN_BLUR:
                matrix = new double[][]{
                    {0.0625, 0.125, 0.0625},
                    {0.125, 0.25, 0.125},
                    {0.0625, 0.125, 0.0625}
                };
                break;
            default://identity matrix
                matrix = new double[][]{
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
                };
        }
    }

    /**
     * Sets matrix.
     * @param matrix The matrix to set the existing matrix. 
     */
    public Kernel(double[][] matrix) {
        this.matrix = matrix;
        intensity = matrix.length;
    }

    /**
     * Gets matrix
     * @return The matrix created in the constructor.
     */
    public double[][] getMatrix() {
        return matrix;
    }
}
