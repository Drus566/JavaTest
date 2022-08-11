package graphics.example.textfonts;

/*
There are two types of fonts: physical and logical.
Physical fonts are the actual font libraries.
Logical fonts are the five font families defined by the Java platform: Serif, SansSerif, Monospaced, Dialog, and DialogInput.

Logical fonts are not actual font libraries.
Logical font names are mapped to physical fonts by the Java runtime environment.
 */

import javax.swing.*;
import java.awt.*;


public class AllFontsEx extends JFrame {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();

        // выводит все шрифты
        // Unix, OS X, and Windows platform differ
        for (Font font : fonts) {
            System.out.println(font.getFontName() + " : ");
            System.out.println(font.getFamily());
        }
    }
}
