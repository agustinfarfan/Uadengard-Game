package Controlador;

import Modelo.Mapa.Ubicacion;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Criatura;
import Modelo.Unidades.Mago;
import Vista.VistaPelea;
import Vista.VistaUbicacionHostil;
import Modelo.Juego;

import java.util.List;

public class ControladorPelea {
    private VistaPelea vistaPelea;
    private VistaUbicacionHostil vistaUbicacionHostil;
    private Juego juego;

    public ControladorPelea(VistaPelea vistaPelea, VistaUbicacionHostil vistaUbicacionHostil, Juego juego) {
        this.vistaPelea = vistaPelea;
        this.vistaUbicacionHostil = vistaUbicacionHostil;
        this.juego = juego;

        // Configurar la vista con datos iniciales
        configurarVista();

        // Listener para el botón "Pelear"
        vistaPelea.setBotonPelearListener(e -> manejarPelea());
    }

    private void configurarVista() {
        // Establecer la imagen del héroe basado en su clase
        String rutaHeroe = "/recursos/";
        if (juego.getHeroe() instanceof Mago) {
            rutaHeroe += "mago.png";
        } else if (juego.getHeroe() instanceof Arquero) {
            rutaHeroe += "arquero.png";
        } else {
            rutaHeroe += "guerrero.png";
        }
        vistaPelea.setImagenHeroe(rutaHeroe);

        // Establecer imágenes de criaturas en la ubicación
        List<Criatura> criaturas = juego.getCriaturasUbicacionActual(juego.getUbicacionActual());
        vistaPelea.setImagenesCriaturas(criaturas);
    }

    private void manejarPelea() {
        // Simular pelea entre el héroe y las criaturas
            boolean resultado = juego.iniciarPelea(
                    juego.getHeroe(),
                    juego.getCriaturasUbicacionActual(juego.getUbicacionActual()),
                    juego.getMisiones(),
                    juego.getUbicacionActual()
            );
            // Mostrar el resultado al usuario
            if (resultado) {
                vistaPelea.mostrarMensajeResultado("¡Has ganado la pelea!", true);
                vistaPelea.cerrarVista();
                vistaUbicacionHostil.mostrarVista();
            } else {
                vistaPelea.mostrarMensajeResultado("Has perdido, mejor suerte la próxima!", false);
                vistaPelea.cerrarVista();
                System.exit(0);
            }
    }

    public void mostrarVista() {
        vistaPelea.mostrarVista();
    }
}



