package ru.inofttech.navi;
import java.util.regex.Matcher;

public class GGAField extends NMEAField {

    private String utcTime; //Время UTC определения координат
    private String latitude; // Широта С/Ю
    private String longitude; // Долгота З/В
    private String receiverMode; // режим работы приемника
    private String numberOfSatellites; // число спутников участвующих в решении
    private String hdop; // HDOP
    private String altitude; // высота над средним уровнем моря, м
    private String heightAboveTheGeoid; // высота над геоидом, м
    private String ageOfDifferentialCorrections; // возраст дифференциальных поправок
    private String iDofDifferentialStation; // ID дифференциальной станции

    public GGAField(String textField) {
        super(textField);

        Matcher matcher = NMEAField.PATTERN_GGA.matcher(textField);
        if (matcher.find()) {
            utcTime = matcher.group(2);
            latitude = matcher.group(3) + matcher.group(4);
            longitude = matcher.group(5) + matcher.group(6);
            receiverMode = matcher.group(7);
            numberOfSatellites = matcher.group(8);
            hdop = matcher.group(9);
            altitude = matcher.group(10) + matcher.group(11);
            heightAboveTheGeoid = matcher.group(12) + matcher.group(13);
            ageOfDifferentialCorrections = matcher.group(14);
            iDofDifferentialStation = matcher.group(15);
        }
    }
    public String getUTCTime() {
        return utcTime;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }

    public String getReceiverMode() {
        return receiverMode;
    }

    public String getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public String getHDOP() {
        return hdop;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getHeightAboveTheGeoid() {
        return heightAboveTheGeoid;
    }

    public String getAgeOfDifferentialCorrections() {
        return ageOfDifferentialCorrections;
    }

    public String getiDofDifferentialStation() {
        return iDofDifferentialStation;
    }







}
