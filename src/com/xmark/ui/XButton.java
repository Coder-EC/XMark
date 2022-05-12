package com.xmark.ui;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
 * @author EC, 2022/5/11 -
 * @version 1.0
 * @see javax.swing.JButton
 * @see javax.swing.DefaultButtonModel
 */
public class XButton extends JButton {

    private final DefaultButtonModel model = (DefaultButtonModel) getModel();

    private Color bgColor;
    private boolean animate;  // TODO Flag value for settings -> app animation

    public XButton(String text) {
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(50, 30));
        setBorderPainted(false);
        setFocusPainted(false);
        setFont(new Font("Dialog", Font.PLAIN, 12));
        setForeground(new Color(255, 255, 255));
        setText(text);
    }

    public XButton(String text, Color bgColor) {
        this(text);
        this.bgColor = bgColor;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(bgColor);
    }

    @Override
    public Color getBackground() {
        return bgColor;
    }

    public boolean getAnimate() {
        return animate;
    }

    public void setAnimate(boolean value) {
        this.animate = value;
    }
}
