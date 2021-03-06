package com.fcastillo.capitulo.jsf.utilidades;

public class ULogFile {

    //<editor-fold defaultstate="collapsed" desc="fields">
    private static final int INICIO_LEVEL = 0;
    private static final int FIN_LEVEL = 5;
    private static final int INICIO_DATE = 5;
    private static final int FIN_DATE = 16;
    private static final int INICIO_HOUR = 16;
    private static final int FIN_HOUR = 24;
    private static final String CARACTER_CORCHETE_ABRE = "[";
    private static final String CARACTER_CORCHETE_CIERRA = "]";
    private static final String CARACTER_BARRA = "-";
    private static final String CARACTER_PARENTESIS_A = "(";
    private static final String CARACTER_PARENTESIS_C = ")";
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="levelLogging()">
    public static String getNivelLog(String line) {
        String level = line.substring(INICIO_LEVEL, FIN_LEVEL);
        return level.trim();
    }
    //</editor-fold>
   
    
    //<editor-fold defaultstate="collapsed" desc="date()">
    public static String getFecha(String line) {
        return line.substring(INICIO_DATE, FIN_DATE);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="hour()">
    public static String getHora(String line) {
        return line.substring(INICIO_HOUR, FIN_HOUR);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="title()">
    public static String getNombreClaseTC(String line) {
        int pos1 = line.lastIndexOf(CARACTER_CORCHETE_CIERRA);
        int pos2 = line.indexOf(CARACTER_CORCHETE_ABRE);
        String message = line.substring(pos1 + 1, pos2).trim();
        return message;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="message()">
    public static String getMensaje(String line) {
        int pos = line.lastIndexOf(CARACTER_BARRA);
        String message = line.substring(pos + 1, line.length()).trim();
        return message;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="className()">
    public static String getClaseMetodoLinea(String line) {
        int pos1 = line.indexOf(CARACTER_PARENTESIS_A);
        int pos2 = line.lastIndexOf(CARACTER_PARENTESIS_C);
        String nombreClase = line.substring(pos1 + 1, pos2);
        return nombreClase;
    }
    //</editor-fold>
}
