public class Pasajero extends Persona {
	private int numeroAsiento;

	public Pasajero(String nombre, String apellido, Pasaporte pasaporte, int numeroAsiento) {
		super(nombre, apellido, pasaporte);
		this.numeroAsiento = numeroAsiento;
	}

	public int getNumeroAsiento() {
		return numeroAsiento;
	}
	
	public void cancelarPasaje(Vuelo vuelo) {
		vuelo.eliminarPasajero(this);
	}
	
}