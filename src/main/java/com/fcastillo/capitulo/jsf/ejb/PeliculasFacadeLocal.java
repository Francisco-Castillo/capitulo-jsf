/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jsf.ejb;

import com.fcastillo.capitulo.jsf.entidades.Peliculas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fcastillo
 */
@Local
public interface PeliculasFacadeLocal {

    void create(Peliculas peliculas);

    void edit(Peliculas peliculas);

    void remove(Peliculas peliculas);

    Peliculas find(Object id);

    List<Peliculas> findAll();

    List<Peliculas> findRange(int[] range);

    int count();
    
}
