package lightanvil.jconvolve;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import static lightanvil.jconvolve.Kernel.kernel;

/**
 * This file determines what goes into the Frame and allows for the creation of entities of
 * the testing application. 
 * @author Mike Fitzgibbon
 */
public class Panel extends JPanel{
    static Panel panel;
    private final OptionsPanel optionsPanel;
    private Convolve convolve;
    private BufferedImage before, after;
    private int n;
    private float intensity;

    public Panel() {
        super(new BorderLayout());
        n = 3;
        intensity = 1;
        kernel = new NoOpKernel();
        convolve = new NoOpConvolve();
        before = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        optionsPanel = new OptionsPanel();
        add(optionsPanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(after, 0, 0, null);
    }
    
    public void convolve(){
        after = convolve.filter(before);
        repaint();
    }

    public void setImage(BufferedImage before) {
        this.before = before;
    }

    public void setConvolve(String s) {
        switch(s){
            case "No Operation" -> convolve = new NoOpConvolve(); 
            case "Zero" -> convolve = new ZeroConvolve(); 
            case "Reflect" -> convolve = new ReflectConvolve(); 
            case "Wrap" -> convolve = new WrapConvolve(); 
        }
    }

    public void setKernel(String s) {
        switch(s){
            case "Blur" -> {
                kernel = new BlurKernel(n);
            }
            case "Gaussian Blur" -> {
                kernel = new GaussBlurKernel(n, intensity);
            }
            case "Sharpen" -> {
                kernel = new SharpenKernel(n);
            }
            case "Emboss" -> {
                kernel = new EmbossKernel(n);
            }
            case "Horizontal Motion Blur" -> {
                kernel = new HorzMotionKernel(n, intensity);
            }
            case "Vertical Motion Blur" -> {
                kernel = new VertMotionKernel(n, intensity);
            }
            case "Radial Motion Blur" -> {
                kernel = new RadialMotionKernel(n, intensity);
            }
            case "Prewitt Horizontal" -> {
                kernel = new PrewittHorzKernel();
            }
            case "Prewitt Vertical" -> {
                kernel = new PrewittVertKernel();
            }
            case "Scharr Horizontal" -> {
                kernel = new ScharrHorzKernel();
            }
            case "Scharr Vertical" -> {
                kernel = new ScharrVertKernel();
            }
            case "Sobel Horizontal" -> {
                kernel = new SobelHorzKernel();
            }
            case "Sobel Vertical" -> {
                kernel = new SobelVertKernel();
            }
        }
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setIntensity(float intensity) {
        this.intensity = intensity;
    }
    
    
}
