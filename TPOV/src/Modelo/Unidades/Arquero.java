package Modelo.Unidades;
import java.util.Random;

public class Arquero extends Heroe {
	public Arquero(String nombre) {
		super(nombre, 100, 70, 40, 30, 80, 0);
	}

	private Random random = new Random();

	public double atacar(Unidad defensor, int cantGolpes) {
		double daño = this.getNivelAtaque();
		if (defensor instanceof Dragon) {
			return daño;
		} else {
			double chance = random.nextDouble();
			if (chance < (this.getPunteria() / 100)) {
				System.out.println("¡El ataque acertó!");
				return daño;
			} else {
				System.out.println("El ataque falló.");
				return 0;
			}
		}
	}

	public void recibirDaño(Unidad atacante, double daño) {
		double chance = random.nextDouble();
		if (chance > (this.getAgilidad() / 100)) {
			double dañoSobrante = this.getNivelDefensa() - daño;
			if (dañoSobrante <= 0) {
				this.setNivelDefensa(0);
				this.setPuntosVida(this.getPuntosVida() + dañoSobrante);
			} else {
				this.setNivelDefensa(this.getNivelDefensa() - daño);
			}
		}
	}
}
