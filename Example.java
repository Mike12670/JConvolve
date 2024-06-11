package mikefitzgibbon.convolutions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Tests two Convolve and Kernel subclasses, then
 * paints the original and convolved image.
 * 
 * @author Mike Fitzgibbon
 */
public class Example {
    static BufferedImage original, filtered;
    public static void main(String[] args) {
        Convolve conv = new ConvolveReflect(new EmbossKernel(11));
        original = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        try{
            original = ImageIO.read(new File("c.jpg"));
            filtered = conv.filter(original);
        }
        catch(IOException e){
            System.out.println("File not found.");
        }
        
        JFrame frame = new JFrame("Convolve Test");
        JPanel panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(filtered, 0, 0, null);
                g.drawImage(original, 0, filtered.getHeight(), null);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.add(panel);
        frame.setVisible(true);
    }
}
