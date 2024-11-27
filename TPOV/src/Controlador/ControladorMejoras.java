package Controlador;

import Modelo.Unidades.Heroe;
import Vista.*;
import Modelo.Juego;
import javax.swing.JOptionPane;

public class ControladorMejoras {
    private VistaMejoras vistaMejoras;
    private VistaUbicacionNeutral vistaUbicacionNeutral;
    private Juego juego;

    public ControladorMejoras(VistaMejoras vistaMejoras, VistaUbicacionNeutral vistaUbicacionNeutral, Juego juego) {
        this.vistaMejoras = vistaMejoras;
        this.vistaUbicacionNeutral = vistaUbicacionNeutral;
        this.juego = juego;

        // Listener para los botones de las mejoras
        vistaMejoras.setBotonMejorarAtaqueListener(e -> {
            String mensaje = juego.mejorarAtaqueHeroe();
            JOptionPane.showMessageDialog(vistaMejoras, mensaje);
            actualizarExperiencia(); // Actualizar experiencia después de mejorar
        });

        vistaMejoras.setBotonMejorarVidaListener(e -> {
            String mensaje = juego.mejorarVidaHeroe();
            JOptionPane.showMessageDialog(vistaMejoras, mensaje);
            actualizarExperiencia(); // Actualizar experiencia después de mejorar
        });

        vistaMejoras.setBotonMejorarDefensaListener(e -> {
            String mensaje = juego.mejorarDefensaHeroe();
            JOptionPane.showMessageDialog(vistaMejoras, mensaje);
            actualizarExperiencia(); // Actualizar experiencia después de mejorar
        });

        vistaMejoras.setBotonInventario(e -> {
            VistaInventario vistaInventario = new VistaInventario();
            ControladorInventario controladorInventario = new ControladorInventario(vistaInventario, vistaMejoras, juego);
            controladorInventario.mostrarVista();
            vistaMejoras.setVisible(false);
        });

        vistaMejoras.setBotonVolverListener(e -> {
            vistaMejoras.dispose();
            vistaUbicacionNeutral.mostrarVista();
        });
    }

    public void mostrarVista() {
        actualizarExperiencia(); // Actualizar experiencia antes de mostrar la vista
        vistaMejoras.mostrarVista();
    }

    private void actualizarExperiencia() {
        double experiencia = juego.getExp(juego.getHeroe()); // Obtener experiencia de la fachada
        vistaMejoras.setExperienciaDisponible(experiencia);
    }
}



