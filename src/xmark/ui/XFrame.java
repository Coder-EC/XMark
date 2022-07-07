package xmark.ui;

import net.miginfocom.swing.MigLayout;
import xmark.ui.themes.XLafDark;
import xmark.util.AppUtilities;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.WindowConstants;
import java.awt.Color;
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
 * @author Coder-EC
 * @version 1.0
 * @see javax.swing.JFrame
 */
public class XFrame extends JFrame {

    private LookAndFeel mainLF = new XLafDark();

    /** The text on the title bar that shows up current file. */
    public JLabel currFile = new JLabel("/User/test/Documents/demo.md");

    /**
     * The original content pane on the frame. Is a holder of the title bar.
     */
    public JPanel contentPane = (JPanel) getContentPane();


    /**
     * The default constructor. No needs to manually pass in any arguments
     * because it automatically decorates the frame and sets up the title
     * bar. Two private methods used in the constructor: {@code setUI()}
     * and {@code titleBar()}.
     */
    public XFrame() {
        setUI();
    }

    public XFrame(String title) {
        this();
        setTitle(title);
    }


    private void setUI() {

        // Basic method settings
        setSize(new Dimension(1200, 750));
        setMinimumSize(new Dimension(120, 75));
        setLocationRelativeTo(null);
        setTitle(String.format("XMark - %s", currFile.getText()));
        setIconImage(new ImageIcon("src/img/icon.png").getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBackground(AppUtilities.BASE_COLOR);
        contentPane.setLayout(new MigLayout());

        // TODO Window wallpaper in UI settings

    }

    public void setBgLight() {
        contentPane.setBackground(new Color(0xFFFFFF));
    }


    public LookAndFeel getMainLF() {
        return mainLF;
    }

    public void setMainLF(LookAndFeel mainLF) {
        this.mainLF = mainLF;
    }
}
