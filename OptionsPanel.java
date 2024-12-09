package lightanvil.jconvolve;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static lightanvil.jconvolve.Panel.panel;

/**
 *
 * @author Mike Fitzgibbon
 */
public class OptionsPanel extends JPanel{

    public OptionsPanel() {
        add(new JLabel("File: "));
        add(new OpenFile());
        add(new JLabel("Kernel type: "));
        add(new KernelDropDown());
        add(new JLabel("Edges of image: "));
        add(new ConvolveDropDown());
        add(new JLabel("N: "));
        add(new NField());
        add(new JLabel("Intensity: "));
        add(new IntensityField());
        JButton go = new JButton("Go");
        go.addActionListener(e -> {
            panel.convolve();
        });
        add(go);
    }

}
