import java.util.HashMap;

public class Benchmark {
	public static void main(String[] args) {
		int TAM = 100000;
		int NUMBUSCAS = 10000;
		int COD_A_SER_BUSCADO=TAM;
		
		/*
		// inserindo produtos na lista 
		ArrayList<Produto> lista = new ArrayList<Produto>();
		for (int i=1; i<= TAM; i++) {
			lista.add(new Produto(i,"Produto"+i,i*100.0));
		}
		
		
		// vou fazer várias buscas em uma lista 
		long ini = System.currentTimeMillis();
		for (int cont=0;cont<NUMBUSCAS; cont++) {
			for (Produto p: lista) {
				if (p.getId() == COD_A_SER_BUSCADO) {
					break;
				}
			}
		}
		long fim = System.currentTimeMillis();
		*/
		
		HashMap<Integer, Produto> mapa = new HashMap<Integer,Produto>();
		for (int i=1; i<=TAM; i++) {
			mapa.put(i, new Produto(i,"Produto"+i,i*100.0));
		}
		
		long ini = System.currentTimeMillis();
		for (int cont = 0; cont < NUMBUSCAS; cont++) {
			Produto p = mapa.get(COD_A_SER_BUSCADO);			
		}
		long fim = System.currentTimeMillis();
		
		System.out.println("A busca durou: "+(fim-ini)+"ms");
		
	}

}
