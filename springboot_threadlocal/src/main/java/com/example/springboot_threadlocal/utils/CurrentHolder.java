package com.example.springboot_threadlocal.utils;

public class CurrentHolder {
    private static final ThreadLocal<String> CURRENT_LOCAL = new ThreadLocal<>();

    public static void setCurrent(String text1) {
        CURRENT_LOCAL.set(text1);
    }

    public static String getCurrent() {
        return CURRENT_LOCAL.get();
    }

    public static void removeCurrent() {
        CURRENT_LOCAL.remove();
    }
}
