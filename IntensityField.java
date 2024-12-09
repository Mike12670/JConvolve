package lightanvil.jconvolve;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static lightanvil.jconvolve.Panel.panel;

/**
 *
 * @author Mike Fitzgibbon
 */
public class IntensityField extends JTextField{

    public IntensityField() {
        super(1);
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                panel.setIntensity(Integer.parseInt(getText()));
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                panel.setIntensity(Integer.parseInt(getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                panel.setIntensity(Integer.parseInt(getText()));
            }
        });
    }
}
