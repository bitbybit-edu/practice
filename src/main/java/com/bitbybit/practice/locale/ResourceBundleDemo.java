package com.bitbybit.practice.locale;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {
    public static void main(String[] args) {
        Locale locale = Locale.US;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("internationalization.message.message", locale);
        String info = resourceBundle.getString("info");
        System.out.println(MessageFormat.format(info, "liulin"));
    }
}
