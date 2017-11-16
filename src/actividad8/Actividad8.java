/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad8;

import grafo.Grafo;
import grafo.Vertice;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author iqgonzalez17_ESEI
 */
public class Actividad8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> g, Vertice<E> v) {
        Vector<Vertice<E>> pred = new Vector<>();
        Iterator<Vertice<E>> itv = g.vertices();

        while (itv.hasNext()) {
            Vertice<E> w = itv.next();
            Iterator<Vertice<E>> it2 = g.adyacentes(w);
            while (it2.hasNext()) {
                if (it2.next().equals(v)) {
                    pred.add(w);
                }
            }
        }

        return pred.iterator();
    }

    public static <E, T> boolean sumidero(Grafo<E, T> g, Vertice<E> v) {

        Iterator<Vertice<E>> Vertices = g.vertices();
        int numVertices = 0;
        while (Vertices.hasNext()) {
            Vertices.next();
            numVertices++;
        }

        Vertices = predecesores(g, v);
        int predecesor = 0;
        while (Vertices.hasNext()) {
            Vertices.next();
            predecesor++;
        }

        Vertices = g.adyacentes(v);
        int adyacente = 0;
        while (Vertices.hasNext()) {
            Vertices.next();
            adyacente++;
        }
        return predecesor == numVertices - 1 && adyacente == 0;
    }

    public static <E, T> boolean regular(Grafo<E, T> g) {
        Iterator<Vertice<E>> it = g.vertices();
        if (g.esVacio()) {
            return true;
        }
        Vertice<E> v = it.next();
        Iterator<Vertice<E>> ad = g.adyacentes(v);
        
        int cont = 0;

        while (ad.hasNext()) {
            ad.next();
            cont++;

        }

        while (it.hasNext()) {
            v = it.next();
            ad = g.adyacentes(v);
            int cont1 = 0;
            while (ad.hasNext()) {
                ad.next();
                cont1++;
            }
            
            if( cont!=cont1)return false;
        }
       return true;
    
    }
    public static <E,T> boolean dirigido(Grafo<E, T> g,Vertice<E> v1,Vertice<E> v2){
        
        
        
        return true;
    }
}
