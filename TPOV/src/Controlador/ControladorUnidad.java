package Controlador;

import Modelo.Juego;
import Vista.VistaUnidad;

public class ControladorUnidad {
    private VistaUnidad vistaUnidad;
    private Juego juego;

    public ControladorUnidad(VistaUnidad vistaUnidad, Juego juego) {
        this.vistaUnidad = vistaUnidad;
        this.juego = juego;

        cargarEstadisticasHeroe();

    }

    // Método que pide las estadísticas del héroe desde la fachada (Juego) y las pasa a la vista
    public void cargarEstadisticasHeroe() {
        String estadisticas = juego.getEstadisticasHeroe();

        // Pasar las estadísticas a la vista para que las muestre al usuario
        vistaUnidad.mostrarEstadisticas(estadisticas);
    }
}

