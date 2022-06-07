package xmark.ui.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public class XMarkLookAndFeel extends FlatDarkLaf {

    public static boolean setup() {
        return setup(new XMarkLookAndFeel());
    }

    @Override
    public String getName() {
        return "XMarkLookAndFeel";
    }
}
