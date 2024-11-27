package Modelo.Grafo;

import Modelo.Conjunto.*;
import Modelo.Mapa.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class GrafoLA implements GrafoTDA{

    NodoGrafo origen;

    public void InicializarGrafo () {
        origen = null;
    }

    public void AgregarVertice(Ubicacion ubicacion){
        NodoGrafo aux = new NodoGrafo();
        aux.ubicacion = ubicacion;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    public void AgregarArista(Ubicacion v1, Ubicacion v2, int peso){
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoGrafo n2 = Vert2Nodo(v2);
        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    private NodoGrafo Vert2Nodo(Ubicacion ubicacion) {
        NodoGrafo aux = origen;
        while (aux != null && aux.ubicacion != ubicacion){
            aux = aux.sigNodo;
        }
        return aux;
    }

    public void EliminarVertice (Ubicacion ubicacion) {
        if (origen.ubicacion == ubicacion) {
            origen = origen.sigNodo;
        }

        NodoGrafo aux = origen;

        while (aux != null){
            this.EliminarAristaNodo(aux ,ubicacion);
            if(aux.sigNodo != null && aux.sigNodo.ubicacion == ubicacion) {
                aux . sigNodo = aux . sigNodo. sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    private void EliminarAristaNodo (NodoGrafo nodo, Ubicacion ubicacion){
        NodoArista aux = nodo.arista;
        if(aux != null) {
            if(aux.nodoDestino.ubicacion == ubicacion){
                nodo.arista = aux.sigArista;
            }
            else{
                while(aux.sigArista != null && aux.sigArista.nodoDestino.ubicacion != ubicacion){
                    aux = aux.sigArista;
                }
                if(aux.sigArista != null) {
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    public ConjuntoTDA Vertices() {
        ConjuntoTDA c = new Conjunto() ;
        c.inicializarConjunto();

        NodoGrafo aux = origen;
        while(aux != null){
            c.agregar(aux.ubicacion);
            aux = aux.sigNodo;
        }
        return c;
    }

    public void EliminarArista(Ubicacion v1 , Ubicacion v2){
        NodoGrafo n1 = Vert2Nodo(v1);
        EliminarAristaNodo(n1 , v2);
    }

    public boolean ExisteArista(Ubicacion v1 , Ubicacion v2){
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1 . arista;
        while(aux != null && aux.nodoDestino.ubicacion != v2){
            aux = aux.sigArista;
        }
        return aux != null;
    }

    public int PesoArista(Ubicacion v1 , Ubicacion v2){
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while(aux.nodoDestino.ubicacion != v2){
            aux = aux . sigArista;
        }
        return aux.etiqueta;
    }

    public List<Ubicacion> VerticesConAristasDesde(Ubicacion origen) {
        // Crear una lista en lugar de un conjunto
        List<Ubicacion> listaDestino = new ArrayList<>();
        // Encuentra el nodo correspondiente a la ubicación de origen
        NodoGrafo nodoOrigen = Vert2Nodo(origen);
        // Si se encuentra el nodo de origen, procesamos sus aristas
        if (nodoOrigen != null) {
            NodoArista aristaAux = nodoOrigen.arista;
            // Recorrer las aristas del nodo origen
            while (aristaAux != null) {
                // Agregar la ubicación del nodo destino a la lista
                listaDestino.add(aristaAux.nodoDestino.ubicacion);
                // Avanzar a la siguiente arista
                aristaAux = aristaAux.sigArista;
            }
        }
        return listaDestino;
    }
}
/*        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        NodoGrafo nodoOrigen = Vert2Nodo(origen); // Encuentra el nodo correspondiente a la ubicación de origen.
        if (nodoOrigen != null) {
            NodoArista aristaAux = nodoOrigen.arista;
            while (aristaAux != null) {
                conjunto.agregar(aristaAux.nodoDestino.ubicacion); // Agrega cada nodo destino al conjunto.
                aristaAux = aristaAux.sigArista;
            }
        }

        return conjunto;
    }*/

