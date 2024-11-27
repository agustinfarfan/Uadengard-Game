package Controlador;


import Modelo.Juego;
import Vista.*;

public class ControladorNoTesoro {
    private VistaNoTesoro vistaNoTesoro;
    private VistaUbicacionHostil vistaUbicacionHostil;
    private Juego juego;

    public ControladorNoTesoro(VistaNoTesoro vistaNoTesoro, VistaUbicacionHostil vistaUbicacionHostil, Juego juego) {
        this.vistaNoTesoro = vistaNoTesoro;
        this.vistaUbicacionHostil = vistaUbicacionHostil;
        this.juego = juego;

        // Listener para el botón Volver
        vistaNoTesoro.setBotonVolverListener(e -> {
            vistaNoTesoro.cerrarVista();
            vistaUbicacionHostil.mostrarVista();
        });
    }

    public void mostrarVista() {
        vistaNoTesoro.mostrarVista();
    }
}

