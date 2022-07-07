package xmark.ui;

import javax.swing.JToggleButton;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class XToggleButton extends JToggleButton {

    public XToggleButton(int width, int height) {
        setText("OFF");
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int height = getHeight();
        int width = getWidth();
        boolean selected = this.isSelected();

        if (selected) {
            setText("ON");
            if (UIManager.getLookAndFeel().getName().equals("XLafLight")) {
                g2d.setColor(new Color(0x9BB3FF));
            } else {
                g2d.setColor(new Color(0x00FFFF));
            }
            g2d.fillRoundRect(0, 0, width, height, 15, 15);
        } else {
            setText("OFF");
            g2d.setColor(Color.BLACK);
            g2d.fillRoundRect(0, 0, width, height, 15, 15);
        }

        super.paintComponent(g);

    }
}
