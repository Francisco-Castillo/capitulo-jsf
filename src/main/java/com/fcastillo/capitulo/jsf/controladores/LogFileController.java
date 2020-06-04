package com.fcastillo.capitulo.jsf.controladores;

import com.fcastillo.capitulo.jsf.entidades.Log;
import com.fcastillo.capitulo.jsf.utilidades.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author fcastillo
 */
@Named(value = "logFileController")
@ViewScoped
public class LogFileController implements Serializable {

    private static final String DIRECTORIO = "/home/fcastillo/payara5/logs/jsf";
    private File[] arrFiles;
    private List<Log> lstLines = new ArrayList<>();

    private String nameFile;

    Logger logger = LogManager.getLogger(LogFileController.class);

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public File[] getArrFiles() {
        return arrFiles;
    }

    public void setArrFiles(File[] arrFiles) {
        this.arrFiles = arrFiles;
    }

    public List<Log> getLstLines() {
        return lstLines;
    }

    public void setLstLines(List<Log> lstLines) {
        this.lstLines = lstLines;
    }

    @PostConstruct
    public void init() {
        arrFiles = FileUtils.listarArchivos(DIRECTORIO);
    }

    public void onChange(SelectEvent event) throws IOException {
        try {
            File file = new File(event.getObject().toString());
            nameFile = file.getName();
            lstLines = FileUtils.procesarLog(file);
        } catch (Exception e) {
            logger.warn("No hay registros log para leer");
            nameFile = "";
            lstLines = new ArrayList<>();
        }

    }

}
