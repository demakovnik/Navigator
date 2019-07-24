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
    private String utcTime;
    /** Широта С/Ю*/
    private String latitude;
    /** Долгота З/В*/
    private String longitude;
    /** режим работы приемника*/
    private String receiverMode;
    /** число спутников участвующих в решении навигационной задачи*/
    private String numberOfSatellites;
    /** Снижение точности в горизонтальной плоскости*/
    private String hdop;
    /**высота над средним уровнем моря, м*/
    private String altitude;
    /**высота над геоидом, м*/
    private String heightAboveTheGeoid;
    /**возраст дифференциальных поправок*/
    private String ageOfDifferentialCorrections;
    /**ID дифференциальной станции*/
    private String iDofDifferentialStation;

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

    /**
     * Возвращает число спутников участвующих в решении навигационной задачи
     */
    public String getNumberOfSatellites() {
        return numberOfSatellites;
    }

    /**
     * Возвращает снижение точности в горизонтальной плоскости
     */
    public String getHDOP() {
        return hdop;
    }

    /**Возвращает высоту над средним уровнем моря, м*/
    public String getAltitude() {
        return altitude;
    }

    /**Возвращает высоту над геоидом, м*/
    public String getHeightAboveTheGeoid() {
        return heightAboveTheGeoid;
    }

    /**Возвращает возраст дифференциальных поправок*/
    public String getAgeOfDifferentialCorrections() {
        return ageOfDifferentialCorrections;
    }

    /**Возвращает ID дифференциальной станции*/
    public String getiDofDifferentialStation() {
        return iDofDifferentialStation;
    }
}
