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
            return "/index.xhtml";
        } catch (Exception e) {
            System.out.println("registrar() " + e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public String eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar() {
        try {
            peliculaEJB.edit(pelicula);
             return "/index?faces-redirect=true";
        } catch (Exception e) {
            System.out.println("actualizar() " + e.getLocalizedMessage());
        }
        return null;
    }

    public void buscar() {
        pelicula = peliculaEJB.find(idPelicula);
    }
}
