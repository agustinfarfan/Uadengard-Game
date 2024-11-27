package Modelo.Misiones;

import Modelo.Unidades.Heroe;

public class Recompensa {
	private String nombreObjeto;
	private int valorAtaque;   // Incremento porcentual en ataque
	private int valorDefensa;  // Incremento porcentual en defensa
	private int puntosDefensa; // Puntos adicionales de defensa

	public Recompensa(String nombreObjeto, int valorAtaque, int valorDefensa, int puntosDefensa) {
		this.nombreObjeto = nombreObjeto;
		this.valorAtaque = valorAtaque;
		this.valorDefensa = valorDefensa;
		this.puntosDefensa = puntosDefensa;
	}

	// Método para aplicar la recompensa a un héroe
	public void aplicarRecompensa(Heroe heroe) {
		if (valorAtaque > 0) {
			heroe.setNivelAtaque(heroe.getNivelAtaque() * (1 + valorAtaque / 100.0));
		}
		if (valorDefensa > 0) {
			heroe.setNivelDefensa(heroe.getNivelDefensa() * (1 + valorDefensa / 100.0));
		}
		if (puntosDefensa > 0) {
			heroe.setNivelDefensa(heroe.getNivelDefensa() + puntosDefensa);
		}
	}

	public String getDescripcion() {
		return nombreObjeto;
	}
}

