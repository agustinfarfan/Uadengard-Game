package Modelo.Mejoras;

import Modelo.Unidades.Heroe;

public class Mejoras {

	public static String descansar(Heroe heroe) {
		heroe.setPuntosVida(100);
		return "El héroe ha descansado. Vida al 100%";
	}

	public static String mejorarAtaque(Heroe heroe) {
		if (heroe.getExp() >= 100) {
			heroe.setNivelAtaque(heroe.getNivelAtaque() + 15);
			heroe.setExp(heroe.getExp() - 100);
			return "Ataque mejorado exitosamente.";
		} else {
			return "No tienes suficiente experiencia para mejorar el ataque.";
		}
	}

	public static String mejorarVida(Heroe heroe) {
		if (heroe.getExp() >= 100) {
			heroe.setPuntosVida(heroe.getPuntosVida() + 10);
			heroe.setExp(heroe.getExp() - 100);
			return "Vida mejorada exitosamente.";
		} else {
			return "No tienes suficiente experiencia para mejorar la vida.";
		}
	}

	public static String mejorarDefensa(Heroe heroe) {
		if (heroe.getExp() >= 50) {
			heroe.setNivelDefensa(heroe.getNivelDefensa() + 15);
			heroe.setExp(heroe.getExp() - 50);
			return "Defensa mejorada exitosamente.";
		} else {
			return "No tienes suficiente experiencia para mejorar la defensa.";
		}
	}
}



