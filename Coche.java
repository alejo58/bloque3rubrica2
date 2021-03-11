package RepasoConLosCabros;

public class Coche implements Vehiculo {
	private int caballos;
	private String nombre;
	public Coche(int caballos, String nombre) {
		super();
		this.caballos = caballos;
		this.nombre = nombre;
	}
	public int getCaballos() {
		return caballos;
	}
	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void acelerar() {
		System.out.println("Coche acelera");
	}
	
	@Override
	public void frenar(int velocidadActual) {
		System.out.println("Coche frena");
	}
	
	
}
