import layout.TableLayout;
import layout.TableLayoutConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class MainframeDialog extends JDialog {

    private final int padding = 5;

    public JPanel jpanelTop;
    public JLabel jlabelTopTitle;
    public JButton jbuttonTopRefreshImage;

    public JPanel jpanelMiddle;
    public JButton jbuttonJeff;
    public JTextArea jtextAreaJeffQuote;

    public MainframeDialog() {
        super();
        initComponents();
    }

    private void initComponents() {
        jlabelTopTitle = new JLabel();
        jlabelTopTitle.setText("JeffBot");
        jlabelTopTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlabelTopTitle.setVerticalAlignment(SwingConstants.CENTER);

        jbuttonTopRefreshImage = new JButton();
        ImageIcon refreshImage = new ImageIcon(new ImageIcon("src/resources/images/bits/Refresh_icon.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
        jbuttonTopRefreshImage.setIcon(refreshImage);
        jbuttonTopRefreshImage.setSize(15,15);
        jbuttonTopRefreshImage.setName("refresh");

        jpanelTop = new JPanel();
        jpanelTop.setLayout(new BoxLayout(jpanelTop, BoxLayout.X_AXIS));
        jpanelTop.add(Box.createHorizontalGlue());
        jpanelTop.add(jlabelTopTitle);
        jpanelTop.add(Box.createHorizontalGlue());
        jpanelTop.add(jbuttonTopRefreshImage);
        jpanelTop.add(Box.createHorizontalGlue());

        jbuttonJeff = new JButton();
        jbuttonJeff.setName("jeff");

        jtextAreaJeffQuote = new JTextArea();
        jtextAreaJeffQuote.setLineWrap(true);
        jtextAreaJeffQuote.setWrapStyleWord(true);

        jpanelMiddle = new JPanel();
        jpanelMiddle.setLayout(new BoxLayout(jpanelMiddle, BoxLayout.X_AXIS));
        jpanelMiddle.add(Box.createHorizontalGlue());
        jpanelMiddle.add(jbuttonJeff);
        jpanelMiddle.add(Box.createHorizontalGlue());
        jpanelMiddle.add(jtextAreaJeffQuote);
        jpanelMiddle.add(Box.createHorizontalGlue());

        double[][] dimensions = { { padding, TableLayoutConstants.PREFERRED, padding }, { padding, TableLayoutConstants.PREFERRED, padding, TableLayoutConstants.PREFERRED, padding }};
        setLayout(new TableLayout(dimensions));
        add(jpanelTop, "1,1");
        add(jpanelMiddle, "1,3");
    }

    /**
     *
     * @param jeffImage sets the jeff button to the input imageicon
     */
    public void setJeffImage(final ImageIcon jeffImage) {
        ImageIcon resizedJeffImage = new ImageIcon(jeffImage.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT));
        jbuttonJeff.setIcon(resizedJeffImage);
    }

    public void setJeffQuote(final String quote) {
        jtextAreaJeffQuote.setText(quote);
    }

    public void finalizeDialogLayout() {
        pack();
        setLocationRelativeTo(null);
    }

    public void addButtonListeners(final ActionListener al) {
        jbuttonTopRefreshImage.addActionListener(al);
        jbuttonJeff.addActionListener(al);
    }

    public void addWindowListeners(final WindowAdapter wa) {
        this.addWindowListener(wa);
    }

}
