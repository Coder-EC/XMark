package xmark.ui.themes;

import com.formdev.flatlaf.ui.FlatToolTipUI;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.StringUtils;
import sun.swing.SwingUtilities2;

import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.List;

public class ToolTipUI extends FlatToolTipUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        if (isMultiLine(c)) {
            FontMetrics fm = c.getFontMetrics(c.getFont());
            Insets insets = c.getInsets();
            g.setColor(c.getForeground());
            List<String> lines = StringUtils.split(((JToolTip)c).getTipText(), '\n');
            int x = insets.left + 3;
            int x2 = c.getWidth() - insets.right - 3;
            int y = insets.top - fm.getDescent();
            int lineHeight = fm.getHeight();
            JComponent comp = ((JToolTip)c).getComponent();
            boolean leftToRight = (comp != null ? comp : c).getComponentOrientation().isLeftToRight();

            for (String line : lines) {
                y += lineHeight;
                FlatUIUtils.drawString(c, g, line, leftToRight ? x : x2 - SwingUtilities.computeStringWidth(fm, line), y);
            }
        } else {
            Font font = c.getFont();
            FontMetrics metrics = SwingUtilities2.getFontMetrics(c, g, font);
            Dimension size = c.getSize();

            g.setColor(c.getForeground());
            // fix for bug 4153892
            String tipText = ((JToolTip)c).getTipText();
            if (tipText == null) {
                tipText = "";
            }

            Insets insets = c.getInsets();
            Rectangle paintTextR = new Rectangle(
                    insets.left + 3,
                    insets.top,
                    size.width - (insets.left + insets.right) - 6,
                    size.height - (insets.top + insets.bottom));
            View v = (View) c.getClientProperty(BasicHTML.propertyKey);
            if (v != null) {
                v.paint(g, paintTextR);
            } else {
                g.setFont(font);
                SwingUtilities2.drawString(c, g, tipText, paintTextR.x,
                        paintTextR.y + metrics.getAscent());
            }
        }
    }

    private boolean isMultiLine(JComponent c) {
        String text = ((JToolTip)c).getTipText();
        return c.getClientProperty("html") == null && text != null && text.indexOf(10) >= 0;
    }
}
