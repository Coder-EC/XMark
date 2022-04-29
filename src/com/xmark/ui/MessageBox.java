package com.xmark.ui;

public final class MessageBox {

    public static final int OK_BUTTON       = 0;
    public static final int CANCEL_BUTTON   = 1;
    public static final int RETRY_BUTTON    = 2;
    public static final int CONFIRM_BUTTON  = 3;

    private MessageBox() {}

    public static int info(String title, String text, int... btns) {
        return 0;
    }

    public static int warn(String title, String text, int... btns) {
        return 0;
    }

    public static int fatal(String title, String text, int... btns) {
        return 0;
    }
}
