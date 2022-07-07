package xmark.ui;

import xmark.ui.themes.XLafDark;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.KeyEvent;

public class TestUI {

    public static void main(String[] args) {

        XFrame frm = new XFrame("Test");

        // Menu part
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Test");
        m.setMnemonic(KeyEvent.VK_T);
        JMenuItem mi1 = new JMenuItem("A Simple MenuItem");
        m.add(mi1);
        m.addSeparator();
        JCheckBoxMenuItem mi2 = new JCheckBoxMenuItem("MenuItem with a CheckBox");
        m.add(mi2);
        JRadioButtonMenuItem mi3 = new JRadioButtonMenuItem("MenuItem with a RadioButton");
        m.add(mi3);
        mb.add(m);

        JComboBox<String> cb = new JComboBox<>();
        cb.putClientProperty("JComponent.roundRect", true);

        JButton bt = new JButton("Test");
        bt.setToolTipText("A Simple Test Button");

        // Adding part
        frm.setJMenuBar(mb);
        frm.add(bt);
        frm.add(new XToggleButton(50, 20));
        frm.add(new JTextField());
        frm.add(new JScrollBar());
        frm.add(cb);

        XLafDark.setup();
//        frm.setBgLight();
        SwingUtilities.updateComponentTreeUI(frm);
        frm.setVisible(true);

    }
}
