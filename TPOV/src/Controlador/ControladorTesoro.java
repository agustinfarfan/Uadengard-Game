package Controlador;

import Modelo.Juego;
import Vista.*;

public class ControladorTesoro {
    private VistaTesoro vistaTesoro;
    private VistaUbicacionHostil vistaUbicacionHostil;
    private Juego juego;

    public ControladorTesoro(VistaTesoro vistaTesoro, VistaUbicacionHostil vistaUbicacionHostil, Juego juego) {
        this.vistaTesoro = vistaTesoro;
        this.vistaUbicacionHostil = vistaUbicacionHostil;
        this.juego = juego;

        vistaTesoro.setBotonCerrarListener(e -> {
            System.exit(0);
        });

    }

    public void mostrarVista() {
        vistaTesoro.mostrarVista();
    }
}
