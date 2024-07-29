package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Roupa;

public class GuardaRoupa {
	private Map<Integer, List<Roupa>> map;
	private Integer contador;
	
	public GuardaRoupa() {
		this.map =  new HashMap<Integer,List<Roupa>>();
		this.contador = 0;
	}
	
	public Integer guardarRoupa(List<Roupa> lista) {
		this.contador++;
		this.map.put(contador, lista);
		return contador;
	}
	
	public void mostrarRoupas() {
		for (Integer i: this.map.keySet()) {
			System.out.println(i + " - "+map.get(i));
		}
	}
	
	public List<Roupa> consultarRoupas(Integer key){
		return map.get(key);
	}
	public List<Roupa> devolverRoupas(Integer key){
		List<Roupa> lista = map.remove(key);
		return lista;
	}
}
