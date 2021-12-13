import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainframeController {

    private final MainframeDialog dialog;
    private final MainframeModel model;

    public MainframeController(final MainframeDialog dialog, final MainframeModel model) {
        this.dialog = dialog;
        this.model = model;

        setDialogListeners();
        setJeffImage();
        dialog.finalizeDialogLayout();
    }

    private void setDialogListeners() {
        dialog.addButtonListeners(new MainButtonListener());
        dialog.addWindowListeners(new WindowClosedListener());
    }

    private void setJeffImage() {
        dialog.setJeffImage(model.getJeffImage());
    }

    private class MainButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JComponent comp = (JComponent) e.getSource();
            String source = comp.getName();
            if (source.equals("refresh")) {
                setJeffImage();
                dialog.pack();
            } else if (source.equals("jeff")) {
                dialog.setJeffQuote(model.getJeffQuote());
                dialog.pack();
            }
        }
    }

    private class WindowClosedListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing Program");
            super.windowClosing(e);
            System.exit(0);
        }
    }

}
