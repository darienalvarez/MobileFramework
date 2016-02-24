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
public class Pantalla {
    private List<Object> componentes;
    private LayoutType layout;
    public Pantalla(LayoutType layout)
    {
        componentes = new Vector<Object>();
        this.layout = layout;;
    }

    public void adicionarComponente(Object obj)
    {
        componentes.add(obj);
    }

     public Object ObtenerComponente(int pos)
    {
       return componentes.get(pos);
    }
}
