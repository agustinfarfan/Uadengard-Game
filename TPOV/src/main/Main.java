package main;

import Controlador.ControladorJuego;
import Modelo.Juego;
import Vista.VistaJuego;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener instancia única del modelo (Juego)
            Juego juego = Juego.getInstance();

            // Crear una instancia de la vista
            VistaJuego vistaJuego = new VistaJuego();

            // Crear el controlador y vincular modelo y vista
            ControladorJuego controladorJuego = new ControladorJuego(juego, vistaJuego);

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
