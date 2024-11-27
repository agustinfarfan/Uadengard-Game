package Modelo.Misiones;

import Modelo.Mapa.Ubicacion;
import Modelo.Unidades.Criatura;

public class MisionRecuperarAmuleto extends MisionSecundaria {
    private String nombreUbicacionObjetivo = "Bosque de los Susurros";

    public MisionRecuperarAmuleto(Recompensa recompensa) {
        super("Recupera el Amuleto Perdido", "Encontrar y recuperar el Amuleto Perdido en el Bosque de los Susurros", recompensa);
    }

    public void verificarProgreso(Criatura criaturaDerrotada, Ubicacion ubicacionActual) {
        if (nombreUbicacionObjetivo.equals(ubicacionActual.getNombre())) {
            completarMision();
        }
    }
}
