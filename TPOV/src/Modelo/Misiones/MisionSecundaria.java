package Modelo.Misiones;

import Modelo.Mapa.Ubicacion;
import Modelo.Unidades.Criatura;
import Modelo.Unidades.Heroe;

public abstract class MisionSecundaria {
 private String nombre;
 private String objetivo;
 private String estado;
 private Recompensa recompensa;

 public MisionSecundaria(String nombre, String objetivo, Recompensa recompensa) {
  this.nombre = nombre;
  this.objetivo = objetivo;
  this.estado = "Disponible";
  this.recompensa = recompensa;
 }

 public void completarMision() {
  estado = "Reclamar Recompensas";
 }

 public void verificarProgreso(Criatura criatura, Ubicacion ubicacion) {
 }

 public String estaCompletada() {
  return estado;
 }

 public void reclamarRecompensa() {
  if (estado.equals("Reclamar Recompensas")) {
   estado="Reclamada";
  }
 }

 public String getNombre() {
  return nombre;
 }

 public String getObjetivo() {
  return objetivo;
 }

 public String getEstado(){ return estado;}

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

 public void actualizarRecompensas() {
  estado="Reclamada";
 }


}