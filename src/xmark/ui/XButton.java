package xmark.ui;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Button UI class. A button is the most basic and most important component in
 * a GUI application. User can click on the button to perform some actions. This
 * button class is a custom class that extends JButton. It overrides the
 * {@code getBackground()} method. It is painted by {@code paintComponent()} method.
 * Due to {@code paintComponent()} is overridden, so the original background color
 * will not work. Caller must manually create a bg color for a button. The given
 * background will be used when painting component. This button also supports animation
 * settings.
 *
 * @author EC, 2022/5/11 - 2022/5/23
 * @version 1.0
 * @see javax.swing.JButton
 * @see javax.swing.DefaultButtonModel
 */
public class XButton extends JButton {

    /** The click count of each XButton. Can be used in title bar or status judgement. */
    public int clickCount;

    private final DefaultButtonModel model = (DefaultButtonModel) getModel();

    /** Background color for a button. Can be passed in by the constructor. */
    private Color bgColor = new Color(35, 35, 35);

    private boolean animate;  // TODO Flag value for settings -> app animation

    /**
     * The default constructor. Constructs a XButton with an initial text on it.
     * If there's no background color, the button will be transparent. (On the
     * default content pane because the default bg is as same as content pane color.)
     *
     * @param text The initial text to display on the button.
     */
    public XButton(String text) {
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(45, 20));
        setBorderPainted(false);
        setFocusPainted(false);
        setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        setForeground(new Color(255, 255, 255));
        setVerticalTextPosition(getY() / 2);
        setText(text);
    }

    /**
     * Same constructor as {@code public XButton(String text)} but with bgColor.
     * Overload version of the default constructor.
     *
     * @param text The initial text to display on the button.
     * @param bgColor The default background color of the button.
     * @see xmark.ui.XButton
     */
    public XButton(String text, Color bgColor) {
        this(text);
        this.bgColor = bgColor;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(bgColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(0, 0, 45, 20, 10, 10);

        if (!isEnabled()) {
            setForeground(Color.GRAY);
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRoundRect(0, 0, 45, 20, 10, 10);

        } else if (model.isRollover()) {
            if (getText().equals("×")) {
                setForeground(new Color(0xFFFFFF));
                g2d.setColor(Color.RED);
                g2d.fillRoundRect(0, 0, 45, 20, 10, 10);
            } else {
                setForeground(new Color(0xFFFFFF));
                g2d.setColor(new Color(0x666666));
                g2d.fillRoundRect(0, 0, 45, 20, 10, 10);
            }

        } else if (model.isPressed()) {
            setForeground(new Color(0xFFFFFF));
            g2d.setColor(new Color(0xAAAAAA - 10));
            g2d.fillRoundRect(0, 0, 45, 20, 10, 10);
        }

        super.paintComponent(g);

    }

    @Override
    public Color getBackground() {
        return bgColor;
    }

    @Override
    public void setBackground(Color c) {
        this.bgColor = c;
    }

    public boolean getAnimate() {
        return animate;
    }

    public void setAnimate(boolean value) {
        this.animate = value;
    }

}
