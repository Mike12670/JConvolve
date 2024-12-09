package lightanvil.jconvolve;

import javax.swing.JComboBox;
import static lightanvil.jconvolve.Panel.panel;

/**
 *
 * @author Mike Fitzgibbon
 */
public class ConvolveDropDown extends JComboBox<String>{

    public ConvolveDropDown() {
        super(new String[]{
            "No Operation", "Zero", "Reflect", "Wrap"
        });
        addActionListener(e -> {
            panel.setConvolve((String) getSelectedItem());
            panel.convolve();
        });
    }
}
