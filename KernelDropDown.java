package lightanvil.jconvolve;

import javax.swing.JComboBox;

/**
 *
 * @author Mike Fitzgibbon
 */
public class KernelDropDown extends JComboBox<String>{

    public KernelDropDown(Panel panel) {
        super(new String[]{
            "Blur", "Gaussian Blur", "Sharpen", "Emboss",
            "Horizontal Motion Blur", "Vertical Motion Blur", "Radial Motion Blur",
            "Prewitt Horizontal", "Prewitt Vertical",
            "Scharr Horizontal", "Scharr Vertical",
            "Sobel Horizontal", "Sobel Vertical"
        });
        
        panel.setKernel(new BlurKernel(panel.getN()));
        
        addActionListener(e -> {
            switch((String) getSelectedItem()){
                case "Blur" -> {
                    panel.setKernel(new BlurKernel(panel.getN()));
                }
                case "Gaussian Blur" -> {
                    panel.setKernel(new GaussBlurKernel(panel.getN(), panel.getIntensity()));
                }
                case "Sharpen" -> {
                    panel.setKernel(new SharpenKernel(panel.getN()));
                }
                case "Emboss" -> {
                    panel.setKernel(new EmbossKernel(panel.getN()));
                }
                case "Horizontal Motion Blur" -> {
                    panel.setKernel(new HorzMotionKernel(panel.getN(), panel.getIntensity()));
                }
                case "Vertical Motion Blur" -> {
                    panel.setKernel(new VertMotionKernel(panel.getN(), panel.getIntensity()));
                }
                case "Radial Motion Blur" -> {
                    panel.setKernel(new RadialMotionKernel(panel.getN(), panel.getIntensity()));
                }
                case "Prewitt Horizontal" -> {
                    panel.setKernel(new PrewittHorzKernel());
                }
                case "Prewitt Vertical" -> {
                    panel.setKernel(new PrewittVertKernel());
                }
                case "Scharr Horizontal" -> {
                    panel.setKernel(new ScharrHorzKernel());
                }
                case "Scharr Vertical" -> {
                    panel.setKernel(new ScharrVertKernel());
                }
                case "Sobel Horizontal" -> {
                    panel.setKernel(new SobelHorzKernel());
                }
                case "Sobel Vertical" -> {
                    panel.setKernel(new SobelVertKernel());
                }
            }
        });
    }

}
