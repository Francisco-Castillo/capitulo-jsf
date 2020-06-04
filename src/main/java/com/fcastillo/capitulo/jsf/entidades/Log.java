/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jsf.entidades;

/**
 *
 * @author fcastillo
 */
public class Log {

    private int linea;
    private String nivel;
    private String fecha;
    private String hora;
    private String nombreClase;
    private String mensaje;

  
    public Log(int linea, String nivel, String fecha, String hora, String nombreClase, String mensaje) {
        this.linea = linea;
        this.nivel = nivel;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreClase = nombreClase;
        this.mensaje = mensaje;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
