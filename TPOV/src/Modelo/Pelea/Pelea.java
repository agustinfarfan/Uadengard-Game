package Modelo.Pelea;

import Modelo.Mapa.Ubicacion;
import Modelo.Misiones.MisionSecundaria;
import Modelo.Misiones.Recompensa;
import Modelo.Unidades.Heroe;
import Modelo.Unidades.Criatura;
import Modelo.Unidades.*;

import java.util.List;

public class Pelea {
	private Heroe heroe;
	private List<Criatura> criaturas;
	private int cantGolpes;
	private List<MisionSecundaria> misionesSecundarias;
	private Ubicacion ubicacion;
	private double ataqueBase;

	public Pelea(Heroe heroe, List<Criatura> criaturas, List<MisionSecundaria> misionesSecundarias, Ubicacion ubicacion) {
		this.heroe = heroe;
		this.criaturas = criaturas;
		this.misionesSecundarias = misionesSecundarias;
		this.ubicacion = ubicacion;
		ataqueBase = heroe.getNivelAtaque();
	}

	public boolean iniciarPelea() {
		verificarInventario();
		for (Criatura criatura : criaturas) {

			// Variables para pelea específica
			cantGolpes = 0;
			while (heroe.estaVivo() && criatura.estaVivo()) {
				// Turno del héroe
				double daño = heroe.atacar(criatura, cantGolpes);
				criatura.recibirDaño(heroe, daño);
				cantGolpes++;

				if (!criatura.estaVivo()) {
					heroe.ganarExperiencia(criatura.getExp());

					// Verificar progreso en las misiones
					for (MisionSecundaria mision : misionesSecundarias) {
						mision.verificarProgreso(criatura, ubicacion);
					}
					break;
				}

				// Turno de la criatura
				daño = criatura.atacar(heroe, cantGolpes);
				heroe.recibirDaño(criatura, daño);

				if (!heroe.estaVivo()) {
					System.out.println(heroe.getNombre() + " ha sido derrotado.");
					return false; // El héroe perdió
				}
			}
		}
		if (heroe instanceof Mago) {
			heroe.setPuntosVida(100);
		}
		heroe.setNivelAtaque(ataqueBase);
		ubicacion.setCriaturasVencidasTrue();
		System.out.println(heroe.getNombre() + " ha derrotado a todos los enemigos.");
		return true;
	}

	public int getCantGolpes() {
		return cantGolpes;
	}


	public void verificarInventario(){
		for(MisionSecundaria misionSecundaria: misionesSecundarias){
			if (misionSecundaria.getEstado().equals("Reclamada")){
				Recompensa recompensa= misionSecundaria.getRecompensa();
				recompensa.aplicarRecompensa(heroe);
			}
		}
	}
}
