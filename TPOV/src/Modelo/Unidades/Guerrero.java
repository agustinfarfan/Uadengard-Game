package Modelo.Unidades;

public class Guerrero extends Heroe {

	public Guerrero (String nombre) {
		super(nombre, 100, 50, 30, 30, 0, 0);
	}

	public double atacar(Unidad defensor,int cantGolpes) {
		double daño = this.getNivelAtaque();
		if (defensor instanceof Troll) {
			daño = 300;
		} else {;
			if (cantGolpes >= 3){
				daño = daño * 2;
			}
		}
        return daño;
    }

	public void recibirDaño(Unidad atacante,double daño){
		double dañoSobrante = this.getNivelDefensa() - daño;
		if (dañoSobrante<=0){
			this.setNivelDefensa(0);
			this.setPuntosVida(this.getPuntosVida() + dañoSobrante);
		}
		else{
			this.setNivelDefensa(this.getNivelDefensa() - daño);
		}
	}
}
