package vehiculos;
import java.util.ArrayList;
import java.util.List;

public class Pais {
	private String nombre;
	private static List<Pais> todosLosPaises = new ArrayList<>();
	
	public Pais(String nombre) {
		this.nombre = nombre;
		todosLosPaises.add(this);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static Pais paisMasVendedor() {
		return todosLosPaises.stream()
	            .collect(Collectors.groupingBy(Pais::getNombre, Collectors.counting()))
	            .entrySet().stream()
	            .max(Map.Entry.comparingByValue())
	            .map(entry -> todosLosPaises.stream()
	                .filter(pais -> pais.getNombre().equals(entry.getKey()))
	                .findFirst().orElse(null))
	            .orElse(null);
	}
}
