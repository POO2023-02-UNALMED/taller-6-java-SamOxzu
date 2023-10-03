package vehiculos;
import java.util.ArrayList;
import java.util.List;

public class Fabricante {
	private String nombre;
	private Pais pais;
	private static List<Fabricante> todosLosFabricantes = new ArrayList<>();
	
	
	public Fabricante(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
		todosLosFabricantes.add(this);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public static Fabricante fabricaMayorVentas() {
		return todosLosFabricantes.stream()
	            .collect(Collectors.groupingBy(Fabricante::getNombre, Collectors.counting()))
	            .entrySet().stream()
	            .max(Map.Entry.comparingByValue())
	            .map(entry -> todosLosFabricantes.stream()
	                .filter(fabricante -> fabricante.getNombre().equals(entry.getKey()))
	                .findFirst().orElse(null))
	            .orElse(null);
	    }
}
