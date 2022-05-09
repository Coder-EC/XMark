package com.xmark.ui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * This frame class is the base class of the frame app system. provides
 * the basic looking, allows the content panel to display. This frame
 * contains a self-made title bar, which has a "XMark" title on it, and
 * the path of current file in the editor. On the right side of the title
 * bar, omit three buttons of frame resizing: close, max and min. You
 * don't need to pass any arguments to the constructor, because it will
 * automatically fill in the title and the icon. The title bar will be
 * placed in the content pane because the frame is undecorated, meaning
 * there will be no extra border and title bar. Note that additional
 * panels needs to be opaque when adding it. (Add it to {@code contentPane}.)
 * This class extends JFrame and uses its methods.
 *
 * @author Coder-EC, 2022/4/13 -
 * @version 1.0
 * @see javax.swing.JFrame
 */
public class XFrame extends JFrame {

    /** The original content pane on the frame. Is a holder of the title bar. */
    public JPanel contentPane = (JPanel) getContentPane();

    /** The base color scheme used in the Editor Text Area. */
    public static final Color BASE_COLOR_TEXT = new Color(0x252725);

    /** The base color scheme used in tha app panel. */
    public static final Color BASE_COLOR = new Color(0x181818);

    /** The text on the title bar that shows up current file. */
    public JLabel currFile = new JLabel();

    private final JPanel titleBar = new JPanel(new FlowLayout());

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
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBackground(BASE_COLOR);
        contentPane.setLayout(new BorderLayout());

        // Sizing function
    }

    private void titleBar() {

        // Title bar style settings
        titleBar.setBackground(Color.BLACK);

        // Title bar panel ui
        JLabel title = new JLabel("XMark");
        XButton close = new XButton("×");
        XButton min = new XButton("-");
        XButton max = new XButton("+");
        ImageIcon titleIcon = new ImageIcon("../../../../img/icon.ico");
        JLabel titleIconLabel = new JLabel((Icon) titleIcon.getImage());  // FIXME ClassCastException

        title.setFont(new Font("Calibri Light", Font.PLAIN, 16));
        title.setBackground(new Color(0xEDEDED));

        titleBar.add(titleIconLabel);
        titleBar.add(title);
        titleBar.add(currFile);
        titleBar.add(close);
        titleBar.add(min);
        titleBar.add(max);

        contentPane.add(titleBar, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new XFrame().setVisible(true);
    }
}
