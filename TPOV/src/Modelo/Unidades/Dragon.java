package Modelo.Unidades;

public class Dragon extends Criatura {

	public Dragon(String nombre) {
		super(nombre, 100, 50, 20, 150);
	}

	@Override
	public double atacar(Unidad defensor,int cantGolpes) {
		double daño = this.getNivelAtaque();
		if (defensor instanceof Guerrero) {
			daño += daño * 0.30;
		}
		return daño;
	}
	@Override
	public void recibirDaño(Unidad atacante,double daño){
		double dañoSobrante = this.getNivelDefensa() - daño;
		if (dañoSobrante <= 0) {
			this.setNivelDefensa(0);
			this.setPuntosVida(this.getPuntosVida() + dañoSobrante);
		} else {
			this.setNivelDefensa(this.getNivelDefensa() - daño);
		}

	}
}

	
	