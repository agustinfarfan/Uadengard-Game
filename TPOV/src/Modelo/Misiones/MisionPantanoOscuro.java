package Modelo.Misiones;

import Modelo.Mapa.Ubicacion;
import Modelo.Unidades.*;


public class MisionPantanoOscuro extends MisionSecundaria {
    private String nombreUbicacionObjetivo = "Pantano Oscuro";
    private int contadorMuertes;

    public MisionPantanoOscuro(Recompensa recompensa) {
        super("Elimina a los Espectros del Pantano", "Derrotar a 5 Espectros que infestan el Pantano Oscuro.", recompensa);
        contadorMuertes=0;
    }
    public void verificarProgreso(Criatura criaturaDerrotada, Ubicacion ubicacionActual) {
        if (criaturaDerrotada instanceof Espectro && nombreUbicacionObjetivo.equals(ubicacionActual.getNombre())) {
            contadorMuertes++;
            if (contadorMuertes==5){completarMision();}
        }
    }
}