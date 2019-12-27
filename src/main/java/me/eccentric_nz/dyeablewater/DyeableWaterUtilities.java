package me.eccentric_nz.dyeablewater;

import org.bukkit.Color;
import org.bukkit.Material;

public class DyeableWaterUtilities {

    public static int getKey(Material material, int level) {
        switch (material) {
            case WHITE_DYE:
                return level;
            case ORANGE_DYE:
                return 10 + level;
            case MAGENTA_DYE:
                return 20 + level;
            case YELLOW_DYE:
                return 30 + level;
            case LIGHT_BLUE_DYE:
                return 40 + level;
            case LIME_DYE:
                return 50 + level;
            case PINK_DYE:
                return 60 + level;
            case GRAY_DYE:
                return 70 + level;
            case LIGHT_GRAY_DYE:
                return 80 + level;
            case CYAN_DYE:
                return 90 + level;
            case PURPLE_DYE:
                return 100 + level;
            case BLUE_DYE:
                return 110 + level;
            case BROWN_DYE:
                return 120 + level;
            case GREEN_DYE:
                return 130 + level;
            case RED_DYE:
                return 140 + level;
            case BLACK_DYE:
                return 150 + level;
            default:
                return 0;
        }
    }

    public static Color getColor(int i) {
        switch (i) {
            case 0:
                return Color.WHITE;
            case 10:
                return Color.ORANGE;
            case 20:
                return Color.MAROON;
            case 30:
                return Color.YELLOW;
            case 40:
                return Color.AQUA;
            case 50:
                return Color.LIME;
            case 60:
                return Color.FUCHSIA;
            case 70:
                return Color.GRAY;
            case 80:
                return Color.SILVER;
            case 90:
                return Color.TEAL;
            case 100:
                return Color.PURPLE;
            case 110:
                return Color.BLUE;
            case 120:
                return Color.OLIVE;
            case 130:
                return Color.GREEN;
            case 140:
                return Color.RED;
            case 150:
                return Color.BLACK;
        }
        return null;
    }

    public static String getColorName(int i) {
        switch (i) {
            case 0:
                return "White";
            case 10:
                return "Orange";
            case 20:
                return "Magenta";
            case 30:
                return "Yellow";
            case 40:
                return "Light Blue";
            case 50:
                return "Lime";
            case 60:
                return "Pink";
            case 70:
                return "Gray";
            case 80:
                return "Lihgt Gray";
            case 90:
                return "Cyan";
            case 100:
                return "Purple";
            case 110:
                return "Blue";
            case 120:
                return "Brown";
            case 130:
                return "Green";
            case 140:
                return "Red";
            case 150:
                return "Black";
        }
        return "";
    }
}
