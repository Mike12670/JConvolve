package lightanvil.jconvolve;

import javax.swing.JComboBox;

/**
 *
 * @author Mike Fitzgibbon
 */
public class EdgeDropDown extends JComboBox<String>{

    public EdgeDropDown(Panel panel) {
        super(new String[]{
            "No Operation", "Zero", "Reflect", "Wrap"
        });
        panel.setConvolve(new ConvolveNoOp(panel.getKernel()));
        
        addActionListener(e -> {
            switch((String) getSelectedItem()){
                case "No Operation" -> panel.setConvolve(new ConvolveNoOp(panel.getKernel())); 
                case "Zero" -> panel.setConvolve(new ConvolveZero(panel.getKernel())); 
                case "Reflect" -> panel.setConvolve(new ConvolveReflect(panel.getKernel())); 
                default -> panel.setConvolve(new ConvolveWrap(panel.getKernel())); 
            }
        });
    }
    
}
