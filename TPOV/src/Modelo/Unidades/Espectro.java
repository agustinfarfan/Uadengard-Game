package Modelo.Unidades;


public class Espectro extends Criatura {

    public Espectro(String nombre) {
        super(nombre, 50, 40, 50, 90);
    }


    @Override
    public double atacar(Unidad defensor,int cantGolpes) {
        double daño = this.getNivelAtaque();
        if (defensor instanceof Arquero) {
            daño += daño * 0.20;
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