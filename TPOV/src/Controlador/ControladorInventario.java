package Controlador;

import Modelo.Misiones.MisionSecundaria;
import Modelo.Misiones.Recompensa;
import Modelo.Unidades.Criatura;
import Vista.*;
import Modelo.Juego;

import java.util.List;

public class ControladorInventario {
    private VistaInventario vistaInventario;
    private VistaMejoras vistaMejoras;
    private Juego juego;

    public ControladorInventario(VistaInventario vistaInventario, VistaMejoras vistaMejoras, Juego juego) {
        this.vistaInventario = vistaInventario;
        this.vistaMejoras = vistaMejoras;
        this.juego = juego;

        vistaInventario.setBotonVolverListener(e -> {
            vistaInventario.dispose();
            vistaMejoras.mostrarVista();
        });

        List<MisionSecundaria> misionSecundarias = juego.getMisiones();
        vistaInventario.setInventario(misionSecundarias);

    }

    public void mostrarVista() {
        actualizarInventario(juego.getMisiones()); // Actualizar las imágenes del inventario
        vistaInventario.mostrarVista();
    }

    private void actualizarInventario(List<MisionSecundaria> misionSecundarias) {
        // Pasar las misiones secundarias a la vista
        vistaInventario.setInventario(misionSecundarias);
    }
}