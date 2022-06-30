package xmark.ui;

import xmark.ui.themes.XMarkLookAndFeel;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
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

        // Adding part
        frm.setJMenuBar(mb);
        frm.add(new JToggleButton("Test"));

        XMarkLookAndFeel.setup();
        SwingUtilities.updateComponentTreeUI(frm);
        frm.setVisible(true);

        JOptionPane.showMessageDialog(frm, "Message", "Title", JOptionPane.ERROR_MESSAGE);
    }
}
