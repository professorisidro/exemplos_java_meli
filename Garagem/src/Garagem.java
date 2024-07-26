import java.util.List;

public class Garagem {
	private Integer id;
	private List<Veiculo> lista;
	public Garagem(Integer id, List<Veiculo> lista) {
		super();
		this.id = id;
		this.lista = lista;
	}
	public Garagem() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Veiculo> getLista() {
		return lista;
	}
	public void setLista(List<Veiculo> lista) {
		this.lista = lista;
	}
	
	

}
