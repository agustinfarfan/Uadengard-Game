package Controlador;

import Vista.*;
import Modelo.Juego;

public class ControladorUbicacionHostil {
    private VistaUbicacionHostil vistaUbicacionHostil;
    private VistaPrincipal vistaPrincipal;
    private Juego juego;

    public ControladorUbicacionHostil(VistaUbicacionHostil vistaUbicacionHostil, VistaPrincipal vistaPrincipal, Juego juego) {
        this.vistaUbicacionHostil = vistaUbicacionHostil;
        this.vistaPrincipal = vistaPrincipal;
        this.juego = juego;

        vistaUbicacionHostil.setUbicacionActual(juego.getUbicacionActual());

        // Listener para el botón "Volver"
        vistaUbicacionHostil.setBotonVolverListener(e -> {
            vistaUbicacionHostil.dispose(); // Cierra la ventana de la ubicación neutral
            vistaPrincipal.mostrarVista(); // Muestra la vista principal nuevamente
        });

        vistaUbicacionHostil.setBotonPelearListener(e -> {
            if (!juego.getCriaturasVencidas(juego.getUbicacionActual())){
                VistaPelea vistaPelea = new VistaPelea();
                ControladorPelea controladorPelea = new ControladorPelea(vistaPelea, vistaUbicacionHostil, juego);
                controladorPelea.mostrarVista();
                vistaUbicacionHostil.setVisible(false); // Ocultar la vista de ubicación neutral
            }
            else{
                vistaUbicacionHostil.mostrarMensajeResultado("Ya venciste a los enemigos!");
            }
        });

        // Listener para el botón "Buscar tesoro"
        vistaUbicacionHostil.setBotonBuscarTesoroListener(e -> {
            if (juego.getCriaturasVencidas(juego.getUbicacionActual())) {
                if (juego.getEsTesoro(juego.getUbicacionActual())){
                    VistaTesoro vistaTesoro = new VistaTesoro();
                    ControladorTesoro controladorTesoro = new ControladorTesoro(vistaTesoro, vistaUbicacionHostil, juego);
                    controladorTesoro.mostrarVista();
                    vistaUbicacionHostil.setVisible(false);
                }
                else{
                    VistaNoTesoro vistaNoTesoro = new VistaNoTesoro();
                    ControladorNoTesoro controladorNoTesoro = new ControladorNoTesoro(vistaNoTesoro, vistaUbicacionHostil, juego);
                    controladorNoTesoro.mostrarVista();
                    vistaUbicacionHostil.setVisible(false);
                }
            } else {
                vistaUbicacionHostil.mostrarMensajeNoPeleaste("¡Todavía no derrotaste a los enemigos!");
            }
        });
    }

    public void mostrarUbicacion() {
        vistaUbicacionHostil.mostrarVista();
    }
}

