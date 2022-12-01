package com.codegym.validate;

public class Validate {
    public static boolean checkFileType(String fileName) {
        String regexFileName = "^[\\w-\\.]+\\.(mp3|wav|ogg|m4p)$";
        return fileName.matches(regexFileName);
    }
}
