package ru.inofttech.navigator;

import java.util.regex.Matcher;

public class GLLField extends NMEAField {
    private String latitude;
    private String longitude;
    private String utctime;
    private String status;
    private String modeIndicator;
    public GLLField(String textField) {
        super(textField);
        Matcher matcher = NMEAField.PATTERN_GLL.matcher(textField);
        if (matcher.find()) {
            latitude = matcher.group(2) + matcher.group(3);
            longitude = matcher.group(4) + matcher.group(5);
            utctime = matcher.group(6);
            status = matcher.group(7);
            modeIndicator = matcher.group(8);

        }
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getUtctime() {
        return utctime;
    }

    public String getStatus() {
        return status;
    }

    public String getModeIndicator() {
        return modeIndicator;
    }
}
