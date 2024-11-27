package Controlador;

import Modelo.Juego;
import Modelo.Mapa.Ubicacion;
import Modelo.Mapa.UbicacionNeutral;
import Modelo.Unidades.Heroe;
import Vista.*;

import javax.swing.*;

public class ControladorPrincipal {
    private Juego juego;
    private VistaPrincipal vista;
    private String tipo;
    private Ubicacion ubicacionActual;

    public ControladorPrincipal(Juego juego, VistaPrincipal vista, String tipo, Heroe heroe) {
        this.juego = juego;
        this.vista = vista;
        this.tipo = tipo;

        // Configurar la imagen del héroe basado en su tipo
        ImageIcon imagenHeroe = obtenerImagenHeroe(tipo);
        vista.setImagenHeroe(imagenHeroe, juego.getHeroe());

        ubicacionActual = juego.getUbicacionActual();
        ImageIcon imagenUbicacion = obtenerImagenUbicacion(ubicacionActual);
        vista.setImagenUbicacion(imagenUbicacion, ubicacionActual.getNombre());

        // Agregar listener al botón del héroe
        vista.setBotonHeroeListener(e -> {
            VistaUnidad vistaUnidad = new VistaUnidad();
            ControladorUnidad controladorUnidad = new ControladorUnidad(vistaUnidad,juego);
            vistaUnidad.mostrarVista();
        });

        // Agregar listener al botón de la ubicacion
        vista.setBotonUbicacionListener(e -> {
            if(juego.getUbicacionActual() instanceof UbicacionNeutral){
                VistaUbicacionNeutral vistaUbicacionNeutral = new VistaUbicacionNeutral();
                ControladorUbicacionNeutral controladorUbicacionNeutral = new ControladorUbicacionNeutral(vistaUbicacionNeutral, vista, juego);
                controladorUbicacionNeutral.mostrarUbicacion();
                vista.setVisible(false);
            } else {
                VistaUbicacionHostil vistaUbicacionHostil = new VistaUbicacionHostil();
                ControladorUbicacionHostil controladorUbicacionHostil = new ControladorUbicacionHostil(vistaUbicacionHostil, vista, juego);
                controladorUbicacionHostil.mostrarUbicacion();
                vista.setVisible(false);
            }
        });

        // Agregar listener al botón del mapa
        vista.setBotonMapaListener(e -> {
            VistaMapa vistaMapa = new VistaMapa();
            ControladorMapa controladorMapa = new ControladorMapa(vistaMapa, vista, juego);
            controladorMapa.mostrarMapa();
            vista.setVisible(false); // Ocultar la vista principal mientras se muestra el mapa
        });

        ImageIcon imagenMapa = new ImageIcon(getClass().getResource("/recursos/mapa.png"));
        vista.setImagenMapa(imagenMapa);

        // Mostrar la vista principal
        this.vista.mostrarVista();
    }

    private ImageIcon obtenerImagenHeroe(String tipoHeroe) {
        switch (tipoHeroe) {
            case "Mago":
                return new ImageIcon(getClass().getResource("/recursos/mago.png"));
            case "Guerrero":
                return new ImageIcon(getClass().getResource("/recursos/guerrero.png"));
            case "Arquero":
                return new ImageIcon(getClass().getResource("/recursos/arquero.png"));
            default:
                return new ImageIcon(); // Imagen vacía como predeterminada
        }
        }

    public static ImageIcon obtenerImagenUbicacion(Ubicacion ubicacionActual) {
        if (ubicacionActual instanceof UbicacionNeutral) {
            return new ImageIcon(ControladorPrincipal.class.getResource("/recursos/neutral.png"));
        } else {
            switch (ubicacionActual.getNombre()) {
                case "Montañas Heladas":
                    return new ImageIcon(ControladorPrincipal.class.getResource("/recursos/montañasHeladas.png"));
                case "Bosque de los Susurros":
                    return new ImageIcon(ControladorPrincipal.class.getResource("/recursos/bosqueOscuro.png"));
                case "Pantano Oscuro":
                    return new ImageIcon(ControladorPrincipal.class.getResource("/recursos/pantanoOscuro.png"));
                case "Aldea de los Sirith":
                    return new ImageIcon(ControladorPrincipal.class.getResource("/recursos/aldeaSirith.png"));
                case "Templo Encantado":
                    return new ImageIcon(ControladorPrincipal.class.getResource("/recursos/temploEncantado.png"));
            }
        }
        return null;
    }
}


