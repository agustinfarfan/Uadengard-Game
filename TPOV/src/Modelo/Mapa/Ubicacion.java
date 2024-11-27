package Modelo.Mapa;

import Modelo.Unidades.Criatura;
import Modelo.Unidades.Heroe;

import java.util.List;

public abstract class Ubicacion {
    private String nombre;
    private Heroe heroe;

    public  Ubicacion( String nombre,Heroe heroe ){
        this.nombre = nombre;
        this.heroe = heroe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Heroe getHeroe() {
        return heroe;
    }
    public void agregarCriaturaALista(Criatura criatura) {//no hace nada
    }

    public void setHeroe(Heroe heroe) {
        this.heroe = heroe;
    }

    public List<Criatura> getCriaturasFromLista(){
        return null;
    }

    public void setCriaturasVencidasTrue(){
    }

    public boolean getCriaturasVencidas(){
        return false;
    }

    public boolean esTesoro(){
        return false;
    }

}
