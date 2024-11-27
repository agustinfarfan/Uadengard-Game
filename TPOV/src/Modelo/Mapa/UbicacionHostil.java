package Modelo.Mapa;
import Modelo.Unidades.Criatura;
import Modelo.Unidades.Heroe;
import Modelo.Pelea.Pelea;
import java.util.ArrayList;
import java.util.List;

public class UbicacionHostil extends Ubicacion {
	private boolean esTesoro;
	private boolean criaturasVencidas;
	private List<Criatura> criaturas;
	private Heroe heroe;

	public UbicacionHostil(String nombre, Heroe heroe, boolean esTesoro, boolean criaturasVencidas) {
		super(nombre, heroe);
		this.esTesoro = esTesoro;
		this.criaturasVencidas = criaturasVencidas;
		this.criaturas = new ArrayList<>();
		this.heroe = heroe;
	}

	public void agregarCriaturaALista(Criatura criatura) {
		criaturas.add(criatura);
	}

	@Override
	public List<Criatura> getCriaturasFromLista() {
		return criaturas;
	}

	public void setCriaturasVencidasTrue(){
		criaturasVencidas = true;
	}

	@Override
	public boolean getCriaturasVencidas(){
		return criaturasVencidas;
	}

	@Override
	public boolean esTesoro(){
		return esTesoro;
	}

}