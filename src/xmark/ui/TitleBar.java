package xmark.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The tile bar on the basic frame. Located on the left, with a big title,
 * current file path, and three frame resizing buttons. It is on the
 * original content pane, with a "Menu Bar" on the right. This design can
 * solve the problem of frame size over-use. When current file path is too
 * long that the title bar can't be normally displayed, it will use "..." to
 * replace the over-long part in the file path, so it won't affect the menu
 * bar to display.
 *
 * @author Coder-EC, 2022/5/20 - 2022/5/23
 * @version 1.0
 * @see javax.swing.JPanel
 * @see xmark.ui.XFrame
 */
public class TitleBar extends JPanel {

    /** The current main frame. */
    XFrame currFrame = (XFrame) Frame.getFrames()[0];

    /** The text on the title bar that shows up current file. */
    public JLabel currFile = new JLabel("/User/test/Documents/demo.md");

    public TitleBar() {
        makeUI();
        activateMove();
    }

    private void activateMove() {
        addMouseMotionListener(new MouseAdapter() {

            boolean top = false;
            boolean down = false;
            boolean left = false;
            boolean right = false;
            Point draggingAnchor = null;

            @Override
            public void mouseMoved(MouseEvent e) {
                draggingAnchor = new Point(e.getX() + getX(), e.getY() + getY());
                top = false;
                down = false;
                left = false;
                right = false;
            }

            @Override
            public void mouseDragged(MouseEvent e) {

                currFrame.setLocation(e.getLocationOnScreen().x - draggingAnchor.x, e.getLocationOnScreen().y - draggingAnchor.y);

            }
        });
    }

    private void makeUI() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 7, 5));

        // Title bar style settings
        setBackground(Color.BLACK);

        // Title bar panel ui
        JLabel title = new JLabel("XMark");
        XButton close = new XButton("×");
        XButton min = new XButton("-");
        XButton max = new XButton("+");

        title.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        title.setForeground(new Color(0xEDEDED));

        currFile.setFont(new Font("Microsoft YaHei", Font.PLAIN, 11));
        currFile.setForeground(new Color(0xCBCBCB));

        close.addActionListener(e -> System.exit(0));
        min.addActionListener(e -> currFrame.setExtendedState(
                Frame.ICONIFIED | currFrame.getExtendedState()));

        max.addActionListener(e -> {
            if (max.clickCount % 2 == 0) {
                currFrame.setExtendedState(Frame.MAXIMIZED_HORIZ | Frame.MAXIMIZED_VERT);
            } else {
                currFrame.setExtendedState(Frame.NORMAL);
            }
            max.clickCount++;
        });

        add(title);
        add(currFile);
        add(min);
        add(max);
        add(close);

    }

}
