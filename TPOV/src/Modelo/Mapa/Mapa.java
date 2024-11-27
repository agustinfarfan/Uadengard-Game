package Modelo.Mapa;
import Modelo.Conjunto.*;
import Modelo.Grafo.*;

import java.util.List;

public class Mapa {
	private GrafoTDA mapaJuego;
	private Ubicacion ubicacionActual;

	public Mapa() {
		mapaJuego = new GrafoLA();
		viajar(null);
	}

	public GrafoTDA getMapaJuego() {
		return mapaJuego;
	}

	public void agregarUbicacionAMapa(Ubicacion ubicacion) {
		mapaJuego.AgregarVertice(ubicacion);
	}

	public void agregarCamino(Ubicacion ubicacion_1, Ubicacion ubicacion_2) {
		mapaJuego.AgregarArista(ubicacion_1, ubicacion_2, 0);
		mapaJuego.AgregarArista(ubicacion_2, ubicacion_1, 0); // Haciendo bidireccional
	}

	public List<Ubicacion> mostrarUbicacionesCercanas(Ubicacion ubicacionActual) {
		return mapaJuego.VerticesConAristasDesde(ubicacionActual); // Devuelve el conjunto directamente
	}

	public boolean puedeViajar(Ubicacion origen, Ubicacion destino) {
		List<Ubicacion> destinos = mostrarUbicacionesCercanas(origen);
		return destinos.contains(destino);  // Esto devuelve true si 'destino' está en la lista
	}

	public void viajar(Ubicacion ubicacion) {
		ubicacionActual = ubicacion;
	}

	public Ubicacion getUbicacionActual() {
		return ubicacionActual;
	}

	public void setUbicacionActual(Ubicacion ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}
}
