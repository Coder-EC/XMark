package xmark.ui.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public class XLafDark extends FlatDarkLaf {

    public static boolean setup() {
        return setup(new XLafDark());
    }

    @Override
    public String getName() {
        return "XLafDark";
    }
}
