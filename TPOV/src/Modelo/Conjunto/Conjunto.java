package Modelo.Conjunto;

import Modelo.Mapa.Ubicacion;

public class Conjunto implements ConjuntoTDA {

    private class Nodo {
        Ubicacion valor;
        Nodo sig;
    }

    private Nodo origen;

    @Override
    public void inicializarConjunto() {
        origen = null;
    }

    @Override
    public void agregar(Ubicacion ubicacion) {
        if (!pertenece(ubicacion)) { // Cambié `Ubicacion` por `ubicacion`
            Nodo nodo = new Nodo();
            nodo.valor = ubicacion;
            nodo.sig = origen;
            origen = nodo;
        }
    }


    public void sacar(Ubicacion ubicacion) { // Cambié `Ubicaciones` por `Ubicacion`
        if (pertenece(ubicacion)) {
            if (origen.valor == ubicacion) {
                origen = origen.sig;
            } else {
                Nodo nodoAux = origen;
                while (nodoAux.sig != null && nodoAux.sig.valor != ubicacion) {
                    nodoAux = nodoAux.sig;
                }
                if (nodoAux.sig != null) {
                    nodoAux.sig = nodoAux.sig.sig;
                }
            }
        }
    }

    @Override
    public Ubicacion elegir() {
        int max = cantElementos(origen);
        int min = 0;
        int num = (int) (Math.random() * (max - min) + min);

        Nodo nodoAux = origen;
        for (int i = 0; i < num; i++) {
            if (nodoAux.sig != null) {
                nodoAux = nodoAux.sig;
            }
        }

        return nodoAux.valor;
    }

    @Override
    public boolean conjuntoVacio() {
        return origen == null;
    }

    private boolean pertenece(Ubicacion ubicacion) { // Cambié `Ubicaciones` por `Ubicacion`
        Nodo nodoAux = origen;
        while (nodoAux != null && nodoAux.valor != ubicacion) {
            nodoAux = nodoAux.sig;
        }
        return nodoAux != null;
    }

    private int cantElementos(Nodo origen) {
        Nodo nodoAux = origen;
        int cant = 0;
        while (nodoAux != null) {
            nodoAux = nodoAux.sig;
            cant++;
        }
        return cant;
    }

}