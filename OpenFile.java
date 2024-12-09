package lightanvil.jconvolve;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static lightanvil.jconvolve.Panel.panel;
import static lightanvil.jconvolve.TestMain.frame;

/**
 *
 * @author Mike Fitzgibbon
 */
public class OpenFile extends JButton{

    public OpenFile() {
        super("Open");
        addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if(fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
                panel.setImage(readImage(fc.getSelectedFile()));
                panel.convolve();
            }
        });
    }
    
    private BufferedImage readImage(File f){
        try{
            return ImageIO.read(f);
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(
                    frame, 
                    "Could not find file. Check the spelling and try again.", 
                    "File not found", 
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(
                    frame, 
                    "IOException occurred while trying to load an image. This potentially could mean"
                            + "that you accidentally chose a file that wasn't an image.", 
                    "IOException", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    }

}
