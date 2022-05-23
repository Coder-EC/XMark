package xmark.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 * This frame class is the base class of the frame app system. provides
 * the basic looking, allows the content panel to display. This frame
 * contains a self-made title bar, which has a "XMark" title on it, and
 * the path of current file in the editor. On the right side of the title
 * bar, are three buttons of frame resizing: close, max and min. You
 * don't need to pass any arguments to the constructor, because it will
 * automatically fill in the title and the icon. The title bar will be
 * placed in the content pane because the frame is undecorated, meaning
 * there will be no extra border and title bar. Note that additional
 * panels needs to be opaque when adding it. (Add it to {@code contentPane}.)
 * This class extends JFrame and uses its methods.
 *
 * @author Coder-EC, 2022/4/13 - 2022/5/10, 2022/5/ - 2022/
 * @version 1.0
 * @see javax.swing.JFrame
 */
public class XFrame extends JFrame {

    /** The original content pane on the frame. Is a holder of the title bar. */
    public JPanel contentPane = (JPanel) getContentPane();

    /**
     * The default constructor. No needs to manually pass in any arguments
     * because it automatically decorates the frame and sets up the title
     * bar. There are two private methods used in the constructor: {@code setUI()}
     * and {@code titleBar()}.
     */
    public XFrame() {
        setUI();
        titleBar();
    }

    private void setUI() {

        // Basic method settings
        setSize(new Dimension(1200, 750));
        setMinimumSize(new Dimension(120, 75));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBackground(UIUtilities.BASE_COLOR);
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

        // TODO Sizing function
    }

    private void titleBar() {

        contentPane.add(new TitleBar());
    }


    public static void main(String[] args) {
        new XFrame().setVisible(true);
    }

}
