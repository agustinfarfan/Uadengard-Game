package Modelo.Unidades;

public abstract class Unidad {
	private String nombre;
	private double puntosVida;
	private double nivelAtaque;
	private double nivelDefensa;
	private int exp;

	public Unidad(String nombre, double puntosVida, double nivelAtaque, double nivelDefensa, int exp) {
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.nivelAtaque = nivelAtaque;
		this.nivelDefensa = nivelDefensa;
		this.exp = exp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(double puntosVida) {
		this.puntosVida = puntosVida;
	}

	public double getNivelAtaque() {
		return nivelAtaque;
	}

	public void setNivelAtaque(double nivelAtaque) {
		this.nivelAtaque = nivelAtaque;
	}

	public double getNivelDefensa() {
		return nivelDefensa;
	}

	public void setNivelDefensa(double nivelDefensa) {
		this.nivelDefensa = nivelDefensa;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean estaVivo() {
		return puntosVida > 0;
	}

	public abstract double atacar(Unidad defensor,int cantGolpes);

	public abstract void recibirDaño(Unidad atacante,double daño);
}
