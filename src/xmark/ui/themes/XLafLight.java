package xmark.ui.themes;

import com.formdev.flatlaf.FlatLightLaf;

public class XLafLight extends FlatLightLaf {

    public static boolean setup() {
        return setup(new XLafLight());
    }

    @Override
    public String getName() {
        return "XLafLight";
    }
}
