package ru.inofttech.navigator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NMEAField {
    public static final Pattern PATTERN_GGA = Pattern.compile("^\\$([A-Z][A-Z])GGA,"
            + "(\\d+\\.\\d+)?,(\\d+\\.\\d+)?,"
            + "(\\w)?,(\\d+\\.\\d+)?,(\\w)?,(\\d)?,"
            + "(\\d+)?,(\\d+\\.\\d+)?,(\\d+\\.\\d+)?,"
            + "(\\w)?,(\\d+\\.\\d+)?,(\\w)?,(\\d+\\.\\d+)?,"
            + "(.+)?\\*([A-F0-9][A-F0-9])?$");;
    public static final Pattern PATTERN_GLL = Pattern.compile("^\\$([A-Z][A-Z])GLL,"
            + "(\\d+\\.\\d+)?,(\\w)?,(\\d+\\.\\d+)?,(\\w)?,"
            + "(\\d+\\.\\d+)?,(\\w)?,\\w\\*([A-F0-9][A-F0-9])?$");
    public static final Pattern PATTERN_FOR_NMEA = Pattern.compile("^\\$(\\w+)?,(.+)?\\*([A-F0-9][A-F0-9])?$");
    private String idOfMessage;
    private String textField;



    public NMEAField(String textField) {
        this.textField = textField;
        Matcher matcher = PATTERN_FOR_NMEA.matcher(textField);
        if (matcher.find()) {
            idOfMessage = matcher.group(3);
        }


    }

    public String getTextField() {
        return textField;
    }

    public String getIdOfMessage() {
        return idOfMessage;
    }
    public static String getTypeOfMessage(String message) {
        Matcher matcher = PATTERN_FOR_NMEA.matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "null";
        }
    }
}
