package vehiculos;
import java.util.HashMap;
import java.util.Map;

public class Vehiculo {
	private String placa;
	private int puertas;
	private int velocidadMaxima;
	private String nombre;
	private int precio;
	private int peso;
	private String traccion;
	private Fabricante fabricante;
	private static int CantidadVehiculos;
	private static Map<String, Integer> ventasPorPais = new HashMap<>();
    private static Map<String, Integer> ventasPorFabricante = new HashMap<>();
    
	public static String vehiculosPorTipo() {
        return "Automoviles: " + Automovil.getCantidad() + "\n" +
               "Camionetas: " + Camioneta.getCantidad() + "\n" +
               "Camiones: " + Camion.getCantidad();
    }
	
	public Vehiculo(String placa, int puertas, int velocidadMaxima, String nombre, int precio, int peso, String traccion, Fabricante fabricante) {
		this.placa = placa;
		this.puertas = puertas;
		this.velocidadMaxima = velocidadMaxima;
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
		this.traccion = traccion;
		this.fabricante = fabricante;
		CantidadVehiculos++;
		
		String pais = fabricante.getPais();
        String nombreFabricante = fabricante.getNombre();

        ventasPorPais.put(pais, ventasPorPais.getOrDefault(pais, 0) + 1);
        ventasPorFabricante.put(nombreFabricante, ventasPorFabricante.getOrDefault(nombreFabricante, 0) + 1);
	}
	
    public static String paisMasVendedor() {
        return ventasPorPais.entrySet().stream()
        	.max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    public static String fabricaMayorVentas() {
    	return ventasPorFabricante.entrySet().stream()
	        .max(Map.Entry.comparingByValue())
	        .map(Map.Entry::getKey)
	        .orElse(null);
    }
}
	
    // Métodos get
	public String getPlaca() {
        return placa;
    }

    public int getPuertas() {
        return puertas;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPeso() {
        return peso;
    }

    public String getTraccion() {
        return traccion;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public static int getCantidadVehiculos() {
        return CantidadVehiculos;
    }

    // Métodos set
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

}
