package vehiculos;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Pais {
	private String nombre;
	
	public Pais(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static Pais paisMasVendedor() {
        return Vehiculo.ventasPorPais.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(entry -> {
                for (Fabricante fabricante : Vehiculo.todosLosFabricantes) {
                    if (fabricante.getPais().getNombre().equals(entry.getKey())) {
                        return fabricante.getPais();
                    }
                }
                return null;
            })
            .orElse(null);
    }
}
}
