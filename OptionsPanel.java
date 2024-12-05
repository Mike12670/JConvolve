package lightanvil.jconvolve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static lightanvil.jconvolve.TestMain.frame;

/**
 *
 * @author Mike Fitzgibbon
 */
public class OptionsPanel extends JPanel{

    public OptionsPanel(Panel panel) {
        JButton go = new JButton("Go");
        go.addActionListener(e ->{
            panel.convolve();
        });
        
        add(new OpenFile(panel));
        add(new KernelDropDown(panel));
        add(new EdgeDropDown(panel));
        add(go);
    }

}
