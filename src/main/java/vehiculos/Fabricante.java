package vehiculos;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Fabricante {
	private String nombre;
	private Pais pais;
	
	public Fabricante(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
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
        return Vehiculo.ventasPorFabricante.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(entry -> {
                for (Fabricante fabricante : Vehiculo.todosLosFabricantes) {
                    if (fabricante.getNombre().equals(entry.getKey())) {
                        return fabricante;
                    }
                }
                return null;
            })
            .orElse(null);
    }
}
}
