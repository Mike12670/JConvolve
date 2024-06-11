package mikefitzgibbon.convolutions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example {
    static BufferedImage original, filtered;
    public static void main(String[] args) {
        Convolution conv = new Convolution(new Kernel(Kernel.PREWITT_VERT, 10), Convolution.DO_NOTHING);
        original = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        try{
            original = ImageIO.read(new File("a.jpeg"));
            filtered = conv.convolve(original);
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
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.add(panel);
        frame.setVisible(true);
    }
}
