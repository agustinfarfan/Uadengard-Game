package Modelo.Misiones;

import Modelo.Mapa.Ubicacion;
import Modelo.Unidades.*;


public class MisionDerrotarDragon extends MisionSecundaria {
    private String nombreUbicacionObjetivo = "Montañas Heladas";

    public MisionDerrotarDragon(Recompensa recompensa) {
        super("Derrota al Dragón del Norte", "Vencer al Dragón del Norte que habita en las Montañas Heladas", recompensa);
    }
    public void verificarProgreso(Criatura criaturaDerrotada, Ubicacion ubicacionActual) {
        if (criaturaDerrotada instanceof Dragon && nombreUbicacionObjetivo.equals(ubicacionActual.getNombre())) {
            completarMision();
        }
    }
}