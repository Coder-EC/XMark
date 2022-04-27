package com.xmark.ui;

import javax.swing.*;
import java.awt.*;

/**
 * This frame class is the base class of the frame app system. provides
 * the basic looking, allows the content panel to display. This frame
 * contains a self-made title bar, which has a "XMark" title on it, and
 * the path of current file in the editor. On the right side of the title
 * bar, omit three buttons of frame resizing: close, max and min. You
 * don't need to pass any arguments to the constructor, because it will
 * automatically fill in the title and the icon. The title bar will be
 * placed in the content pane because the frame is undecorated, meaning
 * there will be no extra border and title bar.
 * This class extends JFrame and uses its methods.
 *
 * @author Coder-EC, 2022/4/13 -
 * @version 1.0
 * @see javax.swing.JFrame
 */
public class XFrame extends JFrame {

    /** The original content pane on the frame. Is a holder of the title bar. */
    public JPanel contentPane = (JPanel) getContentPane();

    /** The base color scheme used in the app. */
    public static final Color BASE_COLOR = new Color(0x282626);

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
        setSize(new Dimension(1000, 750));
        setUndecorated(true);
        contentPane.setBackground(BASE_COLOR);
        contentPane.setLayout(new BorderLayout());

        // Sizing function & Min Max Close
    }

    private void titleBar() {

    }

    public static void main(String[] args) {
        new XFrame().setVisible(true);
    }
}
