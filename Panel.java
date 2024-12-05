package lightanvil.jconvolve;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * This file determines what goes into the Frame and allows for the creation of entities of
 * the testing application. 
 * @author Mike Fitzgibbon
 */
public class Panel extends JPanel{
    private OptionsPanel panel;
    private Convolve convolve;
    private Kernel kernel;
    private BufferedImage before, after;
    private int n;
    private float intensity;

    public Panel() {
        super(new BorderLayout());
        n = 10;
        intensity = 1;
        kernel = new BlurKernel(n);
        convolve = new ConvolveNoOp(kernel);
        before = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    }
    
    public void init(){
        panel = new OptionsPanel(this);
        add(panel, BorderLayout.SOUTH);
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

    public BufferedImage getImage() {
        return before;
    }

    public void setConvolve(Convolve c) {
        this.convolve = c;
    }

    public void setKernel(Kernel k) {
        this.kernel = k;
    }

    public Kernel getKernel() {
        return kernel;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
    
    
}
