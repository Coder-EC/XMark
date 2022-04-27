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

    public JPanel contentPane = (JPanel) getContentPane();
    public static final Color BASE_COLOR = new Color(0x232222);

    public XFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
    }

    private void setUI() {

    }

    private void titleBar() {

    }
}
