package lightanvil.jconvolve;

import javax.swing.JComboBox;
import static lightanvil.jconvolve.Panel.panel;

/**
 *
 * @author Mike Fitzgibbon
 */
public class KernelDropDown extends JComboBox<String>{

    public KernelDropDown() {
        super(new String[]{
            "No Operation", "Blur", "Gaussian Blur", "Sharpen", "Emboss",
            "Horizontal Motion Blur", "Vertical Motion Blur", "Radial Motion Blur",
            "Prewitt Horizontal", "Prewitt Vertical",
            "Scharr Horizontal", "Scharr Vertical",
            "Sobel Horizontal", "Sobel Vertical"
        });
        
        addActionListener(e -> {
            panel.setKernel((String) getSelectedItem());
            panel.convolve();
        });
    }
}
