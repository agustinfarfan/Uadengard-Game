package Controlador;

import Modelo.Juego;
import Modelo.Mapa.Ubicacion;
import Vista.VistaMapa;
import Vista.VistaPrincipal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorMapa {
    private VistaMapa vistaMapa;
    private VistaPrincipal vistaPrincipal;
    private Juego juego;

    public ControladorMapa(VistaMapa vistaMapa, VistaPrincipal vistaPrincipal, Juego juego) {
        this.vistaMapa = vistaMapa;
        this.vistaPrincipal = vistaPrincipal;
        this.juego = juego;

        vistaMapa.mostrarVista();

        // Agregar listener al botón "Volver"
        vistaMapa.setBotonVolverListener(e -> {
            vistaMapa.dispose(); // Cierra la ventana del mapa
            vistaPrincipal.mostrarVista(); // Vuelve a mostrar la vista principal
        });

        vistaMapa.setBotonMapaCompletoListener(e -> vistaMapa.mostrarMapaCompleto());

    }

    public void mostrarMapa() {
        List<String> nombresUbicaciones = new ArrayList<>();
        List<ActionListener> accionesUbicaciones = new ArrayList<>();

        for (Ubicacion ubicacion : juego.getUbicaciones()) {
            String nombreUbicacion = juego.getNombreUbicacion(ubicacion);
            ActionListener accion = e -> {
                if (juego.puedeViajar(juego.getUbicacionActual(), ubicacion)) {
                    juego.setUbicacionActual(ubicacion);
                    JOptionPane.showMessageDialog(vistaMapa, "Has viajado a: " + nombreUbicacion);
                    vistaPrincipal.setImagenUbicacion(ControladorPrincipal.obtenerImagenUbicacion(ubicacion),ubicacion.getNombre());
                    vistaMapa.dispose();
                    vistaPrincipal.mostrarVista();
                } else {
                    JOptionPane.showMessageDialog(vistaMapa, "No te encuentras cerca de esta ubicación.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            };
            nombresUbicaciones.add(nombreUbicacion);
            accionesUbicaciones.add(accion);
        }
        vistaMapa.setUbicaciones(nombresUbicaciones, accionesUbicaciones);
    }

}


