package Modelo;
import Modelo.Mapa.*;
import Modelo.Mapa.UbicacionHostil;
import Modelo.Mejoras.*;
import Modelo.Misiones.*;
import Modelo.Unidades.*;
import Modelo.Pelea.*;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private static Juego instancia;
    private Heroe heroe;
    public Mapa mapa;
    private List<MisionSecundaria> misiones;
    private List<Ubicacion> ubicaciones;
    private List<Criatura> criaturas;
    private Pelea peleaActual;


    // Constructor privado para el patrón Singleton
    private Juego() {
        this.mapa = new Mapa();
        this.misiones = new ArrayList<MisionSecundaria>();
        iniciarJuego();
    }

    // Método para obtener la única instancia de Juego
    public static Juego getInstance() {
        if (instancia == null) {
            instancia = new Juego();
        }
        return instancia;
    }

    // Método para inicializar el héroe, ubicaciones, misiones y recompensas
    private void iniciarJuego() {
        configurarMisiones();
        configurarUbicaciones();
    }

    public void configurarHeroeDesdeUsuario(String nombre, String tipo) {
        configurarHeroe(nombre, tipo);
    }

    public void configurarHeroe(String nombre, String tipo) {
        switch (tipo) {
            case "Guerrero" -> heroe = new Guerrero(nombre);
            case "Mago" -> heroe = new Mago(nombre);
            case "Arquero" -> heroe = new Arquero(nombre);
        }
    }

    public Heroe getHeroe(){
        return heroe;
    }

    private void configurarUbicaciones() {
        Ubicacion montañasHeladas = new UbicacionHostil ("Montañas Heladas", heroe,false, false );
        Ubicacion bosqueSusurros = new UbicacionHostil("Bosque de los Susurros",heroe,false, false );
        Ubicacion pantanoOscuro = new UbicacionHostil("Pantano Oscuro",  heroe,false, false );
        Ubicacion aldeaSirith = new UbicacionHostil("Aldea de los Sirith", heroe,false, false );
        Ubicacion temploEncantado = new UbicacionHostil("Templo Encantado", heroe,true, false );
        Ubicacion villaDelSol = new UbicacionNeutral ("Villa del Sol", heroe,misiones);
        Ubicacion ciudadDelFuego = new UbicacionNeutral("Ciudad del Fuego",heroe,misiones);
        Ubicacion valleGrande = new UbicacionNeutral("Valle Grande", heroe,misiones);

        ubicaciones = new ArrayList<>();
        ubicaciones.add(montañasHeladas);
        ubicaciones.add(bosqueSusurros);
        ubicaciones.add(pantanoOscuro);
        ubicaciones.add(aldeaSirith);
        ubicaciones.add(temploEncantado);
        ubicaciones.add(villaDelSol);
        ubicaciones.add(ciudadDelFuego);
        ubicaciones.add(valleGrande);

        crearEnemigos();
        agregarEnemigosAUbicaciones();

        mapa.agregarUbicacionAMapa(montañasHeladas);
        mapa.agregarUbicacionAMapa(bosqueSusurros);
        mapa.agregarUbicacionAMapa(pantanoOscuro);
        mapa.agregarUbicacionAMapa(aldeaSirith);
        mapa.agregarUbicacionAMapa(villaDelSol);
        mapa.agregarUbicacionAMapa(ciudadDelFuego);
        mapa.agregarUbicacionAMapa(valleGrande);
        mapa.agregarUbicacionAMapa(temploEncantado);

        mapa.agregarCamino(valleGrande, bosqueSusurros);
        mapa.agregarCamino(bosqueSusurros, valleGrande);
        mapa.agregarCamino(bosqueSusurros, montañasHeladas);
        mapa.agregarCamino(montañasHeladas, bosqueSusurros);
        mapa.agregarCamino(montañasHeladas, aldeaSirith);
        mapa.agregarCamino(aldeaSirith, montañasHeladas);
        mapa.agregarCamino(valleGrande, ciudadDelFuego);
        mapa.agregarCamino(ciudadDelFuego, valleGrande);
        mapa.agregarCamino(ciudadDelFuego, villaDelSol);
        mapa.agregarCamino(villaDelSol, ciudadDelFuego);
        mapa.agregarCamino(ciudadDelFuego, temploEncantado);
        mapa.agregarCamino(aldeaSirith, ciudadDelFuego);
        mapa.agregarCamino(aldeaSirith, temploEncantado);
        mapa.agregarCamino(temploEncantado, aldeaSirith);
        mapa.agregarCamino(aldeaSirith, pantanoOscuro);
        mapa.agregarCamino(pantanoOscuro, aldeaSirith);
        mapa.agregarCamino(villaDelSol, pantanoOscuro);
        mapa.agregarCamino(pantanoOscuro, villaDelSol);

        mapa.setUbicacionActual(valleGrande); //ubicacion inicial

    }
    private void crearEnemigos() {
        criaturas = new ArrayList<>();

        // Para pantanoOscuro
        criaturas.add(new Espectro("Jeff"));
        criaturas.add(new Espectro("Tom"));
        criaturas.add(new Espectro("Jerry"));
        criaturas.add(new Espectro("Gus"));
        criaturas.add(new Espectro("Espe"));

        // Para montañasHeladas
        criaturas.add(new Dragon("Dragón del Norte"));

        // Para bosqueSusurros
        criaturas.add(new Espectro("Juan"));
        criaturas.add(new Espectro("Berto"));

        // Para aldeaSirith
        criaturas.add(new Troll("Mario"));
        criaturas.add(new Troll("Ian"));
        criaturas.add(new Troll("Messi"));

        // Para temploEncantado
        criaturas.add(new Troll("Primero"));
        criaturas.add(new Espectro("Segundo"));
        criaturas.add(new Dragon("Dragón del Templo"));
    }

    private void agregarEnemigosAUbicaciones() {
        for (Criatura criatura : criaturas) {
            switch (criatura.getNombre()) {
                case "Jeff", "Tom", "Jerry", "Gus", "Espe" -> {
                    Ubicacion pantanoOscuro = buscarUbicacion("Pantano Oscuro");
                    if (pantanoOscuro != null) {
                        pantanoOscuro.agregarCriaturaALista(criatura);
                    }
                }
                case "Dragón del Norte" -> {
                    Ubicacion montañasHeladas = buscarUbicacion("Montañas Heladas");
                    if (montañasHeladas != null) {
                        montañasHeladas.agregarCriaturaALista(criatura);
                    }
                }
                case "Juan", "Berto" -> {
                    Ubicacion bosqueSusurros = buscarUbicacion("Bosque de los Susurros");
                    if (bosqueSusurros != null) {
                        bosqueSusurros.agregarCriaturaALista(criatura);
                    }
                }
                case "Mario", "Ian", "Messi" -> {
                    Ubicacion aldeaSirith = buscarUbicacion("Aldea de los Sirith");
                    if (aldeaSirith != null) {
                        aldeaSirith.agregarCriaturaALista(criatura);
                    }
                }
                case "Primero", "Segundo", "Dragón del Templo" -> {
                    Ubicacion temploEncantado = buscarUbicacion("Templo Encantado");
                    if (temploEncantado != null) {
                        temploEncantado.agregarCriaturaALista(criatura);
                    }
                }
            }
        }
    }

    // Método auxiliar para buscar una ubicación por nombre
    private Ubicacion buscarUbicacion(String nombre) {
        for (Ubicacion ubicacion : ubicaciones) {
            if (ubicacion.getNombre().equalsIgnoreCase(nombre)) {
                return ubicacion;
            }
        }
        return null;
    }

    private void configurarMisiones() {
        misiones= new ArrayList<>();

        Recompensa recompensaDragon = new Recompensa("Espada de Fuego", 20, 0,0);
        MisionSecundaria misionDragon = new MisionDerrotarDragon(recompensaDragon);
        misiones.add(misionDragon);

        Recompensa recompensaAmuleto = new Recompensa("Amuleto de Protección", 0,15,0);
        MisionSecundaria misionAmuleto = new MisionRecuperarAmuleto(recompensaAmuleto);
        misiones.add(misionAmuleto);

        Recompensa recompensaEspectros = new Recompensa("Arco de Luz", 25,0,0);
        MisionSecundaria misionEspectros = new MisionPantanoOscuro(recompensaEspectros);
        misiones.add(misionEspectros);

        Recompensa recompensaTrolls = new Recompensa("Escudo de Titanio", 0,0,30);
        MisionSecundaria misionTrolls = new MisionAldeaDeLosTrolls(recompensaTrolls);
        misiones.add(misionTrolls);

    }

    public void descansarHeroe() {
        Mejoras.descansar(heroe);
    }

    public String mejorarAtaqueHeroe() {
        return Mejoras.mejorarAtaque(heroe);
    }

    public String mejorarVidaHeroe() {
        return Mejoras.mejorarVida(heroe);
    }

    public String mejorarDefensaHeroe() {
        return Mejoras.mejorarDefensa(heroe);
    }

    public String getEstadisticasHeroe() {
        if (heroe instanceof Arquero){
            return "Heroe: " + heroe.getNombre() +
                    "\nVida: " + heroe.getPuntosVida() +
                    "\nAtaque: " + heroe.getNivelAtaque() +
                    "\nDefensa: " + heroe.getNivelDefensa() +
                    "\nPunteria: " + heroe.getPunteria() +
                    "\nAgilidad: " + heroe.getAgilidad() +
                    "\nExperiencia: " + heroe.getExp();
        }
        else{
            return "Heroe: " + heroe.getNombre() +
                    "\nVida: " + heroe.getPuntosVida() +
                    "\nAtaque: " + heroe.getNivelAtaque() +
                    "\nDefensa: " + heroe.getNivelDefensa() +
                    "\nExperiencia: " + heroe.getExp();
        }
    }

    public Ubicacion getUbicacionActual() {
        return mapa.getUbicacionActual();
    }

    public void setUbicacionActual(Ubicacion ubicacion) {
        mapa.setUbicacionActual(ubicacion);
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public List<MisionSecundaria> getMisiones() {
        return misiones;
    }

    public String getObjetivo(MisionSecundaria misionSecundaria){
        return misionSecundaria.getObjetivo();
    }

    public String getNombreMision(MisionSecundaria misionSecundaria){
        return misionSecundaria.getNombre();
    }

    public String getEstadoMision(MisionSecundaria misionSecundaria){
        return misionSecundaria.getEstado();
    }

    public boolean puedeViajar(Ubicacion origen, Ubicacion destino){
        return mapa.puedeViajar(origen,destino);
    }

    public String getNombreUbicacion(Ubicacion ubicacion) {
        return ubicacion.getNombre();
    }

    public void reclamarRecompensas(MisionSecundaria misionSecundaria) {
        misionSecundaria.reclamarRecompensa();
    }

    public List<Criatura> getCriaturasUbicacionActual(Ubicacion ubicacion){
        return ubicacion.getCriaturasFromLista();
    }

    public List<String> getNombreCriaturas(List<Criatura> criaturas) {
        List<String> nombres = new ArrayList<>();
        for (Criatura criatura : criaturas) {
            nombres.add(criatura.getNombre()); // Suponiendo que Criatura tiene un método getNombre()
        }
        return nombres;
    }

    public boolean iniciarPelea(Heroe heroe,List<Criatura> criaturas,List<MisionSecundaria> misionesSecundarias, Ubicacion ubicacionActual){
        peleaActual=new Pelea(heroe,criaturas,misiones,ubicacionActual);
        return peleaActual.iniciarPelea();
    }

    public double getExp(Heroe heroe){
        return heroe.getExp();
    }

    public boolean getCriaturasVencidas(Ubicacion ubicacion){
        return ubicacion.getCriaturasVencidas();
    }

    public boolean getEsTesoro(Ubicacion ubicacion){
        return ubicacion.esTesoro();
    }

    public boolean getEnemigoVencido(Ubicacion ubicacion){
        return ubicacion.getCriaturasVencidas();
    }

}
