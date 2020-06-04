/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jsf.controladores;

import com.fcastillo.capitulo.jsf.ejb.PeliculasFacadeLocal;
import com.fcastillo.capitulo.jsf.entidades.Peliculas;
import com.fcastillo.capitulo.jsf.interf.Operaciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author fcastillo
 */
@Named(value = "peliculasController")
@ViewScoped
public class PeliculasController implements Serializable, Operaciones {

    @EJB
    PeliculasFacadeLocal peliculaEJB;

    private List<Peliculas> lstPeliculas = new ArrayList<>();
    private Peliculas nuevaPelicula = new Peliculas();
    private Peliculas pelicula = new Peliculas();
    private int idPelicula;
    
    Logger logger = LogManager.getLogger(PeliculasController.class);

    public List<Peliculas> getLstPeliculas() {
        return lstPeliculas;
    }

    public void setLstPeliculas(List<Peliculas> lstPeliculas) {
        this.lstPeliculas = lstPeliculas;
    }

    public Peliculas getNuevaPelicula() {
        return nuevaPelicula;
    }

    public void setNuevaPelicula(Peliculas nuevaPelicula) {
        this.nuevaPelicula = nuevaPelicula;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }

    @PostConstruct
    private void init() {
        iniciar();
    }

    private void iniciar() {
        // obtenemos el listado de todas las peliculas
        lstPeliculas = peliculaEJB.findAll();
    }

    @Override
    public String registrar() {
        try {
            peliculaEJB.create(nuevaPelicula);
            logger.info("Se registro pelicula " + nuevaPelicula.getTitulo());
            return "/index.xhtml";
        } catch (Exception e) {
            logger.error("No se pudo registrar " + nuevaPelicula.getTitulo(), e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public String eliminar() {
        try {
            peliculaEJB.remove(pelicula);
            logger.info("pelicula eliminada " + pelicula.getTitulo());
            return "/index.xhtml";
        } catch (Exception e) {
            logger.error("No se pudo eliminar " + pelicula.getTitulo(), e.getMessage());
        }
        return null;
    }

    @Override
    public String actualizar() {
        try {
            peliculaEJB.edit(pelicula);
            logger.info("se actualizó " + pelicula.getTitulo());
            return "/index?faces-redirect=true";
        } catch (Exception e) {
            logger.error("No se pudo eliminar " + pelicula.getTitulo(), e.getMessage());
        }
        return null;
    }

    public void buscar() {
        try {
            pelicula = peliculaEJB.find(idPelicula);
        } catch (Exception e) {
            logger.error("pelicula no encontrada id " + idPelicula, e.getMessage());
        }
    }

    public void leer(Peliculas p) {
        pelicula = peliculaEJB.find(p.getId());
    }
}
