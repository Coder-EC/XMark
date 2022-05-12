package com.xmark.ui;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

public class TitleBar extends JPanel {

    /** The text on the title bar that shows up current file. */
    public JLabel currFile = new JLabel("demo");

    public TitleBar() {
        makeUI();
    }

    private void makeUI() {

        setLayout(null);

        // Title bar style settings
        setBackground(Color.BLACK);

        // Title bar panel ui
        JLabel title = new JLabel("XMark");
        XButton close = new XButton("×");
        XButton min = new XButton("-");
        XButton max = new XButton("+");
        ImageIcon titleIcon = new ImageIcon("../../../../img/icon.ico");
        JLabel titleIconLabel = new JLabel(titleIcon);

        title.setFont(new Font("Calibri Light", Font.PLAIN, 16));
        title.setForeground(new Color(0xEDEDED));

        add(titleIconLabel);
        add(title);
        add(Box.createHorizontalGlue());
        add(currFile);
        add(close);
        add(min);
        add(max);

    }
}
