package xmark.ui;

import xmark.lang.Language;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public interface UIUtilities {

    Font[] sysFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();

    /** The base color scheme used in the Editor Text Area. */
    Color BASE_COLOR_TEXT_EDIT = new Color(0x252725);

    /** The base color scheme used in the app panel. */
    Color BASE_COLOR = new Color(0x181818);

    static void loadFont(Font font) {}

    static void loadSysFont() {}

    static void loadLang(Language lang) {}
}
