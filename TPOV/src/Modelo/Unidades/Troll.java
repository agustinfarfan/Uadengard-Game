package Modelo.Unidades;

public class Troll extends Criatura {
	public Troll(String nombre) {
		super(nombre, 30, 40, 30, 700); // Inicializa el troll usando el constructor de Criatura
	}

	@Override
	public double atacar(Unidad defensor, int cantGolpes) {
		double daño = this.getNivelAtaque();
		return daño;
	}

	@Override
	public void recibirDaño(Unidad atacante, double daño) {
		if (atacante instanceof Mago){
			this.setNivelDefensa(this.getNivelDefensa()*0.15);
		}
		double dañoSobrante = this.getNivelDefensa() - daño;
		if (dañoSobrante <= 0) {
			this.setNivelDefensa(0);
			this.setPuntosVida(this.getPuntosVida() + dañoSobrante);
		} else {
			this.setNivelDefensa(this.getNivelDefensa() - daño);
		}

	}
}
