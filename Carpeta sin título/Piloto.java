public class Piloto extends Persona {
	private String licencia;

	public Piloto (String nombre, String apellido, Pasaporte pasaporte, String licencia) {
		super(nombre, apellido, pasaporte);
		this.licencia = licencia;
	}
}