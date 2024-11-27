package Modelo.Mapa;
import Modelo.Misiones.MisionSecundaria;
import Modelo.Unidades.Heroe;
import Modelo.Mejoras.Mejoras;
import Modelo.Misiones.Recompensa;

import java.util.List;

public class UbicacionNeutral extends Ubicacion{
	private List<MisionSecundaria> misiones;

	public UbicacionNeutral(String nombre, Heroe heroe, List<MisionSecundaria> misiones) {
		super(nombre, heroe);
	}
	public static void descansarYa(Heroe heroe){Mejoras.descansar(heroe);}

	public void subirAtaque(Heroe heroe ){
		Mejoras.mejorarAtaque(heroe);
	}
	public void subirVida(Heroe heroe ){
		Mejoras.mejorarDefensa(heroe);
	}
	public void subirDefensa(Heroe heroe ){
		Mejoras.mejorarDefensa(heroe);
	}
	public void reclamarRecompensas(MisionSecundaria mision, Heroe heroe){
		if (mision.estaCompletada()=="verdadero"){
			Recompensa recompensa= mision.getRecompensa();
			recompensa.aplicarRecompensa(heroe);
		}
	}

}
