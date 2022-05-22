package com.xmark.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

public class TitleBar extends JPanel {

    /** The text on the title bar that shows up current file. */
    public JLabel currFile = new JLabel("/User/test/Documents/demo.md");

    public TitleBar() {
        makeUI();
    }

    private void makeUI() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 7, 5));

        // Title bar style settings
        setBackground(Color.BLACK);
        setMaximumSize(new Dimension(500, 1));

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
        min.addActionListener(e -> Frame.getFrames()[0].setExtendedState(Frame.ICONIFIED));
        max.addActionListener(e -> {
            if (!max.getClick()) {
                Frame.getFrames()[0].setExtendedState(Frame.NORMAL);
                max.setClick(true);
            } else {
                Frame.getFrames()[0].setExtendedState(Frame.MAXIMIZED_BOTH);
                max.setClick(false);
            }
        });

        add(title);
        add(currFile);
        add(min);
        add(max);
        add(close);

    }

}
