package xmark.ui;

import net.miginfocom.swing.MigLayout;
import xmark.ui.themes.XMarkLookAndFeel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.Dimension;

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

    /** The text on the title bar that shows up current file. */
    public JLabel currFile = new JLabel("/User/test/Documents/demo.md");

    public static XFrame currFrame = new XFrame();

    /**
     * The original content pane on the frame. Is a holder of the title bar.
     */
    public JPanel contentPane = (JPanel) getContentPane();


    /**
     * The default constructor. No needs to manually pass in any arguments
     * because it automatically decorates the frame and sets up the title
     * bar. There are two private methods used in the constructor: {@code setUI()}
     * and {@code titleBar()}.
     */
    public XFrame() {
        setUI();
        testLAF();
    }

    private void setUI() {

        // Basic method settings
        setSize(new Dimension(1200, 750));
        setMinimumSize(new Dimension(120, 75));
        setLocationRelativeTo(null);
        setTitle(String.format("XMark - %s", currFile.getText()));
        setIconImage(new ImageIcon("src/img/icon.png").getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBackground(UIUtilities.BASE_COLOR);
        contentPane.setLayout(new MigLayout());

        // TODO Window translucency in UI settings
        // TODO Window wallpaper in UI settings

    }

    private void testLAF() {
        contentPane.add(new JButton("test"));
        contentPane.add(new JLabel("Test"));
        contentPane.add(new JTextField());
        contentPane.add(new JCheckBox("test"));
    }


    public static void main(String[] args) {
        XMarkLookAndFeel.setup();
        SwingUtilities.updateComponentTreeUI(currFrame);
        currFrame.setVisible(true);
    }

}
