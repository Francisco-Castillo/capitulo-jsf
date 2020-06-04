package com.fcastillo.capitulo.jsf.utilidades;

//<editor-fold defaultstate="collapsed" desc="imports">
import com.fcastillo.capitulo.jsf.entidades.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

public class FileUtils {

    //<editor-fold defaultstate="collapsed()" desc="listarArchivos()">
    public static File[] listarArchivos(String nombreDirectorio) {
        File directorio = new File(nombreDirectorio);
        File[] lstFiles = directorio.listFiles();
        return lstFiles;
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="procesarLog()"> 
    public static List<Log> procesarLog(File f) throws FileNotFoundException, IOException {
        List<Log> lstLines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(f));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int idLinea = 1;
            while (line != null) {
                Log logLine = generarLogLine(idLinea, line);

                lstLines.add(logLine);

                sb.append(line);
                sb.append(System.lineSeparator());

                line = br.readLine();
                idLinea = idLinea + 1;

            }
            String everything = sb.toString();

        } finally {
            br.close();
        }
        return lstLines;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="generarLogLine()">
    private static Log generarLogLine(int lineaInicial, String line) {
        String levelLogging = ULogFile.levelLogging(line);

        String date = ULogFile.date(line);
        String hour = ULogFile.hour(line);
        String className = ULogFile.className(line);

        String message = ULogFile.message(line);
        //Log logLine = new Log(lineaInicial, levelLogging);
        Log logLine = new Log(lineaInicial,levelLogging,date,hour,className, message);
        return logLine;
    }//</editor-fold>

}
