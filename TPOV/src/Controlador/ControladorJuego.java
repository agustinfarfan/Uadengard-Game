package Controlador;

import Modelo.Juego;
import Vista.VistaJuego;
import Vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorJuego {
    private Juego juego;
    private VistaJuego vista;

    public ControladorJuego(Juego juego, VistaJuego vista) {
        this.juego = juego;
        this.vista = vista;

        // Agregar listener al botón de confirmar
        this.vista.setConfirmarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.getNombreHeroe();
                String tipo = vista.getTipoHeroe();

                // Validar si el nombre está vacío
                if (!vista.validarNombre()) {
                    return; // No continuar si el nombre está vacío
                }

                // Validar si el tipo de héroe ha sido seleccionado
                if (!vista.validarSeleccionHeroe()) {
                    return; // No continuar si no se ha seleccionado héroe
                }

                // Configurar el héroe con los datos ingresados
                juego.configurarHeroeDesdeUsuario(nombre, tipo);

                // Cerrar la vista actual
                vista.dispose();

                // Cambiar a la vista principal
                VistaPrincipal vistaPrincipal = new VistaPrincipal();
                ControladorPrincipal controladorPrincipal = new ControladorPrincipal(juego, vistaPrincipal,tipo, juego.getHeroe());
            }
        });

        // Mostrar la vista
        this.vista.mostrarVista();
    }
}



