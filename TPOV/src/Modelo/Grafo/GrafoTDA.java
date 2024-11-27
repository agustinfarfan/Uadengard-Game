package Modelo.Grafo;

import Modelo.Conjunto.ConjuntoTDA;
import Modelo.Mapa.Ubicacion;

import java.util.List;

public interface GrafoTDA {

    void InicializarGrafo ();
    void AgregarVertice(Ubicacion ubicacion);
    void EliminarVertice (Ubicacion v) ;
    ConjuntoTDA Vertices();
    void AgregarArista(Ubicacion v1 , Ubicacion v2 , int peso);
    void EliminarArista( Ubicacion v1 , Ubicacion v2 );
    boolean ExisteArista( Ubicacion v1 , Ubicacion v2);
    int PesoArista( Ubicacion v1 , Ubicacion v2 );
    public List<Ubicacion> VerticesConAristasDesde(Ubicacion origen);
}
