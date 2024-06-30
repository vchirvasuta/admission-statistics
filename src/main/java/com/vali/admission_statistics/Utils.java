package com.vali.admission_statistics;

public class Utils {

    public static double customDoubleParser(String str) {
        if (str == null) {
            return 0.0;
        }

        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public static int customIntegerParser(String str) {
        if (str == null) {
            return 0;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
