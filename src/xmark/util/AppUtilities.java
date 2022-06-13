package xmark.util;

import xmark.lang.Language;
import xmark.ui.CoreTextEditPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

public interface AppUtilities {

    /** The base color scheme used in the Editor Text Area. */
    Color BASE_COLOR_TEXT_EDIT = new Color(0x252725);

    /** The base color scheme used in the app panel. */
    Color BASE_COLOR = new Color(0x181818);

    static void loadFont(Font font) {}

    static void loadSysFont() {}

    static void loadLang(Language lang) {}

    static void enableDnD(Component comp1, Component comp2) {}

    static void enableSyntaxAnalyze(CoreTextEditPane textEditPane) {}

}
