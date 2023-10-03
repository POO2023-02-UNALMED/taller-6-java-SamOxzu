package vehiculos;

public class pruebas {
	public static void main(String[]) {
		Vehiculo.setCantidadVehiculos(0);
		Fabricante f = new Fabricante("Renault", p);
		Camion c1 =  new Camion("SS", "Camion premium", 1000, 100, f, 3);
		Camion c2 =  new Camion("AA", "Camion", 1000, 100, f, 3);
		Automovil a1 =  new Automovil("NN", "Mac 100", 820, 20, f, 4);
		Camioneta ca1 =  new Camioneta("CC", 5, "Ford", 500, 150, f, true);
		
		System.out.println(Vehiculo.getCantidadVehiculos());
	}
}
