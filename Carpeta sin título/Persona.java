public class Persona {
	private String nombre;
	private String apellido;
	private Pasaporte pasaporte;

    public Persona(String apellido, String nombre, Pasaporte pasaporte) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}
	
	public String getNombre() {
        return nombre;
	}
	
	public boolean validarPasaporte() {
		return pasaporte.isValido();
	}
}