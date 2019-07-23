package ru.inofttech.navigator;
import java.util.regex.Matcher;
/**
 * Класс реализующий работу с полем GGA протокола NMEA.
 * @author Nikita Demakov (demakoffnik@gmail.com)
 * @since 24.07.2019
 * @version 1
 */

public class GGAField extends NMEAField {
    /**
     * Время UTC определения координат
    */
    public String utcTime;
    /** Широта С/Ю*/
    public String latitude;
    /** Долгота З/В*/
    public String longitude;
    /** режим работы приемника*/
    public String receiverMode;
    /** число спутников участвующих в решении навигационной задачи*/
    public String numberOfSatellites;
    /** HDOP*/
    public String hdop;
    /**высота над средним уровнем моря, м*/
    public String altitude;
    /**высота над геоидом, м*/
    public String heightAboveTheGeoid;
    /**возраст дифференциальных поправок*/
    public String ageOfDifferentialCorrections;
    /**ID дифференциальной станции*/
    public String iDofDifferentialStation;

    /**
     * Создает объект, представляющий поле GGA, зависящее от текстовых данных NMEA,
     * пришедших с навигационного приемника
     * @param textField строка текстовых данных протокола NMEA
     */

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
    /**
     * Возвращает время UTC
     */
    public String getUTCTime() {
        return utcTime;
    }
    /**
     * Возвращает Широту
     */
    public String getLatitude() {
        return latitude;
    }
    /**
     * Возвращает Долготу
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Возвращает режим работы приёмника
     */
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
