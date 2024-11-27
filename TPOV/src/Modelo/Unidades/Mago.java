package Modelo.Unidades;

public class Mago extends Heroe{

	public Mago(String nombre) {
		super(nombre, 100, 60, 10,40, 0,300);
	}

	@Override
	public double atacar(Unidad defensor,int cantGolpes) {
        return this.getNivelAtaque();

	}
	@Override
	public void recibirDaño(Unidad atacante,double daño){
		if (atacante instanceof Espectro) {
			System.out.print("Ataque evadido");
		}
			else {
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
		

	

