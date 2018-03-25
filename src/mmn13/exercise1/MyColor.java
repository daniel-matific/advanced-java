package mmn13.exercise1;

import java.awt.Color;

public enum MyColor {

    Cyan(Color.cyan), Magenta(Color.magenta), Yellow(Color.yellow),
    Red(Color.red), Green(Color.green), Blue(Color.blue), Black(Color.black),
    White(Color.white), Gray(Color.gray), DarkGray(Color.darkGray), LightGray(Color.lightGray),
    Orange(Color.orange), Pink(Color.pink);

    private final Color color;

    private MyColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}