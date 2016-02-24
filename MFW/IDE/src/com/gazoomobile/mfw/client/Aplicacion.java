/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Yunisel
 */
public class Aplicacion {
    private List<Pantalla> pantallas;
    public Aplicacion()
    {
        pantallas = new Vector<Pantalla>();
    }

    public void AdicionarPantalla(Pantalla p)
    {
        pantallas.add(p);
    }

    public Pantalla ObtenerPantalla(int pos)
    {
       return pantallas.get(pos);
    }

}
