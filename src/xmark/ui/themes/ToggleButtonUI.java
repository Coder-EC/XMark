package xmark.ui.themes;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatButtonUI;
import com.formdev.flatlaf.ui.FlatToggleButtonUI;
import com.formdev.flatlaf.util.UIScale;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.plaf.ButtonUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ToggleButtonUI extends FlatToggleButtonUI {

    public static String buttonType = "toggleButton";

    public ToggleButtonUI(boolean shared) {
        super(shared);
    }

    @Override
    protected void paintBackground(Graphics g, JComponent c) {
        if (isTabButton(c)) {
            int height = c.getHeight();
            int width = c.getWidth();
            boolean selected = ((AbstractButton)c).isSelected();
            Color enabledColor = selected ? FlatClientProperties.clientPropertyColor(c, "JToggleButton.tab.selectedBackground", this.tabSelectedBackground) : null;
            Color background;
            if (enabledColor == null) {
                background = c.getBackground();
                if (this.isCustomBackground(background)) {
                    enabledColor = background;
                }
            }

            background = buttonStateColor(
                    c, enabledColor, null, this.tabFocusBackground, this.tabHoverBackground, null);
            if (background != null) {
                g.setColor(background);
                g.fillRect(0, 0, width, height);
            }

            if (selected) {
                int underlineThickness = UIScale.scale(FlatClientProperties.clientPropertyInt(
                        c, "JToggleButton.tab.underlineHeight", this.tabUnderlineHeight));
                g.setColor(c.isEnabled() ?
                        FlatClientProperties.clientPropertyColor(c, "JToggleButton.tab.underlineColor", this.tabUnderlineColor)
                        : this.tabDisabledUnderlineColor);
                int placement = FlatClientProperties.clientPropertyInt(c, "JToggleButton.tab.underlinePlacement", 3);
                switch (placement) {
                    case 1 -> g.fillRect(0, 0, width, underlineThickness);
                    case 2 -> g.fillRect(0, 0, underlineThickness, height);
                    case 3, default -> g.fillRect(0, height - underlineThickness, width, underlineThickness);
                    case 4 -> g.fillRect(width - underlineThickness, 0, underlineThickness, height);
                }
            }
        } else {

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int height = c.getHeight();
            int width = c.getWidth();
            boolean selected = ((AbstractButton)c).isSelected();

            if (selected) {
                g2d.setColor(selectedBackground);
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.fillRoundRect(0, 0, width, height, 100, 100);
            g2d.setColor(Color.WHITE);
            g2d.fillOval(width - 1, height - 1, width - width / 2, height - height / 2);
        }
    }

    static boolean isTabButton(Component c) {
        return c instanceof JToggleButton && "tab".equals(getButtonTypeStr((JToggleButton)c));
    }

    static String getButtonTypeStr(AbstractButton c) {
        Object value = c.getClientProperty("JButton.buttonType");
        if (value instanceof String) {
            return (String)value;
        } else {
            ButtonUI ui = c.getUI();
            return ui instanceof FlatButtonUI ? buttonType : null;
        }
    }
}
