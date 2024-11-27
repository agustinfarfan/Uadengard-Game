package Controlador;

import Vista.*;
import Modelo.Juego;

import javax.swing.*;

public class ControladorUbicacionNeutral {
    private VistaUbicacionNeutral vistaUbicacionNeutral;
    private VistaPrincipal vistaPrincipal;
    private Juego juego;

    public ControladorUbicacionNeutral(VistaUbicacionNeutral vistaUbicacionNeutral, VistaPrincipal vistaPrincipal, Juego juego) {
        this.vistaUbicacionNeutral = vistaUbicacionNeutral;
        this.vistaPrincipal = vistaPrincipal;
        this.juego = juego;

        vistaUbicacionNeutral.setUbicacionActual(juego.getUbicacionActual());


        // Listener para el botón "Volver"
        vistaUbicacionNeutral.setBotonVolverListener(e -> {
            vistaUbicacionNeutral.dispose(); // Cierra la ventana de la ubicación neutral
            vistaPrincipal.mostrarVista(); // Muestra la vista principal nuevamente
        });

        vistaUbicacionNeutral.setBotonDescansarListener(e -> {
            juego.descansarHeroe();  // Realiza la acción de descansar
            // Mostrar un mensaje al usuario con JOptionPane
            JOptionPane.showMessageDialog(vistaUbicacionNeutral,
                    "El héroe ha descansado. Vida al 100%",
                    "Descanso Completado",
                    JOptionPane.INFORMATION_MESSAGE); // Muestra el cuadro de diálogo
        });

        // Listener para el botón "Mejorar Personaje"
        vistaUbicacionNeutral.setBotonMejorarListener(e -> {
            VistaMejoras vistaMejoras = new VistaMejoras();
            ControladorMejoras controladorMejoras = new ControladorMejoras(vistaMejoras, vistaUbicacionNeutral, juego);
            controladorMejoras.mostrarVista();
            vistaUbicacionNeutral.setVisible(false); // Ocultar la vista de ubicación neutral
        });

        // Listener para el botón "Misiones Secundarias"
        vistaUbicacionNeutral.setBotonMisionesListener(e -> {
            VistaMisionesSecundarias vistaMisionesSecundarias = new VistaMisionesSecundarias();
            ControladorMisionesSecundarias controladorMisionesSecundarias = new ControladorMisionesSecundarias(vistaMisionesSecundarias, vistaUbicacionNeutral, juego);
            controladorMisionesSecundarias.mostrarVista();
            vistaUbicacionNeutral.setVisible(false); // Ocultar la vista de ubicación neutral
        });
    }

    public void mostrarUbicacion() {
        vistaUbicacionNeutral.mostrarVista();
    }
}


