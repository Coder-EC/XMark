package com.xmark.ui;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

public class TitleBar extends JPanel {

    /** The text on the title bar that shows up current file. */
    public JLabel currFile = new JLabel("demo");

    public TitleBar() {
        makeUI();
    }

    private void makeUI() {

        setLayout(new FlowLayout());

        // Title bar style settings
        setBackground(Color.BLACK);

        // Title bar panel ui
        JLabel title = new JLabel("XMark");
        XButton close = new XButton("×");
        XButton min = new XButton("-");
        XButton max = new XButton("+");
        ImageIcon titleIcon = new ImageIcon("../../../../img/icon.ico");
        JLabel titleIconLabel = new JLabel(titleIcon);

        title.setFont(new Font("Dialog", Font.PLAIN, 16));
        title.setForeground(new Color(0xEDEDED));

        close.addActionListener(e -> System.exit(0));
        min.addActionListener(e -> Frame.getFrames()[0].setExtendedState(Frame.ICONIFIED));
        max.addActionListener(e -> Frame.getFrames()[0].setExtendedState(Frame.MAXIMIZED_BOTH));

        add(titleIconLabel);
        add(title);
        add(Box.createHorizontalGlue());
        add(currFile);
        add(close);
        add(min);
        add(max);

    }
}
