import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Hacker {
	public static void explore(Class classe) {
		try {
			System.out.println("Classe: "+classe.getName());
			System.out.println("------------------------------------------");
			System.out.println("Atributos: ");
			for (Field f: classe.getDeclaredFields()) {
				System.out.println("\t-"+f.getName()+" - "+f.getType().getName());
			}
			System.out.println("Metodos: ");
			for (Method m: classe.getDeclaredMethods()) {
				System.out.println("\t+"+m.getName()+" - "+m.getReturnType().getName());
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
