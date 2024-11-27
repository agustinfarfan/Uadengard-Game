package Modelo.Conjunto;

import Modelo.Mapa.Ubicacion;

public interface ConjuntoTDA {
    void inicializarConjunto();
    void agregar(Ubicacion ubicacion);
    void sacar(Ubicacion ubicacion);
    Ubicacion elegir();
    boolean conjuntoVacio();
}