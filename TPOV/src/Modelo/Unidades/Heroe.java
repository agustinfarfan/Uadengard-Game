package Modelo.Unidades;

public abstract class Heroe extends Unidad {
	private double agilidad;
	private double punteria;

	public Heroe(String nombre, double puntosVida, double nivelAtaque, double nivelDefensa, double agilidad, double punteria, int exp) {
		super(nombre, puntosVida, nivelAtaque, nivelDefensa, exp);
		this.agilidad = agilidad;
		this.punteria = punteria;
	}

	public double getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(double agilidad) {
		this.agilidad = agilidad;
	}

	public double getPunteria() {
		return punteria;
	}

	public void setPunteria(double punteria) {
		this.punteria = punteria;
	}

	public void ganarExperiencia(int exp ){this.setExp( this.getExp()+ exp);}

	public abstract double atacar(Unidad defensor, int cantGolpes);

	public abstract void recibirDaño(Unidad atacante,double daño);



}

