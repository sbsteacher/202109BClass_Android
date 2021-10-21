package com.koreait.first;

import android.util.Log;

public class Utils {

    public static int parseStringToInt(String val) {
        return parseStringToInt(val, 0);
    }

    public static int parseStringToInt(String val, int defVal) {
        try {
            return Integer.parseInt(val);
        } catch(Exception e) {
            return defVal;
        }
    }

    public static String getNumberComma(int val) {
        return String.format("%,d", val);
    }

    public static String getNumberComma(String val) {
        int intVal = parseStringToInt(val);
        return getNumberComma(intVal);
    }
}
