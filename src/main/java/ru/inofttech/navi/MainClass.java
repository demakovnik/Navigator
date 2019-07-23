package ru.inofttech.navi;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    private static SerialPort serialPort;
    private static String str = "";
    private static List<String> list = new ArrayList<String>();
    private static int count = 0;
    private static GGAField ggaField;
    private static GLLField gllField;

    public static void main(String[] args) throws SerialPortException {

        serialPort = new SerialPort(args[0]);

        //Открытие порта
        serialPort.openPort();
        //Задание параметров порта

        serialPort.setParams(9600,
                8,
                1,
                0);

        serialPort.addEventListener(new PortReader());


    }

    private static class PortReader implements SerialPortEventListener {

        public void serialEvent(SerialPortEvent serialPortEvent) {

            if (serialPortEvent.isRXCHAR() && serialPortEvent.getEventValue() > 0) {
                try {
                    //Получаем ответ от устройства, обрабатываем данные и т.д.
                    String data = serialPort.readString();
                    str += data;
                    if (str.contains("\r\n")) {
                        new Routine(str).start();
                        str = "";
                    }


                } catch (SerialPortException ex) {
                    System.out.println(ex);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    public static class Routine extends Thread {

        String string;

        public Routine(String string) {
            this.string = string.replaceAll("\r\n",
                    "");
        }
        @Override
        public void run() {
            if (NMEAField.getTypeOfMessage(string).equals("GPGGA")) {
                ggaField = new GGAField(str);
                System.out.println("GGA : Latitude: "
                        + ggaField.getLatitude() + "\n"
                        + "Longitude: " + ggaField.getLongitude());
            }
            /*else if (NMEAField.getTypeOfMessage(string).equals("GPGLL"))
            {
                gllField = new GLLField(str);
                System.out.println("GLL Id: "+gllField.getLongitude());
            }*/
        }
    }

}



