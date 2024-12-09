package lightanvil.jconvolve;

import javax.swing.JFrame;
import static lightanvil.jconvolve.Panel.panel;

/**
 * This subclass of JFrame is what opens when you need to test the library.
 * @author Mike Fitzgibbon
 */
public class Frame extends JFrame{
    public Frame(){
        super("JConvolve Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        panel = new Panel();
        add(panel);
        setVisible(true);
    }

    public Panel getPanel() {
        return panel;
    }
    
}
