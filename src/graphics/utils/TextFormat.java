package graphics.utils;

public final class TextFormat {
    // No additional formatting flags should be used.
    public final static int NONE = 0;
    // Indicates that the renderer should not use anti-aliasing when rendering the text.
    public final static int NO_ANTI_ALIASING = 1;
    // Indicates that the first line of the text should always be visible.
    public final static int FIRST_LINE_VISIBLE = 2;

    private TextFormat() {

    }

    public static boolean isEnabled(int format, int flag) {
        return (format &  flag) == flag;
    }
}
