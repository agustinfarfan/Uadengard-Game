package Controlador;

import Modelo.Juego;
import Modelo.Misiones.MisionSecundaria;
import Vista.VistaMisionesSecundarias;
import Vista.VistaUbicacionNeutral;

import java.util.ArrayList;
import java.util.List;

public class ControladorMisionesSecundarias {
    private VistaMisionesSecundarias vistaMisionesSecundarias;
    private VistaUbicacionNeutral vistaUbicacionNeutral;
    private Juego juego;

    public ControladorMisionesSecundarias(VistaMisionesSecundarias vistaMisionesSecundarias, VistaUbicacionNeutral vistaUbicacionNeutral, Juego juego) {
        this.vistaMisionesSecundarias = vistaMisionesSecundarias;
        this.vistaUbicacionNeutral = vistaUbicacionNeutral;
        this.juego = juego;

        // Listener para el botón "Volver"
        vistaMisionesSecundarias.setBotonVolverListener(e -> {
            vistaMisionesSecundarias.dispose();
            vistaUbicacionNeutral.mostrarVista();
        });
        cargarMisiones();
    }

    private void cargarMisiones() {
        List<MisionSecundaria> misiones = juego.getMisiones();

        List<String> nombres = new ArrayList<>();
        List<String> objetivos = new ArrayList<>();
        List<String> estados = new ArrayList<>();
        List<java.awt.event.ActionListener> listeners = new ArrayList<>();

        for (MisionSecundaria mision : misiones) {
            nombres.add(juego.getNombreMision(mision));
            objetivos.add(juego.getObjetivo(mision));
            estados.add(juego.getEstadoMision(mision));

            listeners.add(e -> {
                if ("Reclamar Recompensas".equals(mision.getEstado())) {
                    juego.reclamarRecompensas(mision);
                    cargarMisiones(); // Recarga las misiones para actualizar los estados
                }
            });
        }

        vistaMisionesSecundarias.mostrarMisiones(nombres, objetivos, estados, listeners);
    }

    public void mostrarVista() {
        vistaMisionesSecundarias.mostrarVista();
    }
}


