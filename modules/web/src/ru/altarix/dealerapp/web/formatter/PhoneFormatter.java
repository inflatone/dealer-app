package ru.altarix.dealerapp.web.formatter;

import java.util.function.Function;

public class PhoneFormatter implements Function<String, String> {
    public static final String PHONE_PREFIX = "7 495 ";

    @Override
    public String apply(String value) {
        return value == null || value.length() != 7 ? "" :
                PHONE_PREFIX + value.replaceFirst("(\\d{3})(\\d{2})(\\d{2})", "$1 $2 $3");
    }
}
