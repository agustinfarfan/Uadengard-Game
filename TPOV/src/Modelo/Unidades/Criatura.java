package Modelo.Unidades;

public abstract class Criatura extends Unidad {

	public Criatura(String nombre, double puntosVida, double nivelAtaque, double nivelDefensa, int exp) {
		super(nombre, puntosVida, nivelAtaque, nivelDefensa, exp);
	}

	public abstract double atacar(Unidad defensor,int cantGolpes);

	public abstract void recibirDaño(Unidad atacante,double daño);

}
