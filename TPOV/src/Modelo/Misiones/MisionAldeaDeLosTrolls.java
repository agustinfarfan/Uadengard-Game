package Modelo.Misiones;

import Modelo.Mapa.Ubicacion;
import Modelo.Unidades.*;


public class MisionAldeaDeLosTrolls extends MisionSecundaria {
    private String nombreUbicacionObjetivo = "Aldea de los Sirith";
    private int contadorMuertes;

    public MisionAldeaDeLosTrolls(Recompensa recompensa) {
        super("Limpia la Aldea de los Trolls", "Derrotar a 3 Trolls en la Aldea de los Sirith.", recompensa);
        contadorMuertes=0;
    }
    public void verificarProgreso(Criatura criaturaDerrotada, Ubicacion ubicacionActual) {
        if (criaturaDerrotada instanceof Troll && nombreUbicacionObjetivo.equals(ubicacionActual.getNombre())) {
            contadorMuertes++;
            if (contadorMuertes==3){completarMision();}
        }
    }
}